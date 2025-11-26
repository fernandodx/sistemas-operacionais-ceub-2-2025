public class Janela implements EventListener {

    private String nome;

    public Janela(String nome) {
        this.nome = nome;
    }

    @Override
    public void onEvent(String data) {
        System.out.println("Janela " + nome + " recebeu o evento: " + data);
    }
}
