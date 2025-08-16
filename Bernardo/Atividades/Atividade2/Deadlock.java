/*
Deadlock acontece quando duas ou mais tarefas ficam bloqueadas esperando recursos uma da outra, e nenhuma consegue
continuar a execução. Apartir de pesquisas vou explicar com um exemplo "maluco":

Chefe Bernardo precisa da panela e da faca para fazer um prato;
Chefe Fernando precisa da faca e da panela para fazer outro prato;
A cozinha é tão pequena que cada um só pode pegar um item por vez.

Se o cehfe A pega a panela e o Chefe B pega a faca, cada um fica esperando para que o outro libere o item.
Resultado: ninguém consegue terminar o prato, e a cozinha entra em um Deadlock.

Imagine isso como dois carros em uma estrada estreita, cada um esperando o outro passar: nenhum dos dois consegue avançar.
*/

package Bernardo.Atividades.Atividade2;

public class Deadlock {

    public static void main(String[] args) {

        Object panela = new Object();
        Object faca = new Object();

        Thread chefeA = new Thread(() -> {
            synchronized (panela) {
                System.out.println("Chefe A pegou a panela");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (faca) {
                    System.out.println("Chefe A pegou a faca e cozinha!");
                }
            }
        });

        Thread chefeB = new Thread(() -> {
            synchronized (faca) {
                System.out.println("Chefe B pegou a faca");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (panela) {
                    System.out.println("Chefe B pegou a panela e cozinha!");
                }
            }
        });

        // Inicia as threads
        chefeA.start();
        chefeB.start();
    }
}
