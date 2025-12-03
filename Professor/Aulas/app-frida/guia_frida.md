
````markdown
# Guia de Configuração: Laboratório de Pentest Android com Frida 

Este guia detalha o processo de criação de um ambiente de análise dinâmica de aplicativos Android utilizando o **Frida** em um ambiente **Unix**.

**Objetivo:** Configurar um emulador Android com acesso Root, instalar o servidor do Frida e executar um script de interceptação básica ("Hook").

---

## Pré-requisitos

1.  **Android Studio** instalado e configurado.
2.  **Python 3** Instalação.
3.  Conhecimento básico de terminal.

---

## Passo 1: Configuração do Emulador (AVD)

O segredo para ter acesso Root nativo no emulador oficial do Android Studio é escolher a imagem de sistema correta.

1.  Abra o **Android Studio** -> **Virtual Device Manager** -> **Create Device**.
2.  Escolha um hardware (ex: Pixel 4 ou Pixel 6).
3.  **Importante:** Na tela **System Image**, selecione uma imagem da aba **x86 Images** ou **Recommended** que tenha o Target **Google APIs** (e **NÃO** "Google Play").
    * *Nota:* Imagens "Google Play" são bloqueadas para produção. Imagens "Google APIs" são *UserDebug* e permitem root.
4.  Finalize a criação e inicie o emulador.

### Habilitando o Root
No terminal do seu macOS, execute:

```bash
# Reinicia o adb com permissões de root no emulador
adb root

# Teste o acesso (deve retornar "root")
adb shell whoami
````

-----

## Passo 2: Instalação  (Cliente)

Instale as ferramentas de linha de comando do Frida que controlam a injeção de scripts.

```bash
# Instala via pip
pip3 install frida-tools

# Verifica a instalação e a versão
frida --version
```

-----

## Passo 3: Instalação no Android (Servidor)

O `frida-server` é o binário que roda dentro do Android e se comunica com o seu Mac.

### 3.1. Descobrir a Arquitetura do Emulador

Antes de baixar, você precisa saber se seu emulador é x86, x86\_64 ou arm64.

```bash
adb shell getprop ro.product.cpu.abi
```

  * **Macs Intel:** Geralmente `x86_64`.
  * **Macs M1/M2/M3 (Apple Silicon):** Geralmente `arm64-v8a`.

### 3.2. Baixar o Frida Server

1.  Vá até as [Releases do Frida no GitHub](https://github.com/frida/frida/releases).
2.  Baixe o arquivo `frida-server` correspondente à versão do seu cliente (Passo 2) e arquitetura (Passo 3.1).
      * Exemplo: `frida-server-16.1.4-android-arm64.xz`

### 3.3. Instalar e Rodar

No terminal, navegue até a pasta onde baixou o arquivo:

```bash
# 1. Descompactar
unxz frida-server-*.xz

# 2. Renomear para facilitar (opcional, mas recomendado)
mv frida-server-*-android-* frida-server

# 3. Enviar para o emulador (pasta temporária)
adb push frida-server /data/local/tmp/

# 4. Dar permissão de execução e rodar
adb shell "chmod 755 /data/local/tmp/frida-server"
adb shell "/data/local/tmp/frida-server &"
```

> **Dica de Troubleshooting:** O `&` no final serve para rodar em background. Se o terminal travar, feche e abra outro, o servidor continuará rodando no Android.

-----

## Passo 4: Teste de Conexão

Verifique se o seu Mac consegue "enxergar" os processos do Android através do Frida.

```bash
# Lista os processos rodando no dispositivo USB/Emulador (-U)
frida-ps -U
```

**Sucesso:** Você verá uma lista de processos como `com.android.phone`, `adbd`, etc.

-----

## Passo 5: Exemplo Prático ("Hello World")

Vamos interceptar (Hook) a classe `Activity` para monitorar a navegação do usuário em tempo real.

### 5.1. Criar o Script

Crie um arquivo chamado `espiar.js` com o seguinte conteúdo:

```javascript
/* Arquivo: espiar.js
   Descrição: Monitora o método onResume() de todas as Activities
*/

console.log("[*] Injetando script...");

Java.perform(function () {
    // Referência à classe base de telas do Android
    var Activity = Java.use('android.app.Activity');

    // Hook (Gancho) no método onResume
    Activity.onResume.implementation = function () {
        
        // Pega o nome da classe atual que está sendo exibida
        var nomeDaTela = this.getClass().getName();
        
        console.log("");
        console.log("------------------------------------------");
        console.log("[👀] Tela detectada: " + nomeDaTela);
        console.log("------------------------------------------");

        // Executa o método original para não quebrar o app
        this.onResume();
    };
});
```

### 5.2. Executar a Injeção

Vamos usar o aplicativo de Configurações do Android como alvo.

```bash
# -U: USB/Emulador
# -l: Carregar script local
# -f: Forçar o início do pacote (Spawn)
frida -U -l espiar.js -f com.android.settings
```

### 5.3. Resultado Esperado

1.  O app de Configurações abrirá no emulador.
2.  Navegue pelos menus no emulador.
3.  No seu terminal, você verá os logs das telas:
    ```text
    [👀] Tela detectada: com.android.settings.Settings$DisplaySettingsActivity
    ```

-----

## 🛠️ Comandos Úteis para o Dia a Dia

| Ação | Comando |
| :--- | :--- |
| **Listar pacotes instalados** | `frida-ps -Uai` |
| **Rodar script em app aberto** | `frida -U -l script.js -n "Nome do App"` |
| **Matar o servidor Frida** | `adb shell killall frida-server` |

```
```