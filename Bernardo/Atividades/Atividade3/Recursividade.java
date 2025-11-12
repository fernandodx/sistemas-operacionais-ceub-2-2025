import java.util.Scanner;
package Atividade3;

public class Recursividade {
    public static long fibonacci(int n) {
        if (n <= 0) return 0;   // caso base 0
        if (n == 1) return 1;   // caso base 1
        return fibonacci(n - 1) + fibonacci(n - 2); // chamada recursiva
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite n (ex: 10): ");
        int n = sc.nextInt();
        System.out.println("F(" + n + ") = " + fibonacci(n));
        sc.close();
    }
}