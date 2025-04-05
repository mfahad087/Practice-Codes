import java.util.Scanner;
public class sum {
  public static void main(String [] args){
	  Scanner num = new Scanner(System.in);
	  
	  System.out.println("Enter 1st Number:");
	  int num1=num.nextInt();
	  
	  System.out.println("Enter 2nd Number:");
	  int num2=num.nextInt();
	  
	  int sum= num1 +  num2;
	  
	  System.out.println("The Sum Of Numbers You Entered is :"+sum);
	  num.close();  
  }
}
