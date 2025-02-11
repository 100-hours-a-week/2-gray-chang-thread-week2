package music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer implements Runnable {
    private String musicFilePath;

    public MusicPlayer(String musicFilePath) {
        this.musicFilePath = musicFilePath;
    }

    public String getMusicFilePath() {
        return musicFilePath;
    }

    public void setMusicFilePath(String musicFilePath) {
        this.musicFilePath = musicFilePath;
    }

    @Override
    public void run() {
        System.out.println("음악이 재생됩니다🎧");
        MusicSingletonHolder music = MusicSingletonHolder.getInstance();
        music.musicRun(musicFilePath);
    }

    public static class MusicSingletonHolder {
        private boolean isRunning = true;

        private MusicSingletonHolder(){}

        private static class SingletonHolder{
            private static final MusicSingletonHolder INSTANCE = new MusicSingletonHolder();
        }

        public static MusicSingletonHolder getInstance(){
            return SingletonHolder.INSTANCE;
        }

        public void musicRun(String musicFilePath){
            while (isRunning) {
                try(AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(musicFilePath))) {
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                    Thread.sleep(clip.getMicrosecondLength()/1000);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void musicStop(){
            isRunning = false;
        }
    }
}
