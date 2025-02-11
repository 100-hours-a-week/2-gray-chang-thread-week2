package orderObject;

import calculatorEnum.CalculatorName;
import calculatorEnum.MethodName;

public class Order {
    private final CalculatorName wantToUse;
    private final MethodName methodName;
    private final int firstNum;
    private final Integer secondNum;

    public CalculatorName getWantToUse() {
        return wantToUse;
    }

    public MethodName getMethodName() {
        return methodName;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public Order(CalculatorName wantToUse, MethodName methodName, int firstNum, int secondNum) {
        this.wantToUse = wantToUse;
        this.methodName = methodName;
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public Order(CalculatorName wantToUse, MethodName methodName, int firstNum) {
        this.wantToUse = wantToUse;
        this.methodName = methodName;
        this.firstNum = firstNum;
        this.secondNum = null;
    }

    @Override
    public String toString() {
        return wantToUse + "." + methodName + "." + firstNum + "." + secondNum;
    }
}