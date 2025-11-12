public class TarefaLeitura implements Runnable{

    @Override
    public void run() {
        try {
            TarefaSequencial.fazerLeitura();
        } catch (InterruptedException e) {
    
            e.printStackTrace();
        }
        
    }
}
