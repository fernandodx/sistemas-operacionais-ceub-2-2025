public class App {
    public static void main(String[] args) throws Exception {
        String nome = "Maria";
        System.out.println(nome.codePoints());
        String nome2 = "Maria";
        System.out.println(nome2.codePoints());

        String nome3 = new String("Maria");
        System.out.println(nome3.codePoints());

        String nome4 = "João";
        System.out.println(nome4.codePoints());

        nome = "Felipe";
        System.out.println(nome.codePoints());
        nome2 = "Felipe";
        System.out.println(nome2.hashCode());
        nome = "Maria";

        System.out.println("nome == nome 3 ?" + (nome == nome3));
        System.out.println("nome == nome 3 ?" + (nome == nome2));
        System.out.println("nome == nome 3 ?" + (nome2 == nome3));
        System.out.println("nome equals nome3 ?" + (nome.equals(nome3)));
    }
}
