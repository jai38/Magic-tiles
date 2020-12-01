package com.magicTiles;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio1 {
    Clip clip;
    AudioInputStream audioInputStream;
    public Audio1()
    {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("Music/1.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void playAudio() {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stopAudio() {
        clip.stop();
    }
}
