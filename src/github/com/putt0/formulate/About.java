package github.com.putt0.formulate;

/**
 * Author - Putt0;
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class About extends JDialog {

    private JButton btOk;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel5, jLabel6, jLabel8, jLabel9;
    private JPanel jPanel1;

    public About(Frame frame, boolean modal) {
        super(frame, modal);

        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        btOk = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jPanel1 = new JPanel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Putt0 MP3 CRACKED - Sobre");

        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Sobre", 0, 0
                , new Font("Agency FB", Font.BOLD, 14)));

        jLabel1.setFont(new Font("Agency FB", Font.PLAIN, 14));
        jLabel1.setText("Versão");

        jLabel2.setFont(new Font("Agency FB", Font.PLAIN, 14));
        jLabel2.setText("Desenvolvedor:");

        jLabel5.setText("Reinaldy Oliveira");
        jLabel6.setText("0.0.0.1");

        jLabel8.setIcon(new ImageIcon("src/Icons/AppIcon.png"));

        jLabel9.setFont(new java.awt.Font("Agency FB", Font.BOLD, 18));
        jLabel9.setText("Putt0 MP3 CRACKED");

        javax.swing.GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(144, 144, 144)
                        .addComponent(jLabel3)).addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, -2, 128, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, -1, 234, 32767))
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                        .addComponent(jLabel9)).addGap(0, 0, 32767))))).addContainerGap()));

        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9).addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1).addComponent(jLabel6))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2).addComponent(jLabel5)))
                        .addComponent(jLabel8, -2, 111, -2)).addGap(38, 38, 38)
                        .addComponent(jLabel3).addContainerGap(-1, 32767)));

        btOk.setText("Ok");
        btOk.addActionListener(About.this::btOkActionPerformed);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addGap(213, 213, 213).addComponent(btOk))
                .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                        .addComponent(jPanel1, -2, -1, -2))).addContainerGap(-1, 32767)));

        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                        .addComponent(jPanel1, -2, 134, -2).addGap(63, 63, 63)
                        .addComponent(btOk).addContainerGap(-1, 32767)));

        setBounds(0, 0, 498, 194);
    }

    private void btOkActionPerformed(ActionEvent actionEvent) {
        dispose();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            About about = new About(new JFrame(), true);
            about.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent) {
                    System.exit(0);
                }
            });
            about.setVisible(true);
        });
    }
}