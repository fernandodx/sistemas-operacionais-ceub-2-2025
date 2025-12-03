package Atividade5;

public class Main {
    public static void main(String[] args) {
        // 1. Cria a Classe Transmissora (fonte de eventos)
        Broadcaster transmissor = new Broadcaster();

        // 2. Cria as Classes Ouvintes (Janelas)
        Janela janelaPrincipal = new Janela("Janela Principal (Visual)");
        Janela painelLog = new Janela("Painel de Log (Sistema)");

        System.out.println("--- FASE 1: Registro ---");
        
        // 3. Registra os ouvintes
        transmissor.registrar(janelaPrincipal);
        transmissor.registrar(painelLog);
        
        System.out.println("Listeners ativos: " + transmissor.getNumListeners());

        // 4. Dispara o primeiro evento
        transmissor.dispararEvento("Usuário Clicou no Botão 'Executar'");

        System.out.println("\n--- FASE 2: Desregistro e Teste de Memory Leak ---");
        
        // 5. O Painel de Log foi fechado, então ele deve ser DESREGISTRADO.
        // Se esta linha faltasse, ocorreria um Memory Leak.
        System.out.println("Removendo 'Painel de Log' para evitar vazamento de memória...");
        transmissor.desregistrar(painelLog);

        System.out.println("Listeners ativos: " + transmissor.getNumListeners());

        // 6. Dispara o segundo evento (apenas a Janela Principal deve receber)
        transmissor.dispararEvento("Processo Concluído com Sucesso");
    }
}
