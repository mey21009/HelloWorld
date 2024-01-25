import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Movie {
    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
    }

    public String getTitle() {
        return title;
    }
}

public class RecommendedMovie extends Movie {
    private String recommendationReason;

    public RecommendedMovie(String title, String genre, String recommendationReason) {
        super(title, genre);
        this.recommendationReason = recommendationReason;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Recommendation Reason: " + recommendationReason);
    }

    public String getRecommendationReason() {
        return recommendationReason;
    }
}

public class MovieRecommendationSystem implements FileWritable {
    private static ArrayList<Movie> movieList = new ArrayList<>();
    private static ArrayList<String> userPreferences = new ArrayList<>();

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Movie Recommendation System!");

        // Create a list of movies
        createMovieList();

        // Get user preferences
        getUserPreferences();

        // Display movie recommendations based on user preferences
        displayRecommendations();

        // Stretch Challenge: Write user preferences to a file
        writeToFile();
    }

    private static void createMovieList() {
        // Add some movies to the list
        movieList.add(new Movie("Movie1", "Action"));
        movieList.add(new Movie("Movie2", "Comedy"));
        movieList.add(new Movie("Hotel Transylvania", "Drama"));
        // Add more movies as needed
    }

    private static void displayRecommendations() {
        // Display movie recommendations based on user preferences
        System.out.println("Recommended movies for you:");

        // Add your recommendation logic here based on user preferences and movieList
        for (String preference : userPreferences) {
            for (Movie movie : movieList) {
                if (movie.getGenre().equalsIgnoreCase(preference)) {
                    RecommendedMovie recommendedMovie = new RecommendedMovie(
                            movie.getTitle(),
                            movie.getGenre(),
                            "You might like this based on your preference."
                    );
                    recommendedMovie.displayDetails();
                    break; // Only recommend one movie per preference for simplicity
                }
            }
        }
    }


}
