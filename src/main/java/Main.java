import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dividend: ");
        int dividend = scanner.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();

        IntegerDivision division = new IntegerDivision();
        String result = division.divide(dividend, divisor);
        System.out.println(result);
    }
}
