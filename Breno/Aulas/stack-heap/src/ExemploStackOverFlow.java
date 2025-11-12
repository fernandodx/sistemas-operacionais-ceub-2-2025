public class ExemploStackOverFlow {

    public static String concatenarProblematico(String texto, int quantidadeRepeticao){
        //Aqui dentro tudo é feito na Stack
        if(quantidadeRepeticao <= 0){
            return texto;
        }
        //A cada chamada um novo objeto String é criado na Stack
        return concatenarProblematico(texto + "*", quantidadeRepeticao - 1);
    }
    public static void main(String[] args) {
        try {
            String resultado = concatenarProblematico("Breno", 100);
            System.out.println(resultado);
        } catch (StackOverflowError e) {
            System.out.println("Erro: ### Estouro de Pilhas ### -> Não consigo criar mais objetos");
            // TODO: handle exception
        }
        
    }
}
