package DivisionApplication;

public class OutputResult {

    protected StringBuilder result = new StringBuilder();
    protected StringBuilder quotient = new StringBuilder();
    protected StringBuilder remainder = new StringBuilder();

    protected String formattingDivisionToOutput(int dividend, int divisor){
        if (divisor == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        if (Math.abs(dividend) < divisor) {
            System.out.println(dividend + " / " + divisor + " = 0");
            System.exit(0);
        }

        String[] digits = String.valueOf(dividend).split("");
        int remainderNumber;
        int multiplyResult;
        int divisorDigit = calculateDigit(divisor);
        int mod;

        for (int i = 0; i < digits.length; i++) {
            remainder.append(digits[i]);
            remainderNumber = Integer.parseInt(remainder.toString());

            if (remainderNumber >= divisor) {
                mod = remainderNumber % divisor;
                multiplyResult = remainderNumber / divisor * divisor;

                String lastRemainder = String.format("%" + (i + 2) + "s", "_" + remainderNumber);
                result.append(lastRemainder).append("\n");

                String multiply = String.format("%" + (i + 2) + "d", multiplyResult);
                result.append(multiply).append("\n");

                int tab = lastRemainder.length() - calculateDigit(multiplyResult);
                result.append(makeDivider(remainderNumber, tab)).append("\n");

                quotient.append(remainderNumber / divisor);

                remainder.replace(0, remainder.length(), mod + "");
                remainderNumber = Integer.parseInt(remainder.toString());
            } else {
                if (i >= divisorDigit) {
                    quotient.append(0);
                }
            }

            if (i == digits.length - 1) {
                result.append(String.format("%" + (i + 2) + "s", remainderNumber)).append("\n");
            }
        }

        modifyResultToView(dividend, divisor, result, quotient);
        return result.toString();
    }

    private void modifyResultToView(int dividend, int divisor, StringBuilder result, StringBuilder quotient) {
        int[] index = new int[3];
        for (int i = 0, j = 0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }

            if (j == 3) {
                break;
            }
        }

        int tab = calculateDigit(dividend) + 1 - index[0];
        result.insert(index[2], assemblyString(tab-1, ' ') + "│" + quotient.toString());
        result.insert(index[1], assemblyString(tab, ' ') + "│" + assemblyString(quotient.length(), '-'));
        result.insert(index[0], "│" + divisor);
        result.replace(1, index[0], dividend + "");
    }

    private String assemblyString(int numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }

    private String makeDivider(int remainderNumber, int tab) {
        OutputResult outputResult = new OutputResult();
        return outputResult.assemblyString(tab, ' ') + outputResult.assemblyString(calculateDigit(remainderNumber), '-');
    }

    private int calculateDigit(int i) {
        return (int) Math.log10(i) + 1;
    }

}
