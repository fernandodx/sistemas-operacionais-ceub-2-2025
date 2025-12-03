package Atividade5;

public interface EventListener {
    /**
     * Define o método que os objetos ouvintes devem implementar para reagir ao evento.
     * @param data Informação específica transmitida com o evento.
     */
    void onEvent(String data);
}
