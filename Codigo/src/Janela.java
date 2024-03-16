import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;

public class Janela {

    JFrame janela = new JFrame("Janela");
    JButton button = new JButton("Logar");
    JButton limpa = new JButton("Limpar");
    JLabel user, senh;
    TextField textFields = new TextField(20);
    JPasswordField senha = new JPasswordField(20);
    JTabbedPane tabbedPane = new JTabbedPane();
    JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);

    public void mostrarJanela(){

        user = new JLabel("Usuário");
        senh = new JLabel("Senha");

        button.setToolTipText("Clique para logar");
        limpa.setToolTipText("Clique para limpar os campos");

        user.setAlignmentX(Component.CENTER_ALIGNMENT);
        senh.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFields.setMaximumSize(new Dimension(200, 20));
        senha.setMaximumSize(new Dimension(200, 20));
        janela.setPreferredSize(new Dimension(100, 100));
        janela.setMinimumSize(new Dimension(500, 200));

        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxLayout layout = new BoxLayout(janela.getContentPane(), BoxLayout.Y_AXIS);
        janela.setLayout(layout);

        Box botoesBox2 = new Box(BoxLayout.X_AXIS);
        botoesBox2.add(limpa);
        botoesBox2.add(Box.createHorizontalStrut(10));
        botoesBox2.add(button);

        janela.add(user);
        janela.add(textFields);
        janela.add(senh);
        janela.add(senha);
        janela.add(slider);
        janela.add(botoesBox2);
        
        janela.setLocationRelativeTo(null);
        janela.pack();
        janela.setVisible(true);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                  janelaTabe janela2 = new janelaTabe();
                  janela.setVisible(false);
                  janela2.mostrar();
            }
        });
        limpa.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                textFields.setText("");
                senha.setText("");
                slider.setValue(0);
            }
        });
    }
}
