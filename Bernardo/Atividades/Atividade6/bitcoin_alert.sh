#!/usr/bin/env bash
# bitcoin_alert.sh
# Monitora o preço do Bitcoin na API CoinTraderMonitor e cria uma issue no GitHub
# caso o valor caia abaixo do alvo.
#
# Uso:
#   ./bitcoin_alert.sh [TARGET]
# Ex: ./bitcoin_alert.sh 480000
#
# Dependências: curl, jq, bc, gh (GitHub CLI)
# Opcional: defina a variável de ambiente GITHUB_REPO no formato "owner/repo" para criar issues em um repo específico.
set -euo pipefail

API_URL="https://cointradermonitor.com/api/pbb/v1/ticker"
TARGET="${1:-500000}"             # valor alvo padrão 500000 se não passado como argumento
LOG_FILE="${LOG_FILE:-$(dirname "$0")/bitcoin_log.txt}"
CSV_FILE="${CSV_FILE:-$(dirname "$0")/bitcoin_history.csv}"
REPO_OPT=""

# Se GITHUB_REPO estiver definido, adiciona --repo para os comandos gh
if [ -n "${GITHUB_REPO:-}" ]; then
  REPO_OPT="--repo ${GITHUB_REPO}"
fi

# Checa dependências
for cmd in curl jq gh bc; do
  if ! command -v "$cmd" >/dev/null 2>&1; then
    echo "Erro: '$cmd' não encontrado. Instale '$cmd' antes de rodar o script." >&2
    exit 1
  fi
done

# Obtem a resposta da API
resp="$(curl -sS "$API_URL")" || { echo "Erro ao consultar API"; exit 1; }

# Extrai o campo last
value="$(echo "$resp" | jq -r '.ticker.last')"
if [ -z "$value" ] || [ "$value" = "null" ]; then
  echo "Erro: não foi possível obter o campo 'last' da API." >&2
  exit 1
fi

# Normaliza valor (garante que seja um número com ponto decimal)
# Se value já for numérico, ok. Caso contrário, tenta remover vírgulas e outros.
value_clean="$(echo "$value" | tr -d '[:space:]' | tr ',' '.')"

timestamp="$(date '+%Y-%m-%d %H:%M:%S')"

# Log em texto e csv
echo "${timestamp} - Valor atual: R\$${value_clean}" >> "$LOG_FILE"
# cria cabeçalho no csv se não existir
if [ ! -f "$CSV_FILE" ]; then
  echo "datetime,value" > "$CSV_FILE"
fi
echo "${timestamp},${value_clean}" >> "$CSV_FILE"

# Compara numericamente com bc
if (( $(echo "$value_clean < $TARGET" | bc -l) )); then
  title="Alerta: Valor do Bitcoin caiu abaixo de R\\$${TARGET}!"
  body="O valor atual do Bitcoin é R\$${value_clean} em ${timestamp}.\n\nOrigem: ${API_URL}"

  # Verifica se já existe uma issue aberta com o mesmo título
  existing_titles="$(gh issue list $REPO_OPT --state open --json title --jq '.[] | .title' 2>/dev/null || true)"

  if printf '%s\n' "$existing_titles" | grep -Fxq "$title"; then
    echo "${timestamp} - Issue já existe (não será criada novamente)." >> "$LOG_FILE"
  else
    # Cria a issue
    if gh issue create $REPO_OPT --title "$title" --body "$body"; then
      echo "${timestamp} - Issue criada: $title" >> "$LOG_FILE"
    else
      echo "${timestamp} - Falha ao criar issue." >> "$LOG_FILE"
    fi
  fi
else
  echo "${timestamp} - Sem alerta (acima do limite)." >> "$LOG_FILE"
fi

exit 0