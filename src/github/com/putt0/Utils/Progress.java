package github.com.putt0.Utils;

/**
 * Author - Putt0;
 */

import github.com.putt0.entities.Music;
import org.tritonus.share.sampled.file.TAudioFileFormat;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;

public class Progress extends JDialog {

    private JProgressBar progressBar;
    private JLabel jLabel1, jLabel2, lbAcao;
    private JPanel jPanel1;

    Integer capacityProgressBar;
    File[] musics;
    ArrayList<Music> modelMusic;

    public Progress(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        modelMusic = new ArrayList<>();
        capacityProgressBar = 0;
    }

    /**
     *
     * get
     */

    public File[] getMusics() {
        return musics;
    }

    public ArrayList<Music> getModelMusic() {
        return modelMusic;
    }

    public Integer getCapacityProgressBar() {
        return capacityProgressBar;
    }

    /**
     *
     * set
     */

    public void setMusics(File[] musics) {
        this.musics = musics;
    }

    public void setModelMusic(ArrayList<Music> modelMusic) {
        this.modelMusic = modelMusic;
    }

    public void addMusics() {
        try {
            progressBar.setMaximum(musics.length);

            for (int i = 0; i < musics.length; i++) {

                AudioFileFormat baseFileFormat = AudioSystem.getAudioFileFormat(musics[i]);


                if ((baseFileFormat instanceof TAudioFileFormat)) {
                    Music musica = new Music();

                    Map properties = ((TAudioFileFormat)baseFileFormat).properties();
                    String key = "title";
                    String val = (String)properties.get(key);
                    lbAcao.setText("Adcionando " + val + ".mp3");
                    musica.setName(val);

                    key = "author";
                    val = (String)properties.get(key);
                    musica.setAuthor(val);

                    key = "album";
                    val = (String)properties.get(key);
                    musica.setAlbum(val);

                    key = "duration";
                    Long valLong = (Long)properties.get(key);
                    musica.setTimer(valLong / 1000000L);

                    musica.setPath(musics[i].getAbsolutePath());

                    modelMusic.add(musica);

                    progressBar.setValue(i);
                }

            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setCapacityProgressBar(Integer capacityProgressBar) {
        this.capacityProgressBar = capacityProgressBar;
    }

    public JLabel getLbAcao() {
        return lbAcao;
    }

    public void setLbAcao(JLabel lbAcao) {
        this.lbAcao = lbAcao;
    }

    public void setValueProgresso(Integer valor) {
        progressBar.setValue(valor);
    }

    public void setMaximunValue(Integer valor) {
        progressBar.setMaximum(valor);
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        progressBar = new JProgressBar();
        jLabel2 = new JLabel();
        lbAcao = new JLabel();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Progresso da ação", 0, 0
                , new Font("Agency FB", Font.BOLD, 14)));

        jLabel2.setFont(new java.awt.Font("Agency FB", Font.BOLD, 14));
        jLabel2.setText("Ação:");

        lbAcao.setText("Ação");

        jLabel1.setFont(new java.awt.Font("Agency FB", Font.BOLD, 14));
        jLabel1.setText("Carregando...");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAcao)).addComponent(jLabel1).addComponent(progressBar, -2, 365, -2)).addContainerGap()));

        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                        .addComponent(progressBar, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
                        .addComponent(lbAcao)).addGap(22, 22, 22)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, -2, -1, -2)
                        .addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, -2, 108, 32767)
                        .addContainerGap()));
        setBounds(0, 0, 433, 168);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Progress dialog = new Progress(new JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter()
            {
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
}
