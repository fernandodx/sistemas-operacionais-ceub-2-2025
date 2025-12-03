void main(String[] args) {
    final Object RESOURCE_1 = new Object();
    final Object RESOURCE_2 = new Object();

    Thread t1 = new Thread(() -> {
        synchronized (RESOURCE_1) {
            System.out.println(Thread.currentThread().getName() + ": travou o recurso 1");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}

            System.out.println(Thread.currentThread().getName() + ": tentando travar o recurso 2");
            synchronized (RESOURCE_2) {
                System.out.println(Thread.currentThread().getName() + ": travou o recurso 2");
            }
        }
    });

    Thread t2 = new Thread(() -> {
        synchronized (RESOURCE_2) {
            System.out.println(Thread.currentThread().getName() + ": travou o recurso 2");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}

            System.out.println(Thread.currentThread().getName() + ": tentando travar o recurso 1");
            synchronized (RESOURCE_1) {
                System.out.println(Thread.currentThread().getName() + ": travou o recurso 1");
            }
        }
    });

    t1.start();
    t2.start();
}