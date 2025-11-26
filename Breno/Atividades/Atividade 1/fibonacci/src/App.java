import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite quantos termos da sequência deseja: ");
        int n = sc.nextInt();

        int a = 0; // primeiro termo
        int b = 1; // segundo termo

        System.out.println("Sequência de Fibonacci:");

        if (n >= 1) {
            System.out.print(a + " ");
        }
        if (n >= 2) {
            System.out.print(b + " ");
        }

        for (int i = 3; i <= n; i++) {
            int c = a + b;   // próximo termo
            System.out.print(c + " ");
            a = b;
            b = c;
        }

        sc.close();
    }
}
