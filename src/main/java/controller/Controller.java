package controller;

import calculatorEnum.CalculatorName;
import calculatorEnum.MethodName;
import calculatorService.*;
import orderObject.Order;
import view.InputView;
import view.OutputView;

public class Controller {

    private Calculator makeCalculator(Order order) {
        if ((order.getWantToUse()).equals(CalculatorName.Normal_calculator)){
            return new NormalCalculator(order.getFirstNum(), order.getSecondNum());
        } else if (order.getMethodName().equals(MethodName.sin) || (order.getMethodName().equals(MethodName.cos) || order.getMethodName().equals(MethodName.tan))) {
            return new ScientificCalculator(order.getFirstNum());
        } else {
            return new ScientificCalculator(order.getFirstNum(), order.getSecondNum());
        }
    }

    public double makeAnswer(Order order, Calculator calculator) {
        CalculatorMethodMap methodCalcMap = new CalculatorMethodMap(calculator);
        return methodCalcMap.getMethodCalc(order.getMethodName()).get();
    }

    public void calculate() {
        while (true){
            InputView inputView = new InputView();
            Order order = inputView.getCalcInput();
            Calculator calculator = makeCalculator(order);
            double answer = makeAnswer(order, calculator);
            OutputView outputView = new OutputView();
            outputView.output(answer);
            if (inputView.wantToStop().equals("N")) {
                continue;
            } else{
                break;
            }
        }
    }
}