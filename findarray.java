import java.util.Scanner;

public class findarray {
    public static void main(String[] args) {
        Scanner find = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("Enter a number to find in the array: ");
        int number = find.nextInt();
        boolean found = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("The number " + number + " is in the array.");
        } else {
            System.out.println("The number " + number + " is NOT in the array.");
        }

        find.close();
    }
}

