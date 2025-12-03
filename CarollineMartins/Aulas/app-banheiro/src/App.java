public class App {
    public static void main(String[] args) throws Exception {
        
        Banheiro banheiro = new Banheiro();

        Thread convidado1= new Thread((Runnable) () -> banheiro.fazerNumero1(),"Kauan");

        Thread convidado2= new Thread((Runnable) () -> banheiro.fazerNumero1(),"breninho");

        Thread convidado3= new Thread((Runnable) () -> banheiro.fazerNumero1(),"carol");

        Thread limpeza = new Thread(() -> {
            while (true){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                banheiro.limpar();
            }
        }, "Severino");

        limpeza.setDaemon(true);

        convidado1.start();
        convidado2.start();
        convidado3.start();
        limpeza.start();
    }
}