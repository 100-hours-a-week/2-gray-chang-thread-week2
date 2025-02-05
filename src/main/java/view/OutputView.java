package view;

import calculatorEnum.OutputMessage;

public class OutputView {

    public void output(double answer) {
        System.out.println(OutputMessage.returnAnswer.getMessage() + answer);
    }
}
