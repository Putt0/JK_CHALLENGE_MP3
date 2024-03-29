package github.com.putt0.TableModel;

/**
 * Author - Putt0;
 */

import github.com.putt0.entities.Music;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MusicModel extends AbstractTableModel {

    private final String[] colunas = { "Nome", "Autor", "Album" };
    private final ArrayList<Music> linhas;

    public MusicModel() {
        linhas = new ArrayList<>();
    }

    public MusicModel(ArrayList<Music> linhas) {
        this.linhas = linhas;
    }


    public int getRowCount() {
        return linhas.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Music music = linhas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return music.getName();
            case 1:
                return music.getAuthor();
            case 2:
                return music.getAlbum();
        }
        return null;
    }


    public void setValueAt(Object objetct, int rowIndex, int columnIndex) {
        Music music = linhas.get(rowIndex);
        String value = (String)objetct;
        switch (columnIndex) {
            case 0:
                music.setName(value);
                break;
            case 1:
                music.setAuthor(value);
                break;
            case 2:
                music.setAlbum(value);
                break;
        }
        fireTableRowsInserted(rowIndex, rowIndex);
    }

    public String getColumnName(int column) {
        return colunas[column];
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
        }
        return null;
    }


    public void clear() {
        linhas.clear();
        fireTableDataChanged();
    }

    public void addListMusic(List<Music> music) {
        int indice = getRowCount();
        linhas.addAll(music);

        fireTableRowsInserted(indice, indice + music.size());
    }

    public Music getMusic(int rowIndex) {
        return linhas.get(rowIndex);
    }

    public void addMusic(Music music) {
        linhas.add(music);
        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }


    public void removeMusic(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public ArrayList<Music> getAsArrayList() {
        return linhas;
    }

    public void mistura() {
        Collections.shuffle(linhas);

        fireTableRowsUpdated(0, linhas.size() - 1);
    }
}