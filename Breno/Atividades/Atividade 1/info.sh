#!/bin/bash
# Script para exibir informações básicas do sistema

echo "Data e Hora atuais: $(date)"
echo "Usuário logado: $(whoami)"
echo "Diretório atual: $(pwd)"

echo ""
echo "Espaço livre no disco:"
df -h /
