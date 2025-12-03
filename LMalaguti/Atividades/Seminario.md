# Seminário: Estrutura e Arquitetura de Sistemas Operacionais, Processos e Threads

## 1. Introdução

Os Sistemas Operacionais (SOs) constituem o núcleo fundamental de
qualquer sistema computacional moderno, sendo responsáveis por gerenciar
recursos, fornecer abstrações ao hardware e oferecer um ambiente estável
para a execução de aplicações. A compreensão de sua arquitetura interna
e do funcionamento dos processos e threads é essencial para áreas como
desenvolvimento de software, engenharia de sistemas e pesquisa em
computação.

Este seminário apresenta uma análise estruturada das principais
arquiteturas de sistemas operacionais contemporâneos, seguida pela
discussão aprofundada dos mecanismos de processos e threads, conforme
estabelecido pelas literaturas clássicas de Silberschatz, Galvin e
Gagne; Tanenbaum e Bos; e Stallings.

## 2. Estrutura e Arquitetura de Sistemas Operacionais

A arquitetura de um sistema operacional define como seus componentes
internos se organizam, interagem e distribuem responsabilidades. Essa
organização impacta diretamente aspectos como desempenho, segurança,
portabilidade e modularidade.

### 2.1 Arquitetura Monolítica

Nos sistemas monolíticos, todo o núcleo do sistema operacional é
executado em modo kernel, formando um único bloco de código altamente
interdependente. Exemplos clássicos incluem UNIX tradicional e versões
iniciais do Linux.

**Características principais:**

-   Alto desempenho devido a poucas camadas intermediárias.
-   Estrutura única contendo gerenciamento de processos, I/O, sistema de
    arquivos, memória etc.
-   Difícil manutenção, pois qualquer modificação pode afetar todo o
    kernel.
-   Baixa modularidade e alta propensão a erros decorrentes de
    acoplamento excessivo.

### 2.2 Arquitetura em Camadas

Proposta originalmente por Dijkstra, esta arquitetura organiza o sistema
operacional em níveis hierárquicos, nos quais cada camada depende
exclusivamente dos serviços fornecidos pela camada imediatamente
inferior.

**Benefícios:**

-   Melhoria na organização e na clareza funcional.
-   Facilitação da manutenção e verificação.
-   Menor risco de falhas propagadas.

**Desafios:**

-   Possível perda de desempenho devido ao excesso de camadas
    intermediárias.
-   Dificuldade na separação precisa das funcionalidades entre camadas.

### 2.3 Microkernel

Microkernels minimizam a quantidade de código executado em modo
privilegiado, movendo serviços tradicionais do kernel (como
gerenciamento de arquivos, drivers e comunicação) para o espaço do
usuário.

**Vantagens:**

-   Maior segurança e confiabilidade pela redução da superfície de
    ataque.
-   Modularidade acentuada, facilitando a substituição de componentes.
-   Tolerância a falhas: uma falha em um servidor de espaço de usuário
    não compromete todo o núcleo.

**Desvantagens:**

-   Overhead de comunicação (IPC) entre processos no espaço de usuário.
-   Implementações iniciais, como Mach, sofreram problemas de
    desempenho.

### 2.4 Arquitetura Híbrida

Arquiteturas híbridas combinam princípios monolíticos e de microkernel.
É o caso do Windows NT e das versões atuais do macOS (baseado no XNU,
que integra Mach e BSD).

**Características:**

-   Núcleo relativamente pequeno, porém ainda com funcionalidades
    integradas.
-   Drivers frequentemente no kernel por questões de desempenho.
-   Compromisso entre modularidade e eficiência.

### 2.5 Arquitetura Modular

Linux moderno pode ser considerado modular, pois suporta carregamento
dinâmico de módulos de kernel (loadable kernel modules -- LKMs).

**Benefícios:**

