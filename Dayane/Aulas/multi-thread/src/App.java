public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Início da execução paralela");;
        
        Runnable tarefaAnotacao = new TarefaAnotacao();
        Runnable tarefaLeitura = new TarefaAnotacao();
        
        Thread threadLeitura = new Thread(tarefaLeitura);
        Thread threadAnotacao = new Thread(tarefaAnotacao);

        threadLeitura.start();
        threadAnotacao.start();

    }
    
}