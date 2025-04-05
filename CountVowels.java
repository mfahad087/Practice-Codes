import java.util.Scanner;
public class CountVowels {
    public static void main(String[] args) {
    Scanner String1= new Scanner(System.in);
    System.out.println("Enter Any String");
    String userString =  String1.nextLine();
    int vowelCount=0;
    String Vowels= "aeiouAEIOU";
    for (int i = 0 ; i < userString.length(); i ++){
        char currentcharacter = userString.charAt(i);
        if (Vowels.indexOf(currentcharacter) !=-1) {
            vowelCount++;
        }
    }
    if (vowelCount==0){
        System.out.println("There Is No Vowel In Your Text");
    }
    else {
        System.out.println("Total Number Of Vowels In Text Your Entered:  " +vowelCount);
    }
    String1.close();
  }
}
