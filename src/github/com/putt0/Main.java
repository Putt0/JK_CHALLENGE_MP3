package github.com.putt0;

/**
 * Author - Putt0;
 */

import github.com.putt0.formulate.FormulateMain;

import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

    public Main() {}

    public static void main(String[] args)
            throws UnsupportedAudioFileException, IOException
    {
        new FormulateMain().setVisible(true);
    }
}