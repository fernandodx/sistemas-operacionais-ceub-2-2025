Crie um programa com duas threads que imprimem números de 1 até 1000, além da ID da thread.

Você pode imprimir a id da thread através do método getId(), por exemplo:

Thread threadAtual = Thread.currentThread();
long id = threadAtual.getId();
System.out.println("Id da thread: " + id);

Responda:  Rode o programa no mínimo duas vezes para ver se o resultado da execução difere.