package Dayane.Aulas.TarefaAdicional;
import java.util.List;

public class TarefaAdicional implements runnable {
    private list<String>lista = Collections.synchronizedList(new ArrayList<>());
    private int numeroThread;

    public TarefaAdicional(List<String> lista, int numeroThread){
        this.lista = lista;
        this.numeroThread = numeroThread;
    
    }

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            lista.add("Thread: " + numethread + "- loop: " + i);
        }
    }
    
}
