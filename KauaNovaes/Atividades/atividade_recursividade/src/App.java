import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("posição do número para calcular: ");
        int n = scanner.nextInt();
        
        if (n < 0) {
            System.out.println("digite um número não-negativo.");
            scanner.close();
            return;
        }

        long resultadoRecursivo = fibRecursivo(n);

        long resultado = fibonacci(n);

        System.out.println("Fibonacci(" + n + ") recursivo: " + resultadoRecursivo);
        System.out.println("Fibonacci(" + n + ") " + resultado);
        
        scanner.close();
    }

    public static long fibRecursivo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecursivo(n - 1) + fibRecursivo(n - 2);
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        
        long anterior = 0;
        long atual = 1;
        long proximo = 0;
        
        for (int i = 2; i <= n; i++) {
            proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }
        
        return atual;
    }
}
