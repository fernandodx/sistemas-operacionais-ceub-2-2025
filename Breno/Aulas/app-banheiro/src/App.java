public class App {
    public static void main(String[] args) throws Exception {
        
        Banheiro banheiro = new Banheiro();

        Thread convidado1 = new Thread((Runnable) () -> banheiro.fazerNumeroUm(), "Kauan");

        Thread convidado2 = new Thread((Runnable) () -> banheiro.fazerNumeroDois(), "Breno");

        Thread convidado3 = new Thread((Runnable) () -> banheiro.fazerNumeroDois(), "Carol");

        Thread limpeza = new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                banheiro.limpar();
            }
        }, "Severino");

        //Identifica que é uma thread de trabalho do sistema, e quando ela terminar o trabalho
        //vai parar automaticamente.
        limpeza.setDaemon(true);

        convidado1.start();
        convidado2.start();
        convidado3.start();
        limpeza.start();
    }
}
