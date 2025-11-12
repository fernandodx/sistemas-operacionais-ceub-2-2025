public class Banheiro {

    private boolean isSujo = false;

    public void fazerNumero1() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " ...batendo na porta do banheiro, toc toc");
        
        synchronized (this) {
            try {
                while(this.isSujo){
                    System.out.println(nome + " Eita! Banheiro Sujo... Vou esperar!!!");
                    this.wait();
                }
                atividadeDentroBanheiro(nome, 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void fazerNumero2() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " ...batendo na porta do banheiro, toc toc");
        
        synchronized (this) {
            try {
                while(this.isSujo){
                    System.out.println(nome + " Eita! Banheiro Sujo... Vou esperar!!!");
                    this.wait();
                }
                atividadeDentroBanheiro(nome, 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void atividadeDentroBanheiro(String nome, int tempoEmSegundos) throws InterruptedException {
        System.out.println(nome + " entrando no banheiro.");

        if(tempoEmSegundos > 5){
            System.out.println(nome + " fazendo coisa demorada!");
        }else {
            System.out.println(nome + " fazendo coisa rápida!"); 
        }

        Thread.sleep(tempoEmSegundos * 1000);

        System.out.println(nome + " dando descarga e lavando as mãos.");
        System.out.println(nome + " saindo do banheiro...");

        this.isSujo = true;
    }

    public void limpar() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " ...batendo na porta! toc toc.");

        synchronized (this) {
            if(!this.isSujo){
                System.out.println("O banheiro já esta limpo!");
                return;
            }

            System.out.println(nome + " ...Iniciando a limpeza do banheiro.");

            try {
                Thread.sleep(86*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Banheiro limpo!");
            System.out.println(nome + "...Saindo do banheiro!");
            this.isSujo = false;
            /// Este avisa todas a threads que estam no estado await, que podem voltar a execução.
            this.notifyAll();
        }
    }

}
