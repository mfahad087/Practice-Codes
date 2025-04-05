import java.util.Scanner;
public class userinputarrayavg{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int size = input.nextInt();

        double[] values = new double[size];
        double sum = 0;

        for (int i = 0; i < size; i++){
            System.out.print("Enter element " + (i + 1) + ": ");
            values[i] = input.nextDouble();
            sum += values[i];
        }
        System.out.println("The Sum Of All Elements In ARRAY is: " + sum);
        System.out.println("The Average Of All Elements In ARRAY is: " + sum / size);
        input.close();
    }
}

