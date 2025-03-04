import java.util.Scanner;

/**
 * Main class to run the Text Summarizer.
 */
public class SummarizerRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // List of story files
        String[] storyFiles = {
            "Tangled.txt",
            "Cinderella.txt",
            "SnowWhite.txt",
            "LittleRedRidingHood.txt"
        };

        // Display available files to the user
        System.out.println("Available stories:");
        for (int i = 0; i < storyFiles.length; i++) {
            System.out.println((i + 1) + ". " + storyFiles[i]);
        }

        // Prompt the user to choose a file
        System.out.print("Enter the number of the story you want to summarize: ");
        int choice = input.nextInt();
        input.nextLine(); 

        // Validate the user's choice
        if (choice < 1 || choice > storyFiles.length) {
            System.out.println("Invalid choice. Please run the program again and select a valid number.");
            return;
        }

        // Get the selected file
        String selectedFile = storyFiles[choice - 1];
        System.out.println("\nProcessing Story: " + selectedFile);

        // Create an instance of the TextSummarizer for the selected story
        TextSummarizer summarizer = new TextSummarizer(selectedFile);

        // Ask the user how many sentences they want in the summary
        System.out.print("How many sentences do you want in the summary? ");
        int numSentences = input.nextInt();
        input.nextLine(); 

        // Generate and display the summary
        String summary = summarizer.generateSummary(numSentences);
        System.out.println("\nSummary:\n" + summary);
    }
}