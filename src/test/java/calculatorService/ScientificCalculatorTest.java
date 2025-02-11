package calculatorService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Math.toRadians;

class ScientificCalculatorTest {

    ScientificCalculator scientificCalculator;
    int a;

    @BeforeEach
    void setUp() {
        a = 90;
        scientificCalculator = new ScientificCalculator(a);
    }


    @Test
    void sin() {
        Assertions.assertThat(scientificCalculator.sin()).isEqualTo(Math.sin(toRadians(a)));
    }

    @Test
    void cos() {
        Assertions.assertThat(scientificCalculator.cos()).isEqualTo(Math.cos(toRadians(a)));
    }

    @Test
    void tan() {
        Assertions.assertThat(scientificCalculator.tan()).isEqualTo(Math.tan(toRadians(a)));
    }
}