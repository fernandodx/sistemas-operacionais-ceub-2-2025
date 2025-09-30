import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;


public class AcaoBotao implements ActionListener {
    private JTextField primeiro;
    private JTextField segundo;
    private JLabel resultado;

    public AcaoBotao(JTextField primeiro, JTextField segundo, JLabel resultado) {
        super();
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.resultado = resultado;
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                long valor1 = Long.parseLong(primeiro.getText());
                long valor2 = Long.parseLong(segundo.getText());
        
                BigInteger calculo = new BigInteger("0");
                for (int i=0;i<valor1;i++) {
                    System.out.println("rota1: " + calculo);
                    for (int j=0;j<valor2;j++) {
                        calculo = calculo.add(new BigInteger("1"));
                        System.out.println("rota2: " + calculo);
                    }
                }
                resultado.setText(calculo.toString());
            }
        });

        thread.start();
        
    }
}
