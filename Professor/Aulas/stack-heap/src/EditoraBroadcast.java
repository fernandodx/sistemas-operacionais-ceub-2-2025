
import java.util.ArrayList;
import java.util.List;

public class EditoraBroadcast {

    private List<ContratoRevistaListener> assinates = new ArrayList<>();

    public void registrarAssinate(ContratoRevistaListener contrato) {
        assinates.add(contrato);
    }

    //Caso não cancele pode ocorrer o famoso memory leak e dar OutOfMemoryException
    public void cancelarAssinatura(ContratoRevistaListener contrato){
        assinates.remove(contrato);
    }

    //Isso é ponto mais importante do broadcast
    public void publicarRevista(String novaEdicao){
        for(ContratoRevistaListener contrato : assinates){
            contrato.entregarRevistaEvent(novaEdicao);
        }
    }


}
