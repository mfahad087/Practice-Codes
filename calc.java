import java.util.Scanner;
public class calc{
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your 1ST Number");
        int num1 = scanner.nextInt();
        System.out.println("Enter Your 2ND Number");
        int num2 = scanner.nextInt();
        System.out.println("Choose a character from (+,-,*,/): ");
        char ch = scanner.next().charAt(0);

        double result;
        double result1;
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
                result1 = (float) num1 / num2;
                System.out.println(" result is : " + result1);
                break;
            default:
                System.out.println("invalid operator,choose correct operator from(+,-,/,*");
        }
    }
}
