package github.com.putt0.formulate;

/**
 * Author - Putt0;
 */

import github.com.putt0.entities.Music;
import github.com.putt0.TableModel.MusicModel;
import github.com.putt0.Utils.Timer;
import javazoom.jl.player.Player;

import javax.sound.sampled.FloatControl;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.Map;

public class FormulateMain extends JFrame {

    public FormulateMain() {
        initComponents();
        setLocationRelativeTo(null);
        tbPlayListAtual.setModel(modeloMusicas);
        setLayoutTabela();
        lbTituloTocando.setText("Selecionado:");
        lbTocandoAgora.setText("Nenhum");
        lbAutor.setText("Nenhum");
        slider1.setValue(0);
        btstop.setEnabled(false);
        fc.setMultiSelectionEnabled(true);
        jcSalvaLista.setMultiSelectionEnabled(false);
        jcSalvaLista.setApproveButtonText("Salvar");

        if (tbPlayListAtual.getRowCount() > 0) {
            btSalvaListaAtual.setEnabled(true);
            btExcluiListaAtual.setEnabled(true);
            btMistura.setEnabled(true);
        } else {
            btSalvaListaAtual.setEnabled(false);
            btExcluiListaAtual.setEnabled(false);
            btMistura.setEnabled(false);
        }
        setIconImage(new ImageIcon("src/Icons/AppIcon.png").getImage());
    }

    public void StopMusica() {}

