public class ExemploStackOverFlow {

    public static String contatenarProblematico(String texto, int qtdRepeticao){
        //Aqui dentro tudo é feito na Stack
        if (qtdRepeticao <= 0) {
            return texto;
            
        }
        //A cada chamada um novo objeto String é criado na Stack
        return contatenarProblematico(texto + "*", qtdRepeticao - 1);
    }

    public static void main(String[] args) {

        try {

            System.out.println(contatenarProblematico("Maria", 5000));


        } catch (StackOverflowError e) {
            System.out.println("ERRO: ####### Estouro d epilha ##### -> Não consigo criar mias objetos");
        }
        
    }

}
