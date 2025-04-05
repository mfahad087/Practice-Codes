import java.util.Scanner;
import java.util.Random;

public class TypingSpeedTest {
    public static void main(String[] args) {
        String[] paragraphs = {"TYPING SPEED matters too much in this digital world"};

        Random random = new Random();
        String testParagraph = paragraphs[random.nextInt(paragraphs.length)];

        System.out.println("Type the following paragraph as quickly and accurately as you can:\n");
        System.out.println(testParagraph);
        System.out.println("\nPress 'Enter' when you are ready to start typing...");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        long startTime = System.currentTimeMillis();

        System.out.println("\nStart typing below:");
        String userTyped = scanner.nextLine();

        Long endTime = System.currentTimeMillis();
        double timeTakenInSeconds = (endTime - startTime) / 1000.0;

        int wordCount = userTyped.split("\\s+").length;
        double wpm = (wordCount / timeTakenInSeconds) * 60;

        System.out.println("\nTyping Speed Test Results:");
        System.out.println("Time Taken: " + timeTakenInSeconds + " seconds");
        System.out.println("Words Typed: " + wordCount);
        System.out.printf("Typing Speed: %.2f WPM\n", wpm);

        
        scanner.close();
    }
}
