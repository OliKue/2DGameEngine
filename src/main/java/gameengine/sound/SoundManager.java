package gameengine.sound;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SoundManager {
    private static final SoundManager OBJ = new SoundManager();
    private SoundManager(){
        this.init();
    }

    public static SoundManager getInstance(){return OBJ;}

    Clip music;

    Clip clip;
    Map<String, URL> soundsMap = new HashMap<>();

    public void init() {
        //Sounds
        soundsMap.put("fireBowStart", getClass().getResource("/sounds/FireBowStart.wav"));
        soundsMap.put("fireBowFlying", getClass().getResource("/sounds/FireBowFlying.wav"));
        soundsMap.put("fireBowEnd", getClass().getResource("/sounds/FireBowEnd.wav"));

        soundsMap.put("wraith01_following", getClass().getResource("/sounds/wraith01_following.wav"));
        soundsMap.put("wraith01_hit", getClass().getResource("/sounds/wraith01_hit.wav"));

        //Music
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/sounds/Emotional Loop 2.wav"));
            music = AudioSystem.getClip();
            music.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setFile(String key) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundsMap.get(key));
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playMusic() {
        FloatControl volume = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(-20f);
        music.start();
        music.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
