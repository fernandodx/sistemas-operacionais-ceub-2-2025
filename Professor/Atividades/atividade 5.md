### **Atividade: Criando um Listener em Java**

**1. A Interface**
* Crie uma interface chamada `EventListener`.
* Nela, declare o método `void onEvent(String data);`.

**2. A Classe Ouvinte**
* Crie uma classe `Janela` que implementa a interface `EventListener`.

**3. A Classe Transmissora**
* Crie uma classe `Broadcaster` que contenha:
    * Uma lista de `EventListener`.
    * Um método para **registrar** (adicionar) um listener na lista.
    * Um método para **disparar um evento** (que chama o `onEvent` de todos os listeners registrados).

**Ponto de Atenção:**
* Pense em como evitar vazamento de memória (*memory leak*) nesse modelo. O que está faltando?