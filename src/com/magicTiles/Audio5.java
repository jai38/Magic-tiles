package com.magicTiles;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Audio5 {
    Clip clip;
    AudioInputStream audioInputStream;
    public Audio5()
    {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("Music/5.wav").getAbsoluteFile());
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
