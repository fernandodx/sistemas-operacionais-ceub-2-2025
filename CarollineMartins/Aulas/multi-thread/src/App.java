public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Início da Execução paralela");
        //TarefaSequencial.fazerLeitura();
        //TarefaSequencial.fazerAnotacoes();

        Runnable tarefaAnotacao = new TarefaAnotacao();
        Runnable tarefaLeitura = new TarefaLeitura();

        Thread threadLeitura = new Thread(tarefaLeitura);
        Thread threadAnotacao = new Thread(tarefaAnotacao);

        threadLeitura.start();
        threadAnotacao.start();
       
        
        System.out.println("FIM DA EXECUÇÃO paralela");
    }
}
