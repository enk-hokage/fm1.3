package DivisionApplication;

public class DivisionApp {

    public static void main(String[] args) {
        InputProcessor inputProcessor = new InputProcessor();

        OutputResult outputResult = new OutputResult();
        System.out.println(outputResult.formattingDivisionToOutput(inputProcessor.inputDividend(), inputProcessor.inputDivisor()));
    }
}
