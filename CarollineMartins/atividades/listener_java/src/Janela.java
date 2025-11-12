public class Janela implements EventListener {

    @Override
    public void onEvent(String data) {
        System.out.println("Evento recebido com sucesso: " + data);
    }
}
