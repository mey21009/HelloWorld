import java.util.*;

class Movie {
    private String title;
    private List<String> genres;

    public Movie(String title, List<String> genres) {
        this.title = title;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }
}

class User {
    private List<String> interests;

    public User(List<String> interests) {
        this.interests = interests;
    }

    public List<String> getInterests() {
        return interests;
    }
}

class MovieRecommendationSystem {
    private List<Movie> movies;

    public MovieRecommendationSystem(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> recommendMovies(User user) {
        List<Movie> recommendedMovies = new ArrayList<>();

        // Collect user interests
        Set<String> userInterests = new HashSet<>(user.getInterests());

        // Find movies that match user interests
        for (Movie movie : movies) {
            if (Collections.disjoint(userInterests, movie.getGenres())) {
                continue; // Skip if the movie's genres don't match user interests
            }
            recommendedMovies.add(movie);
        }

        return recommendedMovies;
    }
}

public class Main {
    public static void main(String[] args) {
        // Sample movies
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Shawshank Redemption", Arrays.asList("Drama")));
        movies.add(new Movie("The Godfather", Arrays.asList("Drama", "Crime")));
        movies.add(new Movie("Inception", Arrays.asList("Action", "Adventure", "Sci-Fi")));
        movies.add(new Movie("Pulp Fiction", Arrays.asList("Crime", "Drama")));
        movies.add(new Movie("The Heffalump Movie", Arrays.asList("Animated", "Adventure")));
        movies.add(new Movie("Robin Hood ", Arrays.asList("Animated", "Adventure")));
        movies.add(new Movie("Beauty and the Beast", Arrays.asList("Adventure", "Fantasy")));
        movies.add(new Movie("The Hobbit: An Unexpected Journey", Arrays.asList("Adventure", "Fantasy")));
        movies.add(new Movie("The Hobbit: The Desolation of Smaug", Arrays.asList("Adventure", "Fantasy")));
        movies.add(new Movie("The Hobbit: The Battle of the Five Armies", Arrays.asList("Adventure", "Fantasy")));
        movies.add(new Movie("The Count of Monte Cristo ", Arrays.asList("Adventure", "Animation")));
        movies.add(new Movie("Frequency", Arrays.asList("Crime", "Mystery")));
        movies.add(new Movie("Field of Dreams", Arrays.asList("Drama")));
        movies.add(new Movie("Toy Story", Arrays.asList("Animation", "Action", "Comedy")));
        movies.add(new Movie("Frozen", Arrays.asList("Animation", "Action", "Comedy", "Musical" )));
        movies.add(new Movie("The Incredibles", Arrays.asList("Adventure", "Animation", "Action" )));
        movies.add(new Movie("Up", Arrays.asList("Adventure", "Animation", "Action" )));
        movies.add(new Movie("Coco", Arrays.asList("Animation","Adventure", "Family")));
        movies.add(new Movie("Moana", Arrays.asList("Animation", "Action", "Comedy", "Musical" )));
        movies.add(new Movie("How to Train Your Dragon", Arrays.asList("Adventure", "Animation", "Action" )));
        movies.add(new Movie("Zootopia", Arrays.asList("Animation”, “Adventure” ,“Comedy")));


        try (// Prompt user to input interests
        Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your interests (separated by commas):");
            String input = scanner.nextLine();
            List<String> interests = Arrays.asList(input.split("\\s*,\\s*"));

            // Create user object with interests
            User user = new User(interests);

            // Create recommendation system and get recommended movies
            MovieRecommendationSystem recommendationSystem = new MovieRecommendationSystem(movies);
            List<Movie> recommendedMovies = recommendationSystem.recommendMovies(user);

            // Display recommended movies
            if (recommendedMovies.isEmpty()) {
                System.out.println("Sorry, no movies found matching your interests.");
            } else {
                System.out.println("Recommended movies:");
                for (Movie movie : recommendedMovies) {
                    System.out.println(movie.getTitle());
                }
            }
        }
    }
}