-   Flexibilidade para adicionar drivers sem recompilar todo o kernel.
-   Redução da complexidade e aumento da capacidade de personalização.

## 3. Processos e Threads

Processos e threads constituem entidades fundamentais na execução de
programas em sistemas operacionais. Eles representam as abstrações
utilizadas para alocar recursos e gerenciar a concorrência.

### 3.1 Conceito de Processo

Um processo pode ser definido como um programa em execução, incorporando
código, dados, pilha, registradores e recursos do sistema.

Segundo Silberschatz et al., um processo contém:

-   **Segmento de código (text section)**
-   **Dados estáticos e globais (data section)**
-   **Heap** para alocação dinâmica de memória
-   **Pilha (stack)**, contendo chamadas de função, variáveis locais e
    endereços de retorno
-   **Contexto de execução**, armazenado em registradores

#### 3.1.1 Ciclo de Vida de um Processo

Os estados clássicos incluem:

-   **Novo** -- processo criado.
-   **Pronto** -- aguardando escalonamento.
-   **Executando** -- em utilização da CPU.
-   **Bloqueado** -- aguardando evento externo.
-   **Encerrado** -- finalização.

#### 3.1.2 Escalonamento de Processos

O escalonador define qual processo usará a CPU. Algoritmos comuns
incluem:

-   FIFO (First-In, First-Out)
-   SJF (Shortest Job First)
-   Round Robin
-   Prioridades
-   Escalonamento multinível

Cada algoritmo representa um compromisso entre justiça, throughput,
latência e eficiência.

### 3.2 Conceito de Thread

Threads são unidades leves de execução que compartilham o mesmo espaço
de memória do processo ao qual pertencem.

#### 3.2.1 Threads de Usuário vs. Threads de Kernel

**Threads de usuário:**

-   Gerenciadas por bibliotecas no espaço do usuário.
-   Operações rápidas, baixo overhead.
-   Problema: quando uma thread faz uma chamada bloqueante, todas as
    demais são bloqueadas.

**Threads de kernel:**

-   Gerenciadas pelo SO.
-   Maior overhead, mas oferecem melhor paralelismo e tolerância a
    bloqueios.

#### 3.2.2 Modelos de Mapeamento

-   **Many-to-One** -- várias threads de usuário mapeadas para uma única
    thread de kernel.
-   **One-to-One** -- cada thread de usuário é mapeada para uma thread
    de kernel (modelo do Windows e Linux modernos).
-   **Many-to-Many** -- threads de usuário mapeadas para um conjunto
    menor ou igual de threads de kernel.

#### 3.2.3 Vantagens do Uso de Threads

-   Paralelismo verdadeiro em sistemas multicore.
-   Compartilhamento eficiente de recursos.
-   Redução do custo de criação e troca de contexto.
-   Facilidade para estruturar programas concorrentes.

## 4. Considerações Finais

A compreensão da arquitetura dos sistemas operacionais e dos mecanismos
de processos e threads é indispensável para o desenvolvimento de
sistemas robustos e eficientes. Enquanto arquiteturas monolíticas prezam
pela performance, microkernels priorizam modularidade e segurança. Em
paralelo, processos e threads constituem as bases da execução
concorrente, permitindo que diferentes atividades ocorram de forma
organizada e independente.

As obras de Silberschatz, Tanenbaum e Stallings continuam sendo
referências essenciais na área, fornecendo uma visão aprofundada e
atualizada das abordagens clássicas e contemporâneas.

## Referências

-   **SILBERSCHATZ, A.; GALVIN, P.; GAGNE, G.** *Operating System
    Concepts*. 10. ed.
-   **TANENBAUM, A.; BOS, H.** *Modern Operating Systems*. 4. ed.
-   **STALLINGS, W.** *Operating Systems: Internals and Design
    Principles*. 9. ed.
-   Documentação oficial do Linux (kernel.org) e Microsoft Windows
    (docs.microsoft.com).
