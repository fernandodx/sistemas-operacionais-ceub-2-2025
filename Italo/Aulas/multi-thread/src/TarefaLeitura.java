public class TarefaLeitura implements Runnable {

    @Override
    public void run() {
        try {
            
            TarefaSequencial.fazerLeituras();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
