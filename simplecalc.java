 import java.util.Scanner;

public class simplecalc{
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your 1ST Number");
        int num1 = scanner.nextInt();
        System.out.println("Enter Your 1ST Number");
        int num2 = scanner.nextInt();
        System.out.println("Choose a character from (+,-,*,/): ");
        char ch = scanner.next().charAt(0);

        double result;
        switch (ch) {
            case '+':
                result = num1 + num2;
                System.out.println(" result is : " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println(" result is : " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println(" result is : " + result);
                break;

            case '/':
                result = num1 / num2;
                System.out.println(" result is : " + result);
                break;
            default:
                System.out.println("invalid operator,choose correct operator from(+,-,/,*");
        }
    }
}