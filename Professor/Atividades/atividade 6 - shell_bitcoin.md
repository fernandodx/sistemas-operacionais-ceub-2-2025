# 🧩 Desafio Shell Script — Monitor de Bitcoin

## 🎯 Objetivo

Criar um **script em Shell (Bash)** que monitore o valor atual do Bitcoin em reais (BRL) e te **alerte automaticamente** quando o preço cair abaixo de um valor alvo.  
Quando o valor estiver abaixo do limite definido, o script deve **criar uma issue no GitHub** informando que o valor do Bitcoin caiu.

---

## 🧠 Descrição da Tarefa

1. Acesse o endpoint público da CoinTraderMonitor:  
   ```
   https://cointradermonitor.com/api/pbb/v1/ticker
   ```

2. A partir da resposta JSON, obtenha o **valor atual do Bitcoin** (campo `last`).

3. Compare o valor obtido com o **valor alvo de R$500.000**.

4. Se o valor atual for **menor que R$500.000**, o script deve **criar uma issue no GitHub** informando a queda.  
   - O título da issue pode ser algo como:  
     ```
     Alerta: Valor do Bitcoin caiu abaixo de R$500.000!
     ```
   - E a descrição pode incluir o valor atual e a data/hora da verificação.

5. O script deve ser executado **automaticamente a cada 6 horas**, utilizando o `cron` do Linux.

---

## 🧩 Requisitos Técnicos

- Linguagem: **Bash**
- Dependências:
  - `curl` (para consumir a API)
  - `jq` (para tratar o JSON)
  - `gh` (CLI do GitHub, para criar issues)
- Conta GitHub autenticada via `gh auth login`.

---

## 💡 Dicas e Boas Práticas

- Use o `jq` para extrair o campo `last`:
  ```bash
  value=$(curl -s https://cointradermonitor.com/api/pbb/v1/ticker | jq '.ticker.last')
  ```

- Para comparar valores numéricos em Bash, utilize:
  ```bash
  if (( $(echo "$value < 500000" | bc -l) )); then
      echo "Valor abaixo do limite!"
  fi
  ```

- Para criar uma issue com o GitHub CLI:
  ```bash
  gh issue create --title "Bitcoin abaixo de R$500.000"                   --body "O valor atual do Bitcoin é R\$$value em $(date '+%d/%m/%Y %H:%M')."
  ```

- Crie um log simples para registrar as execuções:
  ```bash
  echo "$(date '+%Y-%m-%d %H:%M') - Valor atual: R\$$value" >> bitcoin_log.txt
  ```

---

## 📚 Desafio Extra (opcional)

1. Permita que o **valor alvo** seja passado como argumento:
   ```bash
   ./bitcoin_alert.sh 480000
   ```

2. Envie também uma **notificação no Discord ou Telegram**.

3. Armazene o histórico dos valores em um arquivo `.csv` com data e hora.

---
