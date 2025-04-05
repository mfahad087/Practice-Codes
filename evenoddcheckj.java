import java.util.Scanner;
 class evenoddcheck {
	public static void main (String [] args ) {
	Scanner Num= new Scanner (System.in);
	System.out.print("Enter Your Number:");
    int number=Num.nextInt();
	if (number % 2 == 0) {
		System.out.println("Number is Even Number");	
	}
	else {
		System.out.println("Number is Odd ");	
	}
    Num.close();
   }
}
