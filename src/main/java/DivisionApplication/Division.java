package DivisionApplication;

import DivisionApplication.InputProcessor;

import java.util.Scanner;

public class Division {
    private StringBuilder result = new StringBuilder();
    private StringBuilder quotient = new StringBuilder();
    private StringBuilder remainder = new StringBuilder();

    public void startDivision(){
        InputProcessor inputProcessor = new InputProcessor();
        Division integerDivision = new Division();

        String result = integerDivision.divide(inputProcessor.inputDividend(), inputProcessor.inputDivisor());
        System.out.println(result);
    }

    private String divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend < divisor) {
            return dividend + " / " + divisor + " = 0";
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

        modifyResultToView(dividend, divisor);
        return result.toString();
    }

    private String makeDivider(int remainderNumber, int tab) {
        return assemblyString(tab, ' ') + assemblyString(calculateDigit(remainderNumber), '-');
    }

    private void modifyResultToView(int dividend, int divisor) {
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
        result.insert(index[2], assemblyString(tab, ' ') + "│" + quotient.toString());
        result.insert(index[1], assemblyString(tab, ' ') + "│" + assemblyString(quotient.length(), '-'));
        result.insert(index[0], "│" + divisor);
        result.replace(1, index[0], dividend + "");
    }

    private int calculateDigit(int i) {
        return (int) Math.log10(i) + 1;
    }

    private String assemblyString(int numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }
}
