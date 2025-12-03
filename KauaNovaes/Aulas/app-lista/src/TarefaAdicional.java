public class TarefaAdicional implements Runnable {

    //private List<String> lista;
    //private List<String> lista = Collections.synchronizedList(new ArrayList<>());
    private Lista lista;
    private int numeroThread;

    public TarefaAdicional(Lista lista, int numeroThread) {
        this.lista = lista;
        this.numeroThread = numeroThread;
    }
    
    @Override
    public void run() {
        
        for (int i=0;i<100;i++) {
            lista.addElemento("Thread: " + numeroThread + " - loop: " + i);
        }

    }
    
}
