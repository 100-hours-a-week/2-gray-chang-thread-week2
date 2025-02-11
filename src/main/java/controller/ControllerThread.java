package controller;

public class ControllerThread implements Runnable {

    Controller controller = new Controller();

    @Override
    public void run() {
        controller.calculate();
    }
}
