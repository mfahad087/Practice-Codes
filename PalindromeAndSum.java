import java.util.Scanner;

public class PalindromeAndSum {
        public static void main(String[] args) {
        Scanner usernum = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = usernum.nextInt();
        int originalNum = num ;

int reverse = 0;
while (num != 0) {
    int digit = num % 10;           // suppose num= 123 & 123%10 = 3  (store in digit)
reverse = reverse * 10 + digit;     // now 0*3+3 = 3
  num /= 10;                        // 123/10 = 12, loop again run but this this num= 12%10..
        }

     // Palindrome result
 if (originalNum == reverse) {
System.out.println(originalNum + " is a Palindrome Number.");
     } else {
     System.out.println(originalNum + " is NOT a Palindrome Number.");
        }
   usernum.close(); 
    }
}
