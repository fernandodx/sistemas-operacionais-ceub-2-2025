public class App {
    public static void main(String[] args) {

        final Object recursoA = "Recurso A";
        final Object recursoB = "Recurso B";

        Thread t1 = new Thread(() -> {
            synchronized (recursoA) {
                System.out.println("Thread 1: segurando Recurso A...");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 1: tentando acessar Recurso B...");
                synchronized (recursoB) {
                    System.out.println("Thread 1: acessou Recurso B!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (recursoB) {
                System.out.println("Thread 2: segurando Recurso B...");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 2: tentando acessar Recurso A...");
                synchronized (recursoA) {
                    System.out.println("Thread 2: acessou Recurso A!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
