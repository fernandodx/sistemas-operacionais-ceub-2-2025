public class App {
    public static void main(String[] args) {
        Thread t1 = new Thread(new LoopThread());
        Thread t2 = new Thread(new LoopThread());

        t1.start();
        t2.start();
    }

    static class LoopThread implements Runnable {
        @Override
        public void run() {
            Thread threadAtual = Thread.currentThread();
            long id = threadAtual.threadId();

            for (int i = 1; i <= 1000; i++) {
                System.out.println("Thread ID: " + id + " - Número: " + i);
            }
        }
    }
}
