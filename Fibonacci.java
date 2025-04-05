import java.util.Scanner;

public class Fibonacci {
 //
    static int fibonacci(int n)
    {
        if (n==0)  return 0; 
        if (n==1)  return 1;
        return fibonacci (n-1 ) + fibonacci(n-2);
    }

    public static void main( String [] args ){
        Scanner term= new Scanner(System.in);
        System.out.println("Enter Number Of Terms :");
        int n = term.nextInt();

        System.out.println("FIBONACCI SERIES :");
        for(int i = 0; i<n ; i++){
            System.out.print(fibonacci(i) + " , ");
        } 
        System.out.print(".....");
    term.close();
    }
}
