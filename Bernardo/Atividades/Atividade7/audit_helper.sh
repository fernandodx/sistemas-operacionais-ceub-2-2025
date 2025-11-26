#!/usr/bin/env bash
# audit_helper.sh
# Funções auxiliares para auditoria: mostrar owner/group, ACLs, e explicar chattr.
set -euo pipefail

FILE="salarios.txt"

echo "Audit helper para ${FILE}"
echo

if [ ! -f "${FILE}" ]; then
  echo "Arquivo ${FILE} não encontrado. Rode ./create_salarios.sh primeiro."
  exit 1
fi

echo "1) Dono e grupo (stat):"
if command -v stat >/dev/null 2>&1; then
  stat --format='owner: %U  uid: %u  group: %G  gid: %g' "${FILE}" || stat -f '%Su %Sg' "${FILE}"
else
  ls -l "${FILE}"
fi
echo

echo "2) ACLs (getfacl) — se instalado:"
if command -v getfacl >/dev/null 2>&1; then
  getfacl "${FILE}" || true
else
  echo "getfacl não instalado. Em Debian/Ubuntu: sudo apt install acl"
fi
echo

echo "3) Informações sobre chattr (atributo imutável):"
echo "O chattr +i torna o arquivo imutável (nem root pode editar sem remover o bit)."
echo "Uso (requere root): sudo chattr +i salarios.txt"
echo "Remover: sudo chattr -i salarios.txt"
echo "AVISO: chattr depende do sistema de arquivos (ext4, etc.) e requer privilégios."
echo

echo "4) Umask atual do shell:"
umask
echo

echo "Dicas:"
echo "- Para mudar dono: sudo chown novo_usuario:novo_grupo salarios.txt"
echo "- Para adicionar uma ACL: setfacl -m u:usuario:r-- salarios.txt"
echo