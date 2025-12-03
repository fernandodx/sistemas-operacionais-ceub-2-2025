public class atividade1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                Thread threadAtual = Thread.currentThread();
                long id = threadAtual.getId();
                System.out.println("Thread " + id + " -> " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                Thread threadAtual = Thread.currentThread();
                long id = threadAtual.getId();
                System.out.println("Thread " + id + " -> " + i);
            }
        });

        t1.start();
        t2.start();
    }
}
