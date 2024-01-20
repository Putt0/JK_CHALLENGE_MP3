package github.com.putt0.formulate;

/**
 * Author - Putt0;
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BugReport extends JDialog {

    private JButton jButton1, jButton2;
    private JLabel jLabel1, jLabel2, jLabel3;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextField tbEmail;
    private JTextArea textBug;

    public BugReport(Frame frame, boolean modal) {
        super(frame, modal);

        initComponents();
        setLocationRelativeTo(null);

        jLabel3.setText("");
        jLabel3.setVisible(false);
    }

    private void initComponents() {
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        textBug = new JTextArea();
        tbEmail = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Putt0 MP3 CRACKED - Informe um bug");

        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "O que aconteceu ?", 0, 0
                , new Font("Agency FB", Font.BOLD, 14)));

        textBug.setColumns(20);
        textBug.setRows(5);

        jScrollPane1.setViewportView(textBug);

        jButton1.setText("Enviar");
        jButton1.addActionListener(BugReport.this::jButton1ActionPerformed);
        jButton2.setText("Cancelar");
        jButton2.addActionListener(BugReport.this::jButton2ActionPerformed);
        jLabel1.setText("Seu email");

        jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 10));

        GroupLayout groupLayout = new GroupLayout(jPanel1);
        jPanel1.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, -1, 360, 32767)
                .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbEmail)).addGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addGap(40, 40, 40)
                        .addComponent(jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))
                        .addComponent(jLabel3, -1, -1, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2).addGap(4, 4, 4)
                        .addComponent(jButton1))).addContainerGap()));

        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                        .addComponent(jScrollPane1, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1).addComponent(tbEmail, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1).addComponent(jButton2)).addComponent(jLabel2)).addGap(0, 0, 32767))
                .addGroup(groupLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(jLabel3, -1, -1, 32767)))));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, -2, -1, -2).addContainerGap(21, 32767)));
        setBounds(0, 0, 428, 238);
    }

    private void jButton2ActionPerformed(ActionEvent actionEvent) {
        dispose();
    }


    private void jButton1ActionPerformed(ActionEvent actionEvent) {
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            BugReport bugReport = new BugReport(new JFrame(), true);
            bugReport.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent) {
                    System.exit(0);
                }
            });
            bugReport.setVisible(true);
        });
    }
}