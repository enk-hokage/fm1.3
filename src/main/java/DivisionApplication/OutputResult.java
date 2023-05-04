package DivisionApplication;

public class OutputResult {

    protected void modifyResultToView(int dividend, int divisor, StringBuilder result, StringBuilder quotient) {
        Division division = new Division();
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

        int tab = division.calculateDigit(dividend) + 1 - index[0];
        result.insert(index[2], assemblyString(tab-1, ' ') + "│" + quotient.toString());
        result.insert(index[1], assemblyString(tab, ' ') + "│" + assemblyString(quotient.length(), '-'));
        result.insert(index[0], "│" + divisor);
        result.replace(1, index[0], dividend + "");
    }

    protected String assemblyString(int numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }

}
