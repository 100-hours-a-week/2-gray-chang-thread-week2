package calculatorService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NormalCalculatorTest {

    private int a;
    private int b;

    @Test
    void plus() {
        //given
        a=1;
        b=2;
        //when
        Calculator calculator = new NormalCalculator(a,b);
        //then
        Assertions.assertThat(calculator.plus()).isEqualTo(a+b);
    }

    @Test
    void minus() {
        //given
        a=1;
        b=2;
        //when
        Calculator calculator = new NormalCalculator(a,b);
        //then
        Assertions.assertThat(calculator.minus()).isEqualTo(a-b);
    }

    @Test
    void multiply() {
        //given
        a=1;
        b=2;
        //when
        Calculator calculator = new NormalCalculator(a,b);
        //then
        Assertions.assertThat(calculator.multiply()).isEqualTo(a*b);
    }

    @Test
    void divide() {
        //given
        a=1;
        b=2;
        //when
        Calculator calculator = new NormalCalculator(a,b);
        //then
        Assertions.assertThat(calculator.divide()).isEqualTo((float) a /b);
    }
}