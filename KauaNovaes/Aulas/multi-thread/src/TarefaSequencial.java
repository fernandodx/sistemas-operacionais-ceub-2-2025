import java.util.concurrent.TimeUnit;

public class TarefaSequencial {
    public static void fazerAnotacoes() throws InterruptedException {
        System.out.println("# Iniciando Anotação #");
        
        for (int i=0;i<3;i++) {
            System.out.println("> Anotando Item " + i);
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("# Finalizando Anotação #");
    }

    public static void fazerLeitura() throws InterruptedException {
        System.out.println("# Iniciando Leitura #");
        
        for (int i=0;i<3;i++) {
            System.out.println("> Lendo Item " + i);
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("# Finalizando Leitura #");
    }
}