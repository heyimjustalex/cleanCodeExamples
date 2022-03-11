package customcalculation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class CustomCalculationTest {

    private CustomCalculation customCalculation;

    @BeforeEach
    void setup() {
        char[] separators = {';', ',', '.', ':'};
        customCalculation = new CustomCalculation(separators);
    }

    @Nested
    class MathOperationOnStringTests {

        // todo: make one function instead of these three to introduce parameterized tests
        @Test
        void should_doCorrectAddition_when_correctInput() {
            // given
            String input = "12;43;2+";

            // when
            BigInteger result = customCalculation.calculate(input);

            // then
            BigInteger expected = BigInteger.valueOf(57);
            assertEquals(expected, result);
        }

        @Test
        void should_doCorrectSubtraction_when_correctInput() {
            // given
            String input = "12;43;2-";

            // when
            BigInteger result = customCalculation.calculate(input);

            // then
            BigInteger expected = BigInteger.valueOf(-57);
            assertEquals(expected, result);
        }

        @Test
        void should_doCorrectMultiplication_when_correctInput() {
            // given
            String input = "12;43;2*";

            // when
            BigInteger result = customCalculation.calculate(input);

            // then
            BigInteger expected = BigInteger.valueOf(1032);
            assertEquals(expected, result);
        }

        @Test
        void should_workCorrectly_when_onlyOneNumberIsGiven() {
            // given
            String input = "12+";

            // when
            BigInteger result = customCalculation.calculate(input);

            // then
            BigInteger expected = BigInteger.valueOf(12);
            assertEquals(expected, result);
        }

        @Test
        void should_throwException_when_inputEmpty() {
            // given
            String emptyString = "";

            // when
            Executable executable = () -> customCalculation.calculate(emptyString);

            // then
            assertThrows(RuntimeException.class, executable);
        }

        @Test
        void should_throwException_when_numbersAreMissing() {
            // given
            String justOperator = "+";

            // when
            Executable executable = () -> customCalculation.calculate(justOperator);

            // then
            assertThrows(RuntimeException.class, executable);
        }

        @Test
        void should_throwException_when_OperatorIsMissing() {
            // given
            String inputWithoutOperator = "12;43;";

            // when
            Executable executable = () -> customCalculation.calculate(inputWithoutOperator);

            // then
            assertThrows(RuntimeException.class, executable);
        }

        @Test
        void should_throwException_when_numbersAreIncorrect() {
            // given
            String incorrectNumbers = "12;43/;31;+";

            // when
            Executable executable = () -> customCalculation.calculate(incorrectNumbers);

            // then
            assertThrows(NumberFormatException.class, executable);
        }

    }
}