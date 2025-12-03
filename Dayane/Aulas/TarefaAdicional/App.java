package Dayane.Aulas.TarefaAdicional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception{
        //List<String> lista = new ArrayList<>();
         list<String>lista = Collections.synchronizedList(new ArrayList<>());
        for (int = 0; i < 10; i++){
            new Thread(new TarefaAdicional(lista, i)).start();

        Thread.sleep(2000);

        for(int i=0<lista.size(); i++){
            system.out.println(i + "_" + lista.get(i));
        }
        }
    }
}
