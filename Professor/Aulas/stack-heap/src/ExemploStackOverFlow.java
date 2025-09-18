public class ExemploStackOverFlow {

    public static String concatenarProblematico(String texto, int qtdRepeticao){
        //Aqui dentro tudo é feito na Stack
        if(qtdRepeticao <= 0){
            return texto;
        }
       
        //A cada chamada um novo objetivo String é criado na Stack
        return concatenarProblematico(texto + "*", qtdRepeticao - 1);
    }

    public static void main(String[] args) {

        try {

            String resultado = concatenarProblematico("Maria", 10000);
            System.out.println(resultado);
            
        } catch (StackOverflowError e) {
            System.out.println("ERRO: ######## Estouro de Pilha ##### -> Não consigo Criar mais objetos");
        }
        
    }

}
