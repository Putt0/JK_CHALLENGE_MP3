package github.com.putt0.Utils;

/**
 * Author - Putt0;
 */

import javazoom.jl.player.Player;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Timer extends Thread {

    JLabel lbtimer, img;
    Player player;
    Long duration;
    JSlider slider;
    Boolean stopFlag;

    /**
     *
     * get
     */

    public Boolean getStopFlag() {
        return stopFlag;
    }

    /**
     *
     * set
     */

    public void setStopFlag(Boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

    public Timer(Boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

    public Timer() {
        stopFlag = Boolean.TRUE;
    }

    public Timer(JLabel timer, Player player, Long duration, JSlider slider, JLabel img) {
        lbtimer = timer;
        this.player = player;
        this.duration = duration;
        this.slider = slider;
        stopFlag = Boolean.FALSE;
        this.img = img;
    }


    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        Date data = new Date(calendar.getTime().getTime());

        int index = 2;
        slider.setMaximum(duration.intValue());
        while (!stopFlag) {
            System.out.print(stopFlag);
            calendar.clear();
            int value = player.getPosition() / 1000;
            calendar.add(Calendar.SECOND, value);
            slider.setValue(value);
            data.setTime(calendar.getTime().getTime());
            lbtimer.setText(simpleDateFormat.format(data));


            img.setIcon(new ImageIcon("src/Icons/sp" + index + ".png"));
            index = index + 1;
            if (index > 5) {
                index = 2;
            }

            try {
                Thread.sleep(200L);
            } catch (Exception ignored) {} }
        System.out.print(stopFlag);
        slider.setValue(0);
        lbtimer.setText("00:00:00");
        img.setIcon(new ImageIcon("src/Icons/sp1.png"));
    }
}