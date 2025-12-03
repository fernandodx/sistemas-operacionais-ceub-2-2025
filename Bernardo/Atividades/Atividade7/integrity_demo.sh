#!/usr/bin/env bash
# integrity_demo.sh
# Gera hash SHA-256 inicial, simula uma alteração e compara hashes.
set -euo pipefail

FILE="salarios.txt"
HASH_FILE=".salarios.sha256"

if [ ! -f "${FILE}" ]; then
  echo "Arquivo ${FILE} não encontrado. Rode ./create_salarios.sh primeiro."
  exit 1
fi

if ! command -v sha256sum >/dev/null 2>&1; then
  echo "sha256sum não encontrado. Instale coreutils (em muitos sistemas já vem instalado)."
  exit 1
fi

echo "Gerando hash SHA-256 inicial para ${FILE}..."
sha256sum "${FILE}" | tee "${HASH_FILE}"
echo "Hash salva em ${HASH_FILE}"
echo

read -p "Deseja simular uma alteração no arquivo (sobrescrever com novo salário)? [s/N] " resp
resp=${resp:-N}
if [[ "$resp" =~ ^[sS] ]]; then
  echo "Simulando alteração maliciosa..."
  echo "Salario do Diretor: R$ 90.000" > "${FILE}"
  echo "Novo conteúdo escrito."
  echo
fi

echo "Verificando hash atual e comparando com o salvo..."
current_hash=$(sha256sum "${FILE}" | awk '{print $1}')
saved_hash=$(awk '{print $1}' "${HASH_FILE}")

echo "Hash salvo:    ${saved_hash}"
echo "Hash atual:    ${current_hash}"
echo

if [ "${current_hash}" = "${saved_hash}" ]; then
  echo "OK: hashes iguais -> arquivo NÃO foi alterado."
else
  echo "ALERTA: hashes diferentes -> arquivo foi alterado!"
fi

echo
echo "Mostrando conteúdo atual do arquivo (para inspeção):"
echo "-----"
cat "${FILE}"
echo "-----"