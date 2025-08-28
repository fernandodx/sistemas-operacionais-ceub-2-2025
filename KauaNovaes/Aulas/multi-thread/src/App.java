public class App {
    public static void main(String[] args) throws Exception {
        Runnable tarefaLeitura = new TarefaLeitura();
        Runnable tarefaAnotacao = new TarefaAnotacao();

        Thread threadLeitura = new Thread(tarefaLeitura);
        Thread threadAnotacao = new Thread(tarefaAnotacao);
    
        threadLeitura.start();
        threadAnotacao.start();
    }
}
