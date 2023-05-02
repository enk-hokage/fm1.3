import java.util.Scanner;

public class InputProcessor {
    public int[] input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dividend: ");
        int dividend = scanner.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();

        int[] result = {dividend, divisor};
        return result;
    }
}
