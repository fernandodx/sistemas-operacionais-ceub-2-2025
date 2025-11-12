public class App {
    public static void main(String[] args) throws Exception {
        Banheiro banheiro = new Banheiro();

        Thread convidado1 = new Thread(() -> banheiro.nro1(), "Kauã");

        Thread convidado2 = new Thread(() -> banheiro.nro2(), "Breno");

        Thread convidado3 = new Thread(() -> banheiro.nro2(), "Carol");

        Thread limpeza = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                banheiro.limpezaDeBanheiro();
            }
        }, "Joaquim");

        limpeza.setDaemon(true);

        convidado1.start();
        convidado2.start();
        convidado3.start();
        limpeza.start();
    }
}
