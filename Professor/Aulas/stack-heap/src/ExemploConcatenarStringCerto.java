public class ExemploConcatenarStringCerto {

    public static String concaternarComStringBuilder(String texto, int qtdRepeticao) {
        StringBuilder textoSb = new StringBuilder(texto);

        for(int i=0; i < qtdRepeticao; i++){
            textoSb.append("*");
        }
        
        return textoSb.toString();
    }

    public static void concatenar(StringBuilder sb, int qtdRepeticao){
        if(qtdRepeticao <= 0 ) return;
        sb.append("*");
        concatenar(sb, qtdRepeticao - 1);
    }

    public static void main(String[] args) {

       String resultado = concaternarComStringBuilder("Maria", 1000000);
       System.out.println(resultado);
    }

}
