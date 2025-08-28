public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("**** Execução Paralela ****");
        //TarefaSequencial.fazerLeitura();
        //TarefaSequencial.fazerAnotacoes();

        Runnable tarefaAnotacao = new TarefaAnotacao();
        Runnable tarefaLeitura = new TarefaLeitura();

        Thread threadLeitura = new Thread(tarefaLeitura);
        Thread threadAnotacao = new Thread(tarefaAnotacao);

        threadLeitura.start();
        threadAnotacao.start();

        System.out.println("**** Final da Execução Paralela ****");
    }
}


