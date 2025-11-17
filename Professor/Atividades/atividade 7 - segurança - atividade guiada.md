# Atividade Guiada -- Introdução à Segurança em Sistemas Operacionais

------------------------------------------------------------------------

## 1. Controle de Acesso (Quem é o dono?)

Nos sistemas Linux (e nos baseados em Unix, como macOS e Android), a
segurança começa pelas permissões de arquivos. Cada arquivo possui
regras para três categorias:

1.  **User (u):** O dono do arquivo.
2.  **Group (g):** Grupo de usuários associados ao arquivo.
3.  **Others (o):** Qualquer outro usuário do sistema.

### Atividade 1: O Arquivo Confidencial

Simulação de proteção de um arquivo com dados sensíveis.

**Passo 1: Criar o arquivo**

``` bash
echo "Salario do Diretor: R$ 50.000" > salarios.txt
```

**Passo 2: Analisar as permissões atuais**

``` bash
ls -l salarios.txt
```

Exemplo de saída:

    -rw-r--r-- 1 aluno alunos 28 Nov 17 14:00 salarios.txt

**Como interpretar:**

-   `rw-` (User): O dono pode ler e escrever.
-   `r--` (Group): Grupo pode apenas ler.
-   `r--` (Others): Todos os demais usuários podem apenas ler.

> **Risco:** Nessa configuração, qualquer usuário pode ler o salário do
> diretor.

**Passo 3: A Falha de Segurança (exemplo do que NÃO fazer)**

Alguns tutoriais recomendam usar `777`. Veja o problema:

``` bash
chmod 777 salarios.txt
ls -l salarios.txt
```

Agora as permissões são `-rwxrwxrwx`. Todos podem ler, editar e apagar o
arquivo.

**Passo 4: Hardening (Blindagem)**

Ajuste correto: apenas o dono pode ler e escrever.

``` bash
chmod 600 salarios.txt
ls -l salarios.txt
```

O resultado esperado é `-rw-------`.

------------------------------------------------------------------------

## 2. Princípio do Menor Privilégio (Sudo vs Root)

O usuário **root** possui controle total sobre o sistema. Para
segurança, usa-se um usuário comum e eleva-se o privilégio somente
quando necessário, usando `sudo`.

### Atividade 2: Acessando Arquivos do Sistema (Linux)

O arquivo `/etc/shadow` armazena os hashes das senhas dos usuários. É
altamente protegido.

**Passo 1: Tentativa como usuário comum**

``` bash
cat /etc/shadow
```

Resultado esperado: `Permission denied`.

**Passo 2: Elevando privilégios com sudo**

``` bash
sudo cat /etc/shadow
```

Após digitar sua senha, o conteúdo será exibido.

> **Conceito:** Se um malware invade um usuário comum, ainda não
> consegue acessar arquivos críticos porque não possui a senha do sudo.

------------------------------------------------------------------------

## 3. Integridade e Hashing (Detector de Alterações)

Hashes são "impressões digitais" matemáticas usadas para verificar
alterações em arquivos. Se o conteúdo muda, o hash muda completamente.

### Atividade 3: Auditoria de Integridade

Voltando ao arquivo `salarios.txt`:

**Passo 1: Gerar o hash inicial**

``` bash
sha256sum salarios.txt
```

Saída exemplo:

    a1b2c3d4...  salarios.txt

Anote os quatro primeiros caracteres.

**Passo 2: Simular alteração maliciosa**

``` bash
echo "Salario do Diretor: R$ 90.000" > salarios.txt
```

**Passo 3: Verificar novamente o hash**

``` bash
sha256sum salarios.txt
```

Compare com o valor anterior.

**Conclusão:** O hash muda completamente, indicando alteração no
conteúdo --- mesmo mantendo o mesmo nome de arquivo. É assim que
antivírus e validadores de atualização detectam adulterações.

------------------------------------------------------------------------
