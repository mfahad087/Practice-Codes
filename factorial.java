import java.util.Scanner;
 
public class factorial{
public static void main(String [] args ){
Scanner Num = new Scanner(System.in);
System.out.println("Enter The Number You Want Factorial Of:");

int number = Num.nextInt();

int factorial=1; 
for (int i=1; i<= number; i++)
{
    factorial*=i;}

System.out.println("Factorial Of " +number+ " is : " + factorial);
Num.close();
  }
}  