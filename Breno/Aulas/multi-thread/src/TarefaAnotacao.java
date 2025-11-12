public class TarefaAnotacao implements Runnable{

    @Override
    public void run() {
        try {
            TarefaSequencial.fazerAnotacoes();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
