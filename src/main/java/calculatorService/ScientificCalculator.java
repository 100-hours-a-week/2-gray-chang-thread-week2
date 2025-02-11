package calculatorService;

public class ScientificCalculator extends NormalCalculator{

    public int angleInt;

    public ScientificCalculator(int firstInt, int secondInt) {
        super(firstInt, secondInt);
    }

    public ScientificCalculator(int angleInt) {
        super(angleInt, 0);
        this.angleInt = angleInt;
    }

    public double sin(){
        return Math.sin(Math.toRadians(angleInt));
    }

    public double cos(){
        return Math.cos(Math.toRadians(angleInt));
    }

    public double tan(){
        return Math.tan(Math.toRadians(angleInt));
    }

}
