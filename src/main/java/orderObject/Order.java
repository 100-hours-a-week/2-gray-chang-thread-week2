package orderObject;

import calculatorEnum.CalculatorEnum;
import calculatorEnum.MethodName;

public class Order {
    private final CalculatorEnum wantToUse;
    private final MethodName methodName;
    private final int firstNum;
    private final Integer secondNum;

    public CalculatorEnum getWantToUse() {
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

    public Order(CalculatorEnum wantToUse, MethodName methodName, int firstNum, int secondNum) {
        this.wantToUse = wantToUse;
        this.methodName = methodName;
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public Order(CalculatorEnum wantToUse, MethodName methodName, int firstNum) {
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