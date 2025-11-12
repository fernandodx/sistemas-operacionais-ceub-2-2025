void main(String[] args) {
    final Object PRINTER = new Object();

    Thread starvingThread = new Thread(() -> {
        int contador = 0;
        while (true) {
            synchronized (PRINTER) {
                System.out.println("Starving Thread está usando a impressora pela: " + (++contador) + "ª vez.");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
            }
        }
    });

    Runnable normalThread = () -> {
        int contador = 0;
        while (true) {
            synchronized (PRINTER) {
                System.out.println(Thread.currentThread().getName() + " conseguiu usar a impressora! Vez nº " + (++contador));
            }

            try  {
                Thread.sleep(50);
            } catch (InterruptedException e) {}
        }
    };

    Thread thread1 = new Thread(normalThread, "Thread normal 1");
    Thread thread2 = new Thread(normalThread, "Thread normal 2");

    starvingThread.start();
    thread1.start();
    thread2.start();
}