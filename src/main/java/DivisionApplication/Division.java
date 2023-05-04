package DivisionApplication;

public class Division {
    protected StringBuilder result = new StringBuilder();
    protected StringBuilder quotient = new StringBuilder();
    protected StringBuilder remainder = new StringBuilder();

    public void startDivision(int dividend, int division){
        Division integerDivision = new Division();

        String result = integerDivision.divide(dividend, division);
        System.out.println(result);
    }

    private String divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }

        if (Math.abs(dividend) < divisor) {
            return dividend + " / " + divisor + " = 0";
        }

        OutputResult outputResult = new OutputResult();

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

        outputResult.modifyResultToView(dividend, divisor, result, quotient);
        return result.toString();
    }

    private String makeDivider(int remainderNumber, int tab) {
        OutputResult outputResult = new OutputResult();
        return outputResult.assemblyString(tab, ' ') + outputResult.assemblyString(calculateDigit(remainderNumber), '-');
    }

    protected int calculateDigit(int i) {
        return (int) Math.log10(i) + 1;
    }
}
