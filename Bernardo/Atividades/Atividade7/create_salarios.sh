#!/usr/bin/env bash
# create_salarios.sh
# Cria o arquivo salarios.txt com conteúdo simulado sensível.
set -euo pipefail

FILE="salarios.txt"

echo "Criando ${FILE} com conteúdo sensível (simulado)..."
echo "Salario do Diretor: R$ 50.000" > "${FILE}"
echo "Arquivo criado em: $(date '+%Y-%m-%d %H:%M:%S')"
echo
echo "Saída de ls -l:"
ls -l "${FILE}"
echo
echo "Para proteger este arquivo, execute: ./permissions_demo.sh"