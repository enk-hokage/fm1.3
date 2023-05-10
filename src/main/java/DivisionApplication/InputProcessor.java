package DivisionApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputProcessor {
    public int inputDividend() {
        Scanner scanner = new Scanner(System.in);

        int dividend = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter dividend: ");
            try {
                dividend = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Input should be an integer.");
                scanner.next();
            }
        }
        return dividend;
    }

    public int inputDivisor() {
        Scanner scanner = new Scanner(System.in);

        int divisor = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter divisor: ");
            try {
                divisor = scanner.nextInt();
                if (divisor == 0) {
                    System.out.println("Divisor cannot be zero. Please enter a non-zero integer.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input should be an integer.");
                scanner.next();
            }
        }
        return divisor;
    }
}
