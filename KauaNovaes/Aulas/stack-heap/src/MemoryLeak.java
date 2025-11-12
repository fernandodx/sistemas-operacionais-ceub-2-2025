import java.util.ArrayList;
import java.util.List;

public class MemoryLeak {
    public static final List<byte[]> DADOS_VAZADOS = new ArrayList<>();

    public void simularVazamento() {
        DADOS_VAZADOS.add(new byte[10*1024*1024]);
        System.out.println("Memória consumida...");
    }

    public static void main(String[] args) throws InterruptedException {
        MemoryLeak app = new MemoryLeak();

        while (true) {
            app.simularVazamento();    
            Thread.sleep(1);
        }
    }


}
