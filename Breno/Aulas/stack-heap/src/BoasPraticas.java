import java.util.List;

public class BoasPraticas {
    public void processarRegistroRuim(List<String> registros){

        // RUIM: a referência 'buffer' permanece após o loop e mantém 10mb na heap
        byte[] buffer = null; // vive durante o método
        for(String r : registros){
            buffer = new byte[10 * 1024 * 1024];
        }
        // aqui o 'buffer' ainda não aponta para o último array alocado
        // significa que o GC não vao conseguir remover o buffer da memória

        // continua o método...
    }

    public void processarRegistroBom(List<String> registros){

        

        // BOM: 'buffer' existe apenas dentro do loop;
        for(String r: registros){
            byte[] buffer = new byte[10 * 1024 * 1024];
        }

        // após o término do loop, a memória heap é liberada
        // está elegível para o garbage collector
    }
}
