package Atividades.Atividade3;

import java.util.Scanner;

public class Recursividade {

    // Implementação recursiva da sequência de Fibonacci
    public static long fibonacci(int n) {
        if (n <= 0)
            return 0L; // caso base para n <= 0
        if (n == 1)
            return 1L; // caso base para n == 1
        return fibonacci(n - 1) + fibonacci(n - 2); // chamada recursiva
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite n (ex: 10): ");
        int n;
        try {
            n = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Usando n = 10 por padrão.");
            n = 10;
        }

        System.out.println("F(" + n + ") = " + fibonacci(n));
        sc.close();
    }
}