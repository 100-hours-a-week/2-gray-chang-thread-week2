package calculatorService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime implements Runnable{

    @Override
    public void run() {
        AlarmCurrentTime time = AlarmCurrentTime.getInstance();
        time.currentTime();
    }

    public static class AlarmCurrentTime{
        private AlarmCurrentTime(){}

        private static class SingletonHolder {
            private static final AlarmCurrentTime INSTANCE = new AlarmCurrentTime();
        }

        public static AlarmCurrentTime getInstance() {
            return SingletonHolder.INSTANCE;
        }

        public void currentTime(){
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("현재 시간은 HH시 mm분 ss초 입니다");
            System.out.println(formatter.format(now));
        }
    }
}
