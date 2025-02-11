import controller.Controller;
import music.MusicPlayer;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/music/test_music.WAV";
        MusicPlayer musicPlayer = new MusicPlayer(filePath);
        Thread thread = new Thread(musicPlayer);
        thread.setDaemon(true);
        thread.start();

        Controller controller = new Controller();
        controller.calculate();
    }
}