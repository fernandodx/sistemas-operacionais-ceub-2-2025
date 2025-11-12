import java.util.ArrayList;
import java.util.List;

public class Broadcaster {
    List<EventListener> listeners = new ArrayList<EventListener>();

    public void registerEventListener(EventListener listener) {
        listeners.add(listener);
    }

    public void triggerEvent(String data) {
        try {
            for (EventListener listener : listeners) {
                listener.onEvent(data);
            }
        } catch (Exception e) {
            System.err.println("Erro ao notificar evento: " + e.getMessage());;
        }

    }

    // creio que uma forma de evitar memory leak é utilizar esse metodo para remover o listener e
    // também colocar o listener em blocos de try/catch
    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }
}
