import java.util.List;

public class BoasPraticas {


    public void processarRegistroRuim(List<String> registros) {
        byte[] buffer = null;

        for (String r : registros) {
            buffer = new byte[10*1024*1024];
        }
    }

    public void processarRegistroBom(List<String> registros) {
        for (String r : registros) {
            byte[] buffer = new byte[10*1024*1024];
        }
        
    }
}
