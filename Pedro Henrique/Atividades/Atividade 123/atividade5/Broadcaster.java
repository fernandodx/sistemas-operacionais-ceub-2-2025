package Atividade5;

import java.util.ArrayList;
import java.util.List;

public class Broadcaster {
    // Lista para armazenar todos os objetos que querem "ouvir" os eventos.
    private List<EventListener> listeners = new ArrayList<>();

    /**
     * Adiciona um listener à lista.
     * @param listener O objeto que será notificado.
     */
    public void registrar(EventListener listener) {
        if (listener != null && !listeners.contains(listener)) {
            listeners.add(listener);
            System.out.println("Listener registrado: " + listener.getClass().getSimpleName() + " (Nome: " + listener + ")");
        }
    }
    
    /**
     * Remove um listener da lista. ESSENCIAL para prevenir Memory Leak.
     * @param listener O objeto que será removido.
     */
    public void desregistrar(EventListener listener) {
        listeners.remove(listener);
        System.out.println("Listener desregistrado: " + listener.getClass().getSimpleName() + " (Nome: " + listener + ")");
    }

    /**
     * Notifica todos os listeners registrados sobre a ocorrência de um evento.
     * @param data A mensagem ou dado a ser transmitido.
     */
    public void dispararEvento(String data) {
        System.out.println("\n*** DISPARANDO EVENTO: " + data + " ***");
        // Cria uma cópia da lista para evitar ConcurrentModificationException 
        // caso um listener tente se desregistrar durante a iteração.
        List<EventListener> copiaListeners = new ArrayList<>(listeners); 
        
        for (EventListener listener : copiaListeners) {
            listener.onEvent(data);
        }
    }

    /**
     * Opcional: Retorna o número de listeners ativos.
     */
    public int getNumListeners() {
        return listeners.size();
    }
}