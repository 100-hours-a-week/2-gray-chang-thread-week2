package controller;

import calculatorEnum.CalculatorEnum;
import calculatorEnum.MethodName;
import calculatorService.Calculator;
import calculatorService.NormalCalculator;
import calculatorService.ScientificCalculator;
import orderObject.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    @DisplayName("일반계산기, 파라미터를 받을 때 정상적인 연산을 하는지 테스트")
    void makeAnswerNormalCalculator() {
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

    @Test
    @DisplayName("공학용계산기, 파라미터 객체를 받을 때 정상적인 연산을 하는지 테스트")
    void makeAnswerScientificCalculator() {
        Controller controller = new Controller();
        //given
        CalculatorEnum calculatorEnum = CalculatorEnum.Scientific_calculator;
        int firstNum = 1;
        int secondNum = 2;

        //when
        Order orderPlus = new Order(calculatorEnum, MethodName.plus, firstNum, secondNum);
        Order orderSin = new Order(calculatorEnum, MethodName.sin, firstNum);
        Calculator calculator = new ScientificCalculator(firstNum, secondNum);
        Calculator calculatorTrival = new ScientificCalculator(firstNum);
        double answerPlus = controller.makeAnswer(orderPlus, calculator);
        double answerSin = controller.makeAnswer(orderSin, calculatorTrival);

        //then
        Assertions.assertThat(answerPlus).isEqualTo(Double.valueOf(firstNum + secondNum));
        Assertions.assertThat(answerSin).isEqualTo(Math.sin(Math.toRadians(firstNum)));
    }
}