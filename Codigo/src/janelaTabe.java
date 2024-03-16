import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class janelaTabe extends Janela{
    public void mostrar(){
        JTabbedPane tabbedPane = new JTabbedPane();
            JFrame janela2 = new JFrame("Janela 2");
            JButton button2 = new JButton("Voltar");
            JButton adicionar = new JButton("Adicionar");
            JButton excluir = new JButton("Excluir");

            JPanel panel1 = new JPanel();
            panel1.add(new JLabel("Voce logou com sucesso!"));

            button2.setToolTipText("Clique para voltar");
            button2.setBounds(50, 100, 95, 30);

            janela2.setLayout(new BoxLayout(janela2.getContentPane(), BoxLayout.Y_AXIS));
            
            Box botoesBox2 = new Box(BoxLayout.X_AXIS);
            botoesBox2.add(button2);
            botoesBox2.add(Box.createHorizontalStrut(10));
            botoesBox2.add(adicionar);
            botoesBox2.add(Box.createHorizontalStrut(10));
            botoesBox2.add(excluir);
            botoesBox2.setAlignmentX(Component.CENTER_ALIGNMENT);

            janela2.setMinimumSize(new Dimension(500, 200));
            tabbedPane.addTab("Aba 1", panel1);
            janela2.setVisible(true);
            janela2.getContentPane().add(tabbedPane);
            janela2.add(botoesBox2);
            janela2.setLocationRelativeTo(null);
            
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            button2.addActionListener(e -> {
                janela2.setVisible(false);
                Janela janela = new Janela();
                janela.mostrarJanela();
            });
            adicionar.addActionListener(e -> {
                JPanel panel2 = new JPanel();
                int numAbas = tabbedPane.getTabCount(); 

                for (int i = 0; i < 10; i++) {
                    tabbedPane.addTab("Aba " + (numAbas + 1) , panel2);
                }
                
            });
            excluir.addActionListener(e -> {
                tabbedPane.remove(tabbedPane.getSelectedIndex());
            });
    }
}
