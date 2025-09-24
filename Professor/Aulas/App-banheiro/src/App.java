public class App {
    public static void main(String[] args) throws Exception {
        
        Banheiro banheiro = new Banheiro();

        Thread convidado1 = new Thread(() -> {
            banheiro.fazerNumero1();
        }, "Kauan");

        Thread convidado2 = new Thread(() -> {
             banheiro.fazerNumero2();
        }, "Breno");

        Thread convidado3 = new Thread(() -> {
             banheiro.fazerNumero1();
        }, "Carol");

        Thread limpeza = new Thread(() -> {
            while (true) { 
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                banheiro.limpar();
            }
        }, "Severino");

        //Identifica que é uma thread de trabalho do sistema, e quando ela terminar o trabalho ela 
        //vai parar automáticamente.
        limpeza.setDaemon(true);

        convidado1.start();
        convidado2.start();
        convidado3.start();
        limpeza.start();



    }
}
