import java.util.ArrayList;
import java.util.List;

public class Broadcaster {

    private List<EventListener> listeners = new ArrayList<>();

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

    public void broadcast(String data) {
        for (EventListener listener : listeners) {
            listener.onEvent(data);
        }
    }
}
