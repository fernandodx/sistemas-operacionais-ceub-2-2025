
````markdown
Atividade Guiada - Introdução à Segurança em Sistemas Operacionais

---

## 1. Controle de Acesso (Quem é o dono?)

No Linux (e em sistemas baseados em Unix como macOS e Android), a segurança começa nas permissões de arquivo. Cada arquivo possui regras para três categorias:

1.  **User (u):** O dono do arquivo (você).
2.  **Group (g):** Um grupo de usuários que compartilham permissões.
3.  **Others (o):** Todo o resto do mundo (qualquer outro usuário do sistema).



### 🧪 Atividade 1: O Arquivo Confidencial

Vamos simular um cenário onde precisamos proteger uma lista de salários da diretoria.

**Passo 1: Criar o arquivo**
Abra o terminal e crie um arquivo com dados sensíveis:
```bash
echo "Salario do Diretor: R$ 50.000" > salarios.txt
````

**Passo 2: Analisar as permissões atuais**
Use o comando `ls -l` (list long) para ver os detalhes:

```bash
ls -l salarios.txt
```

Você verá algo parecido com isto:
`-rw-r--r-- 1 aluno alunos 28 Nov 17 14:00 salarios.txt`

**Como ler isso?**

  * `rw-` (User): O dono pode Ler (Read) e Escrever (Write).
  * `r--` (Group): O grupo só pode Ler.
  * `r--` (Others): Qualquer um só pode Ler.

> **Risco:** Do jeito que está, qualquer pessoa no sistema pode ler o salário do diretor\!

**Passo 3: A Falha de Segurança (Não faça isso em produção\!)**
Muitos tutoriais ensinam a usar o `777` para resolver problemas de acesso. Vamos ver o perigo disso:

```bash
chmod 777 salarios.txt
ls -l salarios.txt
```

Agora a permissão é `-rwxrwxrwx`. Todo mundo pode ler, editar e até apagar esse arquivo.

**Passo 4: O "Hardening" (Blindagem)**
Vamos restringir o acesso para que **apenas o dono** possa ler e escrever.

```bash
chmod 600 salarios.txt
ls -l salarios.txt
```

Resultado esperado: `-rw-------`. Agora o arquivo está seguro contra olhares curiosos de outros usuários.

-----

## 2\. Princípio do Menor Privilégio (Sudo vs Root)

O **Root** é o administrador máximo do sistema. Ele pode ler qualquer arquivo e deletar qualquer coisa. Por segurança, trabalhamos com usuários comuns e só "elevamos" o privilégio quando necessário.

### 🧪 Atividade 2: Tentando acessar segredos do Sistema (Somente para quem tem Linux) 

O arquivo `/etc/shadow` armazena os "hashes" (senhas criptografadas) de todos os usuários. É um dos arquivos mais protegidos do sistema.

**Passo 1: Tente ler como usuário comum**

```bash
cat /etc/shadow
```

**Resultado:** `Permission denied` (Permissão negada). O sistema operacional protegeu o arquivo.

**Passo 2: Elevando privilégios com `sudo`**
O comando `sudo` (SuperUser DO) executa **apenas aquele comando** como administrador.

```bash
sudo cat /etc/shadow
```

Digita sua senha. Agora você verá o conteúdo.

> **Conceito:** Isso garante que, se um vírus infectar seu usuário comum, ele não conseguirá roubar as senhas do sistema, pois ele não tem a senha do `sudo`.

-----

## 3\. Integridade e Hashing (Detector de alterações)

Como saber se um arquivo foi modificado por um hacker ou corrompido durante um download? Usamos **Hashes**. Um Hash é uma "impressão digital" matemática única do arquivo.

### 🧪 Atividade 3: A Auditoria

Vamos voltar ao nosso arquivo `salarios.txt`.

**Passo 1: Gerar a "impressão digital" original**
Vamos usar o algoritmo SHA-256 para calcular o hash do arquivo atual.

```bash
sha256sum salarios.txt
```

*Saída (exemplo):* `a1b2c3d4... salarios.txt`

> **Atenção:** Anote os 4 primeiros caracteres desse código.

**Passo 2: Simular um Ataque (Man-in-the-Middle)**
Imagine que um atacante conseguiu editar o arquivo:

```bash
echo "Salario do Diretor: R$ 90.000" > salarios.txt
```

**Passo 3: Verificar a integridade**
Vamos rodar o hash novamente para ver se o arquivo é o mesmo.

```bash
sha256sum salarios.txt
```

Compare com o código que você anotou no Passo 1.

**Conclusão:** O código mudou completamente\! Mesmo que o nome do arquivo seja igual, a matemática prova que o conteúdo foi adulterado. É assim que antivírus e sistemas de atualização funcionam.

```