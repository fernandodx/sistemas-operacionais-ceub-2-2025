import java.util.concurrent.TimeUnit;

public class TarefaSequencial {

        public static void fazerAnotacoes(){
            for (int i = 0; i < 3; i++){
                System.out.println("> Anotando... Item" + i);
                TimeUnit.SECONDS.sleep(timeout:1);
            }
            System.out.println("# Finalizando Anotação#");
        }
        public static void fazerLeitura(){
            for (int i = 0; i < 3; i++){
                System.out.println("> Fazendo Leitura" + i);
                TimeUnit.SECONDS.sleep(timeout:1);
            }
            System.out.println("# Finalizando Leitura#");
        }

  
}
