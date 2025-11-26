#!/bin/bash

# Script: bitcoin_alert.sh
# Monitoramento do valor do Bitcoin e criação de issue no GitHub

API_URL="https://cointradermonitor.com/api/pbb/v1/ticker"
TARGET=${1:-500000}

# Obtém o valor atual usando curl e jq
value=$(curl -s $API_URL | jq '.ticker.last')

# Log de execução
echo "$(date '+%Y-%m-%d %H:%M') - Valor atual: R$${value}" >> bitcoin_log.txt

# Compara o valor com o limite
if (( $(echo "$value < $TARGET" | bc -l) )); then
    gh issue create         --title "Alerta: Valor do Bitcoin caiu abaixo de R\$${TARGET}!"         --body "O valor atual do Bitcoin é R\$${value} em $(date '+%d/%m/%Y %H:%M')."
fi
