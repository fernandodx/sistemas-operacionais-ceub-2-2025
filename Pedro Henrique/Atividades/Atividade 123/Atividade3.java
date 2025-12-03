import java.util.Scanner;

public class Atividade3 {

    static int calcular(int pos) {
        if (pos == 0) {
            return 0;
        } 
        if (pos == 1) {
            return 1;
        }
        return calcular(pos - 1) + calcular(pos - 2);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a posição da sequência: ");
        int p = entrada.nextInt();

        int resultado = calcular(p);

        System.out.println("Resultado: " + resultado);
    }
}
