import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Broadcaster {
    private final List<WeakReference<EventListener>> listeners = new CopyOnWriteArrayList<>();

    public void register(EventListener listener) {
        if (listener == null)
            return;
        listeners.add(new WeakReference<>(listener));
    }

    public void unregister(EventListener listener) {
        if (listener == null)
            return;
        for (WeakReference<EventListener> ref : listeners) {
            EventListener l = ref.get();
            if (l == null || l == listener) {
                listeners.remove(ref);
            }
        }
    }

    public void broadcast(String data) {
        for (WeakReference<EventListener> ref : listeners) {
            EventListener l = ref.get();
            if (l != null) {
                try {
                    l.onEvent(data);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            } else {
                listeners.remove(ref);
            }
        }
    }

    public void cleanup() {
        for (WeakReference<EventListener> ref : listeners) {
            if (ref.get() == null) {
                listeners.remove(ref);
            }
        }
    }
}