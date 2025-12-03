public class ExemploConcatStringCerto {
    public static String concatenarComStringBuilder(String texto, long qtdRepeticao) {
        StringBuilder textoSb = new StringBuilder(texto);

        for (int i=0;i<qtdRepeticao;i++) {
            textoSb.append("*");
        }
        
        return textoSb.toString();
    }

    public static void concatenar(StringBuilder sb, long qtdRepeticao){
        if (qtdRepeticao==0) return;
        sb.append("*");
        concatenar(sb, qtdRepeticao-1);
    }

    public static void main(String[] args) {
        String test = concatenarComStringBuilder("teste", 100000000);
        System.out.println(test);
    }
}
