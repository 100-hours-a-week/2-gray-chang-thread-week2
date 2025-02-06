package controller;

import calculatorEnum.CalculatorEnum;
import calculatorEnum.MethodName;
import calculatorService.Calculator;
import calculatorService.NormalCalculator;
import orderObject.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    @DisplayName("정상적인 연산을 하는지 테스트")
    void makeAnswer() {
        Controller controller = new Controller();
        //given
        CalculatorEnum calculatorEnum = CalculatorEnum.Normal_calculator;
        int firstNum = 1;
        int secondNum = 2;

        //when
        Order order = new Order(calculatorEnum, MethodName.plus, firstNum, secondNum);
        Calculator calculator = new NormalCalculator(firstNum, secondNum);
        double answer = controller.makeAnswer(order, calculator);

        //then
        Assertions.assertThat(answer).isEqualTo(Double.valueOf(firstNum + secondNum));
    }
}