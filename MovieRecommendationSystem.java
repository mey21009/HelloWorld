import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MovieRecommendationSystem {
    // Data structure to store movie preferences
    private static ArrayList<String> userPreferences = new ArrayList<>();

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Movie Recommendation System!");

        // Get user preferences
        getUserPreferences();

        // Display movie recommendations based on user preferences
        displayRecommendations();

        // Stretch Challenge: Write user preferences to a file
        writeToFile();
    }

    private static void getUserPreferences() {
        Scanner scanner = new Scanner(System.in);

        // Get user preferences (loop for simplicity, you can customize it as needed)
        System.out.println("Enter your movie preferences (type 'exit' to finish):");
        while (true) {
            System.out.print("Preference: ");
            String preference = scanner.nextLine();
            if (preference.equalsIgnoreCase("exit")) {
                break;
            }
            userPreferences.add(preference);
        }
    }

    private static void displayRecommendations() {
        // Display movie recommendations based on user preferences
        System.out.println("Recommended movies for you:");

        // Add your recommendation logic here based on user preferences
        for (String preference : userPreferences) {
            System.out.println("Movie related to " + preference);
            // Add more recommendation logic based on preferences
        }
    }

    private static void writeToFile() {
        try {
            // Create a file named "user_preferences.txt"
            File file = new File("user_preferences.txt");

            // Create FileWriter object
            FileWriter writer = new FileWriter(file);

            // Write user preferences to the file
            for (String preference : userPreferences) {
                writer.write(preference + "\n");
            }

            // Close the FileWriter
            writer.close();

            System.out.println("User preferences written to 'user_preferences.txt'");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

