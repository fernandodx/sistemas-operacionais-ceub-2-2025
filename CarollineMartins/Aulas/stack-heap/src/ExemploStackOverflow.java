import java.util.HexFormat;

public class ExemploStackOverflow {
    public static String concatenarProblematico(String text, int qtdRepeticao) {
        if(qtdRepeticao<=0) {
            return text;
        }
        
        return concatenarProblematico(text+"*", qtdRepeticao-1);
    }

    public static void main(String[] args) {
        String test = concatenarProblematico("Kauã", 10);
        String test2 = concatenarProblematico("Kauã", 10);
        String test3 = concatenarProblematico("Breno", 10);
        String test4 = new String(concatenarProblematico("Kauã", 10));

        int hashCode = test.hashCode();
        int hashCode2 = test2.hashCode();
        int hashCode3 = test3.hashCode();
        int hashCode4 = test4.hashCode();

        String hexHashCode = Integer.toHexString(hashCode);
        String hexHashCode2 = Integer.toHexString(hashCode2);
        String hexHashCode3 = Integer.toHexString(hashCode3);
        String hexHashCode4 = Integer.toHexString(hashCode4);

        System.out.println(hexHashCode);
        System.out.println(hexHashCode2);
        System.out.println(hexHashCode3);
        System.out.println(hexHashCode4);

        byte[] bytes = test.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        byte[] bytes2 = test2.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        byte[] bytes3 = test3.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        byte[] bytes4 = test4.getBytes(java.nio.charset.StandardCharsets.UTF_8);

        String hexBytes = HexFormat.of().formatHex(bytes);
        String hexBytes2 = HexFormat.of().formatHex(bytes2);
        String hexBytes3 = HexFormat.of().formatHex(bytes3);
        String hexBytes4 = HexFormat.of().formatHex(bytes4);
        
        System.out.println("String bytes (hexadecimal): " + hexBytes);
        System.out.println("String bytes (hexadecimal): " + hexBytes2);
        System.out.println("String bytes (hexadecimal): " + hexBytes3);
        System.out.println("String bytes (hexadecimal): " + hexBytes4);
    }
}
