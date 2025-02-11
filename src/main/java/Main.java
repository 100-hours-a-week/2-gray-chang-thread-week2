import controller.ControllerThread;
import music.MusicPlayer;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/music/Mediterranean-View-Everet-Almond.wav";
        MusicPlayer musicPlayer = new MusicPlayer(filePath);
        Thread musicThread = new Thread(musicPlayer);
        musicThread.setDaemon(true);
        musicThread.start();

        ControllerThread controller = new ControllerThread();
        Thread controllerThread = new Thread(controller);
        controllerThread.start();
    }
}