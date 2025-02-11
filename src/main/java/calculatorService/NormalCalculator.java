package calculatorService;

public class NormalCalculator implements Calculator{
    public int firstInt;
    public int secondInt;

    public NormalCalculator(int firstInt, int secondInt) {
        this.firstInt = firstInt;
        this.secondInt = secondInt;
    }

    @Override
    public double plus() {
        return firstInt + secondInt;
    }

    @Override
    public double minus() {
        return firstInt - secondInt;
    }

    @Override
    public double multiply() {
        return firstInt * secondInt;
    }

    @Override
    public double divide() {
        return (double) firstInt / secondInt;
    }
}
