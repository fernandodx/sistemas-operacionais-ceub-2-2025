public class Main {
    public static void main(String[] args) throws InterruptedException {
        Broadcaster broadcaster = new Broadcaster();

        Janela j1 = new Janela("A");
        broadcaster.register(j1);

        Janela j2 = new Janela("B");
        broadcaster.register(j2);

        broadcaster.broadcast("Primeiro evento");

        broadcaster.unregister(j2);
        System.out.println("Desregistrado j2");
        broadcaster.broadcast("Segundo evento (depois de unregister)");

        broadcaster.register(new Janela("C (anônima)"));

        System.gc();
        Thread.sleep(100);

        broadcaster.cleanup();
        broadcaster.broadcast("Terceiro evento (após GC/cleanup)");
    }
}