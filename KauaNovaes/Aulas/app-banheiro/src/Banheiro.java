public class Banheiro {

    private boolean isSujo = false;
    
    public void nro1() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " ...batendo na porta do banheiro, toc toc");
        
        synchronized (this) {
            try {
                while(this.isSujo) {
                    System.out.println(nome + " tentou entrar no banheiro sujo, o mesmo está esperando");
                    this.wait();
                }

                atividadeDentroBanheiro(nome, 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void nro2() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " ...batendo na porta do banheiro, toc toc");
        synchronized (this) {
            try {
                while(this.isSujo) {
                    System.out.println(nome + " tentou entrar no banheiro sujo, o mesmo está esperando");
                    this.wait();
                }
                atividadeDentroBanheiro(nome, 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void atividadeDentroBanheiro(String nome, int tempoEmSegundos) throws InterruptedException {
        System.out.println(nome + " entrando no banheiro");
        
        if (tempoEmSegundos > 5) {
            System.out.println(nome + " está fazendo algo demorado");
        } else {
            System.out.println(nome + " está fazendo coisa rápida");
        }

        Thread.sleep(tempoEmSegundos * 1000);

        System.out.println(nome + " dando descarga e lavando as mãos");
        System.out.println(nome + " saindo do banheiro...");

        this.isSujo = true;
    }

    public void limpezaDeBanheiro() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " ...batendo na porta! toc toc");

        synchronized (this) {
            if (!this.isSujo) {
                System.out.println("Banheiro já está limpo");
                return;
            }
            
            System.out.println(nome + " ...Iniciando a limpeza do banheiro");
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Banheiro limpo");
            System.out.println(nome + " ...Saindo do banheiro");
            this.isSujo = false;
            this.notifyAll();
        }

    }
}
