import java.util.concurrent.TimeUnit;

public class TarefaSequencial {

    public static void fazerAnotacoes() throws InterruptedException{

        System.out.println("Começando anotação");

        for (int i =0; i <3; i++){
            System.out.println(">Anotando... Item" + i);
            TimeUnit.SECONDS.sleep(1);

        }

        System.out.println("Acabando anotação");

    }
    public static void fazerLeitura() throws InterruptedException{

        System.out.println("Começando leitura");

        for (int i =0; i <3; i++){
            System.out.println(">Anotando... Item" + i);
            TimeUnit.SECONDS.sleep(1);

        }

        System.out.println("Acabando leitura");

    }

}
