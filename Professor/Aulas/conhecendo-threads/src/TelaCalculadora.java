
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCalculadora {

    public static void criar() {
        JFrame janela = new JFrame("Multiplicação Longa");

        //Configura o tamanho da tela
        janela.setLayout(new FlowLayout(FlowLayout.CENTER)); 
       
        JTextField primeiro = new JTextField(18);
        JTextField segundo = new JTextField(18);

        JButton botao = new JButton(" = ");
        JLabel resultado = new JLabel(" Aguardando... ");
    
        JPanel painelEntrada = new JPanel();
        painelEntrada.add(primeiro);
        painelEntrada.add(new JLabel(" X "));
        painelEntrada.add(segundo);
        painelEntrada.add(botao);

        janela.add(painelEntrada);
        janela.add(resultado);

        botao.addActionListener(new AcaoBotao(primeiro, segundo, resultado));

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setVisible(true);
    }
}