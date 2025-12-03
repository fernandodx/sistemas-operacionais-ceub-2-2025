import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TarefaAdicional implements Runnable {

    //private List<String> lista;
    private MinhaLista lista;
    private int numeroThread;

    public TarefaAdicional(MinhaLista lista, int numeroThread) {
        this.lista = lista;
        this.numeroThread = numeroThread;
    }  

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //lista.add("Thread " + numeroThread + " - loop: " + i);
            String valor = "Thread: " + numeroThread + " - loop " + i;
            lista.addElemento(valor);
        }
    }
}
