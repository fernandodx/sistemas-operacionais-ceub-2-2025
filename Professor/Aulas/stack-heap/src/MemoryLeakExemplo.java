
import java.util.ArrayList;
import java.util.List;

public class MemoryLeakExemplo {

    //Esta lista viverá para SEMPRE, enquanto a aplicação estiver rodando.
    public static final List<byte[]> DADOS_VAZADOS = new ArrayList<>();

    public void simularVazamento() {
        DADOS_VAZADOS.add(new byte[10 * 1024 * 1024]);
        System.out.println("Memória comsumida...");
    }



    public static void main(String[] args) {
        MemoryLeakExemplo app = new MemoryLeakExemplo();
        while (true) { 
             app.simularVazamento();
             try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       
    }




}
