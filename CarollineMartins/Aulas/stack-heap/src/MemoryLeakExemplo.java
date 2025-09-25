import java.util.ArrayList;
import java.util.List;

public class MemoryLeakExemplo {
    //Esta lista vivera para SEMPRE, enquanto a aplicação estiver rodando.
    public static final List<Byte[]> DADOS_VAZADOS = new ArrayList<>();

    public void simularVazamento() {
        DADOS_VAZADOS.add(new Byte[10 * 1024 * 1024]);
        System.out.println("Memoria consumida...");
    }

public static void main(String[] args) {
    MemoryLeakExemplo app = new MemoryLeakExemplo();
    while (true) {
        app.simularVazamento();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}

}

