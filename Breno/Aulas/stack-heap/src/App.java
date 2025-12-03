public class App {
    public static void main(String[] args) throws Exception {

        //Maria é criada no String pool. Estamos na Stack
        String nome1 = "Maria";

        //A JVM encontra Maria no Pool e faz nome2 apontar para o mesmo objeto na Heap
        String nome2 = "Maria";

        System.out.println("nome1 == nome2 ? " + (nome1 == nome2));

        String nome3 = new String("Maria");



        System.out.println("nome1 == nome3 ? " + (nome1 == nome3));
        System.out.println(nome1.hashCode());
        System.out.println(nome3.hashCode());

        System.out.println("nome1 == nome3 ? " + nome1.equals(nome3));;

    }
}
