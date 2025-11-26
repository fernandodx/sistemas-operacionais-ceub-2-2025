package Atividades.Atividade3;

public class Recursividade {
        static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;  // por exemplo, calculando até o décimo número
        System.out.println("Fibonacci de " + n + " = " + fibonacci(n));
    }
}