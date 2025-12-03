void main() {
    Broadcaster broadcaster = new Broadcaster();
    Janela janela = new Janela();

    broadcaster.registerEventListener(janela);
    broadcaster.triggerEvent("evento acionado");

    broadcaster.removeListener(janela);
    broadcaster.triggerEvent("evento acessado");
}
