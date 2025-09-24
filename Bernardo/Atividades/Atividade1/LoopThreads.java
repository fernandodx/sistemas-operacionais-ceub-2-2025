public class LoopThreads {
    public static void main(String[] args) {

        // criando a tarefa das threads
        Runnable tarefa = () -> {
            Thread threadAtual = Thread.currentThread();
            long id = threadAtual.getId();

            for (int i = 1; i <= 50; i++) { // 50 apenas p teste
                System.out.println("Thread ID: " + id + " -> " + i);
                try {
                    Thread.sleep((int)(Math.random() * 10)); // pausa pra n bugar vscode
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // criando as tarefas
        Thread t1 = new Thread(tarefa);
        Thread t2 = new Thread(tarefa);

        // inicio
        t1.start();
        t2.start();
    }
}