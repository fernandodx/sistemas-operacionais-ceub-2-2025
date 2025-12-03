import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TarefaAdicional implements Runnable {
    
    private MinhaLista lista;
    private int numeroThread;

    public TarefaAdicional(MinhaLista lista, int numeroThread) {
        this.lista = lista;
        this.numeroThread = numeroThread;
    }

    @Override
    public void run() {
       for ( int i = 0; i < 10; i++) {
        //lista.add("Theread:" + numeroThread + " - loop: " +i);
            lista.addElemento("Thread" + numeroThread + " - loop:" + i);
       } 
}

}
