/*

1) O que é um Deadlock?
   - Deadlock acontece quando duas ou mais threads ficam bloqueadas para sempre,
     porque cada uma delas está esperando um recurso que nunca será liberado.
   - Em termos simples: uma espera pela outra e nenhuma consegue continuar.
   - Consequências:
       • O programa pode travar sem encerrar.
       • Nenhuma das tarefas em execução termina.
       • Pode causar falhas sérias em sistemas que precisam estar sempre disponíveis.

2) Exemplo abaixo:
   - Temos dois "recursos" (cadeadoA e cadeadoB).
   - A primeira thread pega o cadeadoA e depois tenta o cadeadoB.
   - A segunda thread pega o cadeadoB e depois tenta o cadeadoA.
   - Isso gera um impasse: cada uma segura um recurso e espera o outro.
*/

public class Atividade2 {

    
    private static final Object cadeadoA = new Object();
    private static final Object cadeadoB = new Object();

    public static void main(String[] args) {

        
        Thread tarefa1 = new Thread(() -> {
            synchronized (cadeadoA) { 
                System.out.println("Tarefa 1 bloqueou o cadeadoA");

                try {
                    Thread.sleep(200); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Tarefa 1 quer o cadeadoB...");
                synchronized (cadeadoB) { 
                    System.out.println("Tarefa 1 conseguiu o cadeadoB");
                }
            }
        });

        
        Thread tarefa2 = new Thread(() -> {
            synchronized (cadeadoB) { 
                System.out.println("Tarefa 2 bloqueou o cadeadoB");

                try {
                    Thread.sleep(200); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Tarefa 2 quer o cadeadoA...");
                synchronized (cadeadoA) { 
                    System.out.println("Tarefa 2 conseguiu o cadeadoA");
                }
            }
        });

       
        tarefa1.start();
        tarefa2.start();
    }
}