    private void initComponents() {
        jPanel1 = new JPanel();
        btAddmusica = new JButton();
        btRemoveMusica = new JButton();
        btMistura = new JButton();
        jPanel2 = new JPanel();
        btplay = new JButton();
        btstop = new JButton();
        jPanel5 = new JPanel();
        lbTituloTocando = new JLabel();
        lbTocandoAgora = new JLabel();
        slider1 = new JSlider();
        lbtempoDecorrido = new JLabel();
        lbAnime = new JLabel();
        lbtituloAutor = new JLabel();
        lbAutor = new JLabel();
        pnPrograma = new JPanel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        btAnteriorMusica = new JButton();
        btProximaMusica = new JButton();
        jPanel4 = new JPanel();
        jScrollPane1 = new JScrollPane();
        tbPlayListAtual = new JTable();
        jPanel3 = new JPanel();
        btSalvaListaAtual = new JButton();
        btImportaListaAtual = new JButton();
        btExcluiListaAtual = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Putt0 MP3 CRACKED");

        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Opções - Musicas", 0, 0
                , new Font("Agency FB", Font.BOLD, 14)));
        jPanel1.setToolTipText("Opções Musicas");
        jPanel1.setLayout(new GridLayout(1, 0));

        btAddmusica.setFont(new Font("Agency FB", Font.BOLD, 14));
        btAddmusica.setIcon(new ImageIcon("src/Icons/AddMusica.png"));
        btAddmusica.setText("Adicionar");
        btAddmusica.addActionListener(FormulateMain.this::btAddmusicaActionPerformed);
        jPanel1.add(btAddmusica);

        btRemoveMusica.setFont(new Font("Agency FB", Font.BOLD, 14));
        btRemoveMusica.setIcon(new ImageIcon("src/Icons/removeMusica.png"));
        btRemoveMusica.setText("Remover");
        btRemoveMusica.addActionListener(FormulateMain.this::btRemoveMusicaActionPerformed);
        jPanel1.add(btRemoveMusica);

        btMistura.setFont(new Font("Agency FB", Font.BOLD, 14));
        btMistura.setIcon(new ImageIcon("src/Icons/misturar.png"));
        btMistura.setText("Misturar");
        btMistura.addActionListener(FormulateMain.this::btMisturaActionPerformed);
        jPanel1.add(btMistura);

        jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Você está UTILIZANDO uma versão LIMITADA!", 2, 2
                , new Font("Agency FB", Font.ITALIC + Font.BOLD, 14)));
        jPanel2.setToolTipText("Tocando agora");

        btplay.setFont(new Font("Agency FB", Font.BOLD, 14));
        btplay.setIcon(new ImageIcon("src/Icons/play.png"));
        btplay.setText("Play");
        btplay.addActionListener(FormulateMain.this::btplayActionPerformed);
        btstop.setFont(new Font("Agency FB", Font.BOLD, 14));
        btstop.setIcon(new ImageIcon("src/Icons/stop.png"));
        btstop.setText("Stop");
        btstop.addActionListener(FormulateMain.this::btstopActionPerformed);
        jPanel5.setBackground(UIManager.getDefaults().getColor("Button.highlight"));
        jPanel5.setBorder(BorderFactory.createEtchedBorder());

        lbTituloTocando.setFont(new Font("Agency FB", Font.BOLD, 14));
        lbTituloTocando.setText("Tocando:");

        lbTocandoAgora.setFont(new Font("Agency FB", Font.BOLD, 14));
        lbTocandoAgora.setText("jLabel2");

        slider1.setBackground(new Color(255, 255, 255));

        lbtempoDecorrido.setText("00:00:00");

        lbAnime.setIcon(new ImageIcon("src/Icons/sp1.png"));

        lbtituloAutor.setFont(new Font("Agency FB", Font.BOLD, 14));
        lbtituloAutor.setText("Autor:");

        lbAutor.setFont(new Font("Agency FB", Font.BOLD, 14));
        lbAutor.setText("jLabel2");

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup().addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(slider1, -2, 0, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbtempoDecorrido, -2, 54, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbAnime, -2, 40, -2).addGap(25, 25, 25))
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                .addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lbtituloAutor).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAutor, -1, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lbTituloTocando).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTocandoAgora, -2, 182, -2))).addContainerGap(-1, 32767)))));

        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTocandoAgora).addComponent(lbTituloTocando)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lbAutor)
                        .addComponent(lbtituloAutor)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, 32767)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(slider1, GroupLayout.Alignment.TRAILING, -2, 34, -2)
                        .addComponent(lbAnime, GroupLayout.Alignment.TRAILING, -2, 43, -2)
                        .addComponent(lbtempoDecorrido, GroupLayout.Alignment.TRAILING, -2, 34, -2))));

        pnPrograma.setBorder(BorderFactory.createTitledBorder(null, null, 0, 0
                , new Font("Agency FB", Font.BOLD, 14)));

        jButton2.setIcon(new ImageIcon("src/Icons/Sobre.png"));
        jButton2.setToolTipText("Sobre o programa");
        jButton2.addActionListener(FormulateMain.this::jButton2ActionPerformed);
        jButton3.setIcon(new ImageIcon("src/Icons/bug.png"));
        jButton3.setToolTipText("Informe um problema");
        jButton3.addActionListener(FormulateMain.this::jButton3ActionPerformed);
        GroupLayout pnProgramaLayout = new GroupLayout(pnPrograma);
        pnPrograma.setLayout(pnProgramaLayout);
        pnProgramaLayout.setHorizontalGroup(pnProgramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jButton2, -2, 35, -2).addComponent(jButton3, -2, 0, 32767));
        pnProgramaLayout.setVerticalGroup(pnProgramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pnProgramaLayout.createSequentialGroup().addComponent(jButton2).addGap(31, 31, 31)
                        .addComponent(jButton3, -1, -1, 32767)));

        btAnteriorMusica.setIcon(new ImageIcon("src/Icons/anterior.png"));
        btAnteriorMusica.addActionListener(FormulateMain.this::btAnteriorMusicaActionPerformed);
        btProximaMusica.setIcon(new ImageIcon("src/Icons/proxima.png"));
        btProximaMusica.addActionListener(FormulateMain.this::btProximaMusicaActionPerformed);
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btAnteriorMusica, -2, 0, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btProximaMusica, -2, 43, -2)).addComponent(btplay, -1, 100, 32767)
                                .addComponent(btstop, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnPrograma, -2, -1, -2)));

        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(pnPrograma, -2, 117, -2).addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btplay, -2, 36, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btstop, -2, 34, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(btAnteriorMusica, -2, 24, 32767).addComponent(btProximaMusica, -2, 0, 32767)))).addGap(0, 0, 32767))
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jPanel5, -2, -1, -2).addContainerGap(-1, 32767)));

        jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Musicas", 0, 0
                , new Font("Agency FB", Font.BOLD, 14)));

        tbPlayListAtual.setAutoCreateRowSorter(true);
        tbPlayListAtual.setBorder(BorderFactory.createEtchedBorder());
        tbPlayListAtual.setFont(new Font("Century Gothic", Font.BOLD, 10));
        tbPlayListAtual.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }
                , { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }
                , new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));

        tbPlayListAtual.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbPlayListAtual.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbPlayListAtual.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                FormulateMain.this.tbPlayListAtualMouseClicked(mouseEvent);
            }

            public void mouseEntered(MouseEvent mouseEvent) { FormulateMain.this.tbPlayListAtualMouseEntered(mouseEvent);
            }
        });
        jScrollPane1.setViewportView(tbPlayListAtual);

        jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Opções Listas", 0, 0
                , new Font("Agency FB", Font.BOLD, 14)));
        jPanel3.setLayout(new GridLayout(1, 0));

        btSalvaListaAtual.setFont(new Font("Agency FB", Font.BOLD, 14));
        btSalvaListaAtual.setIcon(new ImageIcon("src/Icons/addLista.png"));
        btSalvaListaAtual.setText("Salvar lista");
        btSalvaListaAtual.addActionListener(FormulateMain.this::btSalvaListaAtualActionPerformed);
        jPanel3.add(btSalvaListaAtual);

        btImportaListaAtual.setFont(new Font("Agency FB", Font.BOLD, 14));
        btImportaListaAtual.setIcon(new ImageIcon("src/Icons/importarLista.png"));
        btImportaListaAtual.setText("Importar lista");
        btImportaListaAtual.addActionListener(FormulateMain.this::btImportaListaAtualActionPerformed);
        jPanel3.add(btImportaListaAtual);

        btExcluiListaAtual.setFont(new Font("Agency FB", Font.BOLD, 14));
        btExcluiListaAtual.setIcon(new ImageIcon("src/Icons/LimparLista.png"));
        btExcluiListaAtual.setText("Limpar lista");
        btExcluiListaAtual.addActionListener(FormulateMain.this::btExcluiListaAtualActionPerformed);
        jPanel3.add(btExcluiListaAtual);

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, -2, 0, 32767).addComponent(jPanel3, -1, 425, 32767));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup().addComponent(jScrollPane1, -1, 172, 32767).addGap(18, 18, 18)
                        .addComponent(jPanel3, -2, 64, -2).addGap(7, 7, 7)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(jPanel4, -1, -1, 32767)
                        .addComponent(jPanel2, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, -1, -1, 32767).addGap(16, 16, 16)));
        pack();
    }


    public void setLayoutTabela() {
        tbPlayListAtual.getColumnModel().getColumn(0).setPreferredWidth(150);
        tbPlayListAtual.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbPlayListAtual.getColumnModel().getColumn(2).setPreferredWidth(70);
        tbPlayListAtual.setRowSorter(null);
    }


    private void btAddmusicaActionPerformed(ActionEvent actionEvent) {
        if (fc.showOpenDialog(jPanel1) == 0) {
            try {
                File[] files = fc.getSelectedFiles();

                for (File file : files) {

                    javax.sound.sampled.AudioFileFormat baseFileFormat = javax.sound.sampled.AudioSystem.getAudioFileFormat(file);


                    if ((baseFileFormat != null)) {
                        Music musica = new Music();

                        Map properties = ((org.tritonus.share.sampled.file.TAudioFileFormat) baseFileFormat).properties();
                        String key = "title";
                        String val = (String) properties.get(key);

                        musica.setName(val);

                        key = "author";
                        val = (String) properties.get(key);
                        musica.setAuthor(val);

                        key = "album";
                        val = (String) properties.get(key);
                        musica.setAlbum(val);

                        key = "duration";
                        Long valLong = (Long) properties.get(key);
                        musica.setTimer(valLong / 1000000L);

                        musica.setPath(file.getAbsolutePath());

                        modeloMusicas.addMusic(musica);
                    }

                }


            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        if (tbPlayListAtual.getRowCount() > 0) {
            btSalvaListaAtual.setEnabled(true);
            btExcluiListaAtual.setEnabled(true);
            btMistura.setEnabled(true);

        } else {
            btMistura.setEnabled(false);
            btSalvaListaAtual.setEnabled(false);
            btExcluiListaAtual.setEnabled(false);
        }
    }

    private void btRemoveMusicaActionPerformed(ActionEvent actionEvent) {
        int linha = tbPlayListAtual.getSelectedRow();
        if (linha > -1) {

            if ((lbTocandoAgora.getText().equals(modeloMusicas.getMusic(linha).getName().toString()))
                    && (lbTituloTocando.getText().equals("Tocando:"))) {

                stop = Boolean.TRUE;
                tempo.setStopFlag(Boolean.TRUE);
                btstop.setEnabled(false);
                player.close();
                btplay.setEnabled(true);
                btMistura.setEnabled(true);

                lbTituloTocando.setText("Selecionado:");
                lbAutor.setText("Nenhum");
                lbTocandoAgora.setText("Nenhum");
            }

            modeloMusicas.removeMusic(linha);

            if (tbPlayListAtual.getRowCount() > 0) {
                btSalvaListaAtual.setEnabled(true);
                btExcluiListaAtual.setEnabled(true);
                btMistura.setEnabled(true);
            } else {
                btMistura.setEnabled(false);
                btSalvaListaAtual.setEnabled(false);
                btExcluiListaAtual.setEnabled(false);
            }
        }
    }

    private void btMisturaActionPerformed(ActionEvent actionEvent) {
        modeloMusicas.mistura();
        if (tbPlayListAtual.getSelectedRow() > -1) {
            lbTituloTocando.setText("Selecionado:");
            lbAutor.setText(modeloMusicas.getMusic(tbPlayListAtual.getSelectedRow()).getAuthor());
            lbTocandoAgora.setText(modeloMusicas.getMusic(tbPlayListAtual.getSelectedRow()).getName());
        }
    }

    private void tbPlayListAtualMouseEntered(MouseEvent mouseEvent) {}

    private void tbPlayListAtualMouseClicked(MouseEvent mouseEvent) {
        int linha = tbPlayListAtual.getSelectedRow();
        if (linha > -1) {
            if (tempo.getStopFlag() == true) {
                lbTocandoAgora.setText(modeloMusicas.getMusic(linha).getName());
                lbAutor.setText(modeloMusicas.getMusic(linha).getAuthor());
            }
        }
        if (mouseEvent.getClickCount() == 2) {
            if (!lbTituloTocando.getText().equals("Tocando:")) {
                btplayActionPerformed(null);
            } else {
                stop = Boolean.TRUE;
                tempo.setStopFlag(true);
                player.close();
                btplayActionPerformed(null);
            }
        }
    }

    private void btSalvaListaAtualActionPerformed(ActionEvent actionEvent) {
        Music musica = new Music();
        if (jcSalvaLista.showOpenDialog(jPanel1) == 0) {
            musica.serializeListMusics(modeloMusicas.getAsArrayList(), jcSalvaLista.getSelectedFile().getAbsolutePath() + ".dat");
        }
    }


    private void btExcluiListaAtualActionPerformed(ActionEvent evt) {
        if (tbPlayListAtual.getRowCount() > 0) {

            if (lbTituloTocando.getText().equals("Tocando:")) {

                if (JOptionPane.showConfirmDialog(null, "A lista esta em execução\nDeseja interrompe- la?"
                        , "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Icons/dadoerro.png")) == 0) {

                    stop = Boolean.TRUE;
                    tempo.setStopFlag(Boolean.TRUE);
                    btstop.setEnabled(false);
                    player.close();
                    btplay.setEnabled(true);

                    lbTituloTocando.setText("Selecionado:");
                    lbAutor.setText("Nenhum");
                    lbTocandoAgora.setText("Nenhum");
                    modeloMusicas.clear();
                    btMistura.setEnabled(false);
                    btSalvaListaAtual.setEnabled(false);
                    btExcluiListaAtual.setEnabled(false);
                }
            } else {
                modeloMusicas.clear();
                lbTituloTocando.setText("Selecionado:");
                lbAutor.setText("Nenhum");
                lbTocandoAgora.setText("Nenhum");
                btMistura.setEnabled(false);
                btSalvaListaAtual.setEnabled(false);
                btExcluiListaAtual.setEnabled(false);
            }
        }
    }

    private void btImportaListaAtualActionPerformed(ActionEvent actionEvent){
        Music musica = new Music();

        if (jcImportaLista.showOpenDialog(jPanel1) == 0) {
            java.util.ArrayList<Music> musicas = musica.deserializeListMusics(jcImportaLista.getSelectedFile().getAbsolutePath());
            if (lbTituloTocando.getText().equals("Tocando:")) {

                if (JOptionPane.showConfirmDialog(null, "A lista esta em execução\nDeseja interrompe- la?"
                        , "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Icons/dadoerro.png")) == 0) {

                    stop = Boolean.TRUE;
                    player.close();

                    modeloMusicas = new MusicModel(musicas);
                    tbPlayListAtual.setModel(modeloMusicas);
                    lbTituloTocando.setText("Selecionado:");
                    lbTocandoAgora.setText("Nenhum");
                    lbAutor.setText("Nenhum");
                    btplay.setEnabled(true);
                    btstop.setEnabled(false);
                    btMistura.setEnabled(true);
                    btSalvaListaAtual.setEnabled(true);
                    btExcluiListaAtual.setEnabled(true);
                    setLayoutTabela();
                }
            } else {
                modeloMusicas = new MusicModel(musicas);
                tbPlayListAtual.setModel(modeloMusicas);
                lbTituloTocando.setText("Selecionado:");
                lbTocandoAgora.setText("Nenhum");
                lbAutor.setText("Nenhum");
                btplay.setEnabled(true);
                btstop.setEnabled(false);
                setLayoutTabela();
            }
        }
    }


    private void btProximaMusicaActionPerformed(ActionEvent actionEvent) {
        if (tbPlayListAtual.getRowCount() > 0) {
            if (lbTituloTocando.getText().equals("Tocando:")) {
                if (line < tbPlayListAtual.getRowCount() - 1)
                    player.close();
                btplay.setEnabled(false);
                btstop.setEnabled(true);
            }
        }
    }

    private void btAnteriorMusicaActionPerformed(ActionEvent actionEvent) {
        if (tbPlayListAtual.getRowCount() > 0) {
            if (lbTituloTocando.getText().equals("Tocando:")) {
                if (line > 0) {
                    Integer localInteger1 = line;Integer localInteger2 = this.line = line - 1;
                    volta = Boolean.TRUE;
                    player.close();
                    btplay.setEnabled(false);
                    btstop.setEnabled(true);
                }
            }
        }
    }

    private void jButton3ActionPerformed(ActionEvent actionEvent) {
        new BugReport(this, rootPaneCheckingEnabled).setVisible(true);
    }

    private void jButton2ActionPerformed(ActionEvent actionEvent) {
        new About(this, rootPaneCheckingEnabled).setVisible(true);
    }

    private void btstopActionPerformed(ActionEvent actionEvent) {
        if (tbPlayListAtual.getSelectedRow() == -1) {
            lbTocandoAgora.setText("Nenhum");
            lbAutor.setText("Nenhum");
        } else {
            lbAutor.setText(modeloMusicas.getValueAt(tbPlayListAtual.getSelectedRow(), 1).toString());
            lbTocandoAgora.setText(modeloMusicas.getValueAt(tbPlayListAtual.getSelectedRow(), 0).toString());
        }
        stop = Boolean.TRUE;
        tempo.setStopFlag(true);
        player.close();
        btplay.setEnabled(true);
        btstop.setEnabled(false);
        btMistura.setEnabled(true);
        lbTituloTocando.setText("Selecionado:");
    }

    private void btplayActionPerformed(ActionEvent actionEvent) {
        final int linha = tbPlayListAtual.getSelectedRow();
        if (linha > -1) {

            new Thread(() -> {
                line = linha;
                stop = Boolean.FALSE;
                while ((!stop) && (line < modeloMusicas.getRowCount())) {
                    try {
                        player = new Player(Files.newInputStream(new File(modeloMusicas.getMusic(line).getPath()).toPath()));

                        lbtempoDecorrido.setText(String.valueOf(player.getPosition()));
                        tempo = new Timer(lbtempoDecorrido, player, modeloMusicas.getMusic(line).getTimer(), slider1, lbAnime);

                        tempo.start();
                        tbPlayListAtual.setRowSelectionInterval(line, line);
                        lbTituloTocando.setText("Tocando:");
                        lbAutor.setText(modeloMusicas.getMusic(line).getAuthor());
                        lbTocandoAgora.setText(modeloMusicas.getMusic(line).getName());

                        player.play();
                        player.close();
                        tempo.setStopFlag(Boolean.TRUE);
                        Integer localInteger1;
                        if (volta) {
                            volta = Boolean.FALSE;
                        } else {
                            Integer localInteger2 = FormulateMain.this.line = line + 1;
                        }
                        if (line == modeloMusicas.getRowCount()) {
                            int linhaSelecionada = tbPlayListAtual.getSelectedRow();
                            lbTituloTocando.setText("Selecionado:");
                            if (linhaSelecionada > -1) {
                                lbAutor.setText(modeloMusicas.getMusic(tbPlayListAtual.getSelectedRow()).getAuthor());
                                lbTocandoAgora.setText(modeloMusicas.getMusic(tbPlayListAtual.getSelectedRow()).getName());
                            } else {
                                lbAutor.setText("Nenhum");
                                lbTocandoAgora.setText("Nenhum");
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }).start();
            btMistura.setEnabled(false);
            btplay.setEnabled(false);
            btstop.setEnabled(true);
        }
    }

    MusicModel modeloMusicas = new MusicModel();
    JFileChooser fc = new JFileChooser();
    JFileChooser jcSalvaLista = new JFileChooser();
    JFileChooser jcImportaLista = new JFileChooser();
    Player player;
    Boolean volta = Boolean.FALSE;
    Boolean stop = Boolean.FALSE;
    Timer tempo = new Timer();

    Integer line;

    FloatControl volCtrl;
    private JButton btAddmusica, btAnteriorMusica, btExcluiListaAtual, btImportaListaAtual, btMistura;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new FormulateMain().setVisible(true));
    }

    private JButton btProximaMusica, btRemoveMusica, btSalvaListaAtual, btplay, btstop, jButton2, jButton3;
    private JPanel jPanel1, jPanel2, jPanel3, jPanel4, jPanel5;
    private JScrollPane jScrollPane1;
    private JLabel lbAnime, lbAutor, lbTituloTocando, lbTocandoAgora, lbtempoDecorrido, lbtituloAutor;
    private JPanel pnPrograma;
    private JSlider slider1;
    private JTable tbPlayListAtual;
}