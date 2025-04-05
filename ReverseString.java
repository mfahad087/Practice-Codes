import java.util.Scanner;
public class ReverseString {
    public static void main(String [] args) {
        Scanner userString= new Scanner(System.in);
        System.out.println("Enter Your String You Want Reverse Of:");
        String string1 = userString.nextLine();
        System.out.println("YOUR ORIGNAL STRING IS :" +string1);
        String Reversed="";
        for (int i= string1.length()-1; i>=0 ; i--){
            Reversed += string1.charAt(i);
        }
        System.out.println("REVERSE OF YOUR STRING IS :"+ Reversed);
        userString.close();
    }
}
