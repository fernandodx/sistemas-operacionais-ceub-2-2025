public class ExemploConcatenarStringCerta {

        public static String concatenarComStringBuilder(String texto, int qntRepeticao){
            StringBuilder textoSb = new StringBuilder(texto);
            for(int i = 0; i < qntRepeticao; i++) {
                textoSb.append(texto);
            }
            concatenar(textoSb, qntRepeticao);
            return textoSb.toString();

        }

        public static void concatenar(StringBuilder sb, int qntRepeticao){
            if (qntRepeticao <= 0) return; 
            sb.append("+");
            concatenar(sb, qntRepeticao -1);
        }
            
                
            public static void main(String[] args) {

                String resultado = concatenarComStringBuilder("Maria", 2000);
                System.out.println(resultado);
            }
            

        }

