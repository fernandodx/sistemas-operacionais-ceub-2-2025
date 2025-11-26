public class Main {
    public static void main(String[] args) {

        Broadcaster broadcaster = new Broadcaster();

        Janela j1 = new Janela("Principal");
        Janela j2 = new Janela("Configurações");

        broadcaster.addListener(j1);
        broadcaster.addListener(j2);

        broadcaster.broadcast("Sistema iniciado.");

        broadcaster.removeListener(j2);

        broadcaster.broadcast("Somente a janela principal ouvirá isso.");
    }
}
