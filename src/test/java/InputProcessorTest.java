import DivisionApplication.InputProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputProcessorTest {

    @Test
    public void testInputDividendValidInput() {
        String input = "10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputProcessor inputProcessor = new InputProcessor();

        int expected = 10;
        int actual = inputProcessor.inputDividend();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testInputDividendMultipleInvalidInputs() {
        String input = "invalid\nalso invalid\n10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputProcessor inputProcessor = new InputProcessor();

        int expected = 10;
        int actual = inputProcessor.inputDividend();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testInputDividendInvalidInputs() {
        String input = "invalid\nalso invalid\nnot a number\n10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputProcessor inputProcessor = new InputProcessor();

        int expected = 10;
        int actual = inputProcessor.inputDividend();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testInputDividendNegativeInput() {
        String input = "-5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputProcessor inputProcessor = new InputProcessor();

        int expected = -5;
        int actual = inputProcessor.inputDividend();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testInputDivisorValidInput() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputProcessor inputProcessor = new InputProcessor();

        int expected = 2;
        int actual = inputProcessor.inputDivisor();

        assertEquals(expected, actual);
    }

    @Test
    public void testInputDivisorInvalidInput() {
        String input = "invalid\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputProcessor inputProcessor = new InputProcessor();

        int expected = 3;
        int actual = inputProcessor.inputDivisor();

        assertEquals(expected, actual);
    }

    @Test
    public void testInputDivisorZero() {
        String input = "0\ninvalid\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputProcessor inputProcessor = new InputProcessor();

        int expected = 3;
        int actual = inputProcessor.inputDivisor();

        assertEquals(expected, actual);
    }

}
