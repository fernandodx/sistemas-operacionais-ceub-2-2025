import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCalculadora {

    public static void criar () {
        JFrame janela = new JFrame("Multiplicação longa");

        JTextField primeiro = new JTextField(18);
        JTextField segundo = new JTextField(18);

        JButton botao = new JButton(" = ");
        JLabel resultado = new JLabel("Aguardando...");

        botao.addActionListener(new AcaoBotao(primeiro, segundo, resultado));

        JPanel painel = new JPanel();
        painel.add(primeiro);
        painel.add(new JLabel("X"));
        painel.add(segundo);
        painel.add(botao);
        painel.add(resultado);

        janela.add(painel);
        janela.setVisible(true);
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
