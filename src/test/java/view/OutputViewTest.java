package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        outputView = new OutputView();
    }


    @Test
    @DisplayName("정상적으로 값을 출력하는지 테스트")
    void output() {
        //givne
        double result = 30;
        String resultforValidate = String.valueOf(result);

        //when
        outputView.output(result);

        //then
        Assertions.assertThat(outContent.toString()).contains(resultforValidate);
    }
}