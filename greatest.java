import java.util.Scanner;

    class greatest {
    public static void main(String [] args){
    Scanner num= new Scanner(System.in);
   // Scannner obj = new Scanner(System.in);
    System.out.println("Enter Any Three Number:");
    
    int num1=num.nextInt();
    int num2=num.nextInt();  
    int num3=num.nextInt();
  //  float num4=obj.nextFloat();
    //int num4=obj.nextFloat()

    if (num1>num2 && num1>num3){
    System.out.println(num1 + " Is Greator number"); 
    }
    else if(num2>num1 && num2 > num3){
    System.out.println(num2+" Is Greator Number");
     }
    else {
    System.out.println(num3 +" Is Greator Number ");
     }
    num.close();
    }
}
