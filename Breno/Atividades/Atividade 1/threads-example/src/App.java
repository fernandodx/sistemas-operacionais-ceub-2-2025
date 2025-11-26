public class App {
    public static void main(String[] args) {

        Runnable tarefa = () -> {
            Thread threadAtual = Thread.currentThread();
            long id = threadAtual.getId();

            for (int i = 1; i <= 1000; i++) {
                System.out.println("Thread ID: " + id + " - Número: " + i);
            }
        };

        Thread t1 = new Thread(tarefa);
        Thread t2 = new Thread(tarefa);

        t1.start();
        t2.start();
    }
}
