public class App {
    public static void main(String[] args) throws Exception {
        
        //"Maria é criada no String pool" .Estamos na Stack
        String nome1 = "Maria";

        // A JVM encontra Maria no Pool e faz nome2 apontar o mesmo objeto na Heap
        String nome2 = "Maria";

        String nome3 = new String("Maria");


        //Quando uso == estou comparando endereços de memória
        System.out.println("nome1 == nome3 ?" +(nome1 == nome3));
        System.out.println(nome1.hashCode());

        System.out.println("nome == nome ? " + nome1.equals(nome3));


        
        

     

    }
}
