
import java.util.List;

public class BoasPraticas {

    //RUIM: a referência 'buffer'permanece após o loop e mantém 10mb  heap
    public void processarRegistroRuim(List<String> registros) {
        byte[] buffer = null; // vive durante o método
        for(String r : registros){
            buffer = new byte[10 * 1024 * 1024];
        }
        // Aqui o 'buffer ainda não aponta para último array alocado 
        //Significa que o GC não vai conseguir remover o 'buffer'da memória

        //Continua o método .....
    }

    //BOM: 'buffer' existe apenas dentro do loop; 
    public void processarRegistroBom(List<String> registros) {
         for(String r : registros){
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        //após o termino do loop, a memória heap é liberada
        // Esta elegível para o GC

         //Continua o método .....
    }
}
