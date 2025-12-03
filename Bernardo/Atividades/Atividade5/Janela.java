public class Janela implements EventListener {
    private final String name;

    public Janela(String name) {
        this.name = name;
    }

    @Override
    public void onEvent(String data) {
        System.out.println("Janela '" + name + "' recebeu evento: " + data);
    }

    @Override
    public String toString() {
        return "Janela{" + "name='" + name + '\'' + '}';
    }
}