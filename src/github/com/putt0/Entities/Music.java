package github.com.putt0.Entities;

/**
 * Author - Putt0;
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Music implements Serializable {

    String name, author, album, data;
    Long timer;
    String right, comments, path;

    public Music(String name, String author, String album, String data, Long timer, String right, String comments
            , String path) {
        this.name = name;
        this.author = author;
        this.album = album;
        this.data = data;
        this.timer = timer;
        this.right = right;
        this.comments = comments;
        this.path = path;
    }

    /**
     * get
     */

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getAlbum() {
        return album;
    }

    public String getData() {
        return data;
    }

    public Long getTimer() {
        return timer;
    }

    public String getRight() {
        return right;
    }

    public String getComments() {
        return comments;
    }

    public String getPath() {
        return path;
    }

    /**
     * set
     */

    public Music() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTimer(Long timer) {
        this.timer = timer;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String toString() {
        return "Musica{Nome=" + name + ", Autor=" + author + ", Album=" + album + ", data=" + data + ", tempo=" + timer
                + ", direitos=" + right + ", comentario=" + comments + '}';
    }

    public void serializeListMusics(ArrayList<Music> listMusics, String archive) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(archive);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listMusics);
        } catch (IOException ioException) {
            System.out.print(ioException.getMessage());
        } finally {
            try {
                Objects.requireNonNull(fileOutputStream).close();
                Objects.requireNonNull(objectOutputStream).close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ArrayList<Music> deserializeListMusics(String archive) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        ArrayList arrayList = new ArrayList();

        try {
            fileInputStream = new FileInputStream(archive);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList)objectInputStream.readObject();
        } catch (ClassNotFoundException|IOException ex) {
            System.out.print(ex.getMessage());
        } finally {
            try {
                Objects.requireNonNull(fileInputStream).close();
                Objects.requireNonNull(objectInputStream).close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }
}