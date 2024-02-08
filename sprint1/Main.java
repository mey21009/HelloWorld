import java.util.*;

class Movie {
    private String title;
    private List<String> genres;
    private String rating;
    private List<String> actors;
    private String music;
    private int length;

    public Movie(String title, List<String> genres, String rating, List<String> actors, String music, int length) {
        this.title = title;
        this.genres = genres;
        this.rating = rating;
        this.actors = actors;
        this.music = music;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getRating() {
        return rating;
    }

    public List<String> getActors() {
        return actors;
    }

    public String getMusic() {
        return music;
    }

    public int getLength() {
        return length;
    }
}

class User {
    private List<String> interests;
    private String preferredRating;
    private List<String> preferredActors;
    private String preferredMusic;
    private int preferredLength;

    public User(List<String> interests, String preferredRating, List<String> preferredActors, String preferredMusic, int preferredLength) {
        this.interests = interests;
        this.preferredRating = preferredRating;
        this.preferredActors = preferredActors;
        this.preferredMusic = preferredMusic;
        this.preferredLength = preferredLength;
    }

    public List<String> getInterests() {
        return interests;
    }

    public String getPreferredRating() {
        return preferredRating;
    }

    public List<String> getPreferredActors() {
        return preferredActors;
    }

    public String getPreferredMusic() {
        return preferredMusic;
    }

    public int getPreferredLength() {
        return preferredLength;
    }
}

class MovieRecommendationSystem {
    private List<Movie> movies;

    public MovieRecommendationSystem(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> recommendMovies(User user) {
        List<Movie> recommendedMovies = new ArrayList<>();
        Set<String> userInterests = new HashSet<>(user.getInterests());
        String userRating = user.getPreferredRating();
        Set<String> userActors = new HashSet<>(user.getPreferredActors());
        String userMusic = user.getPreferredMusic();
        int userLength = user.getPreferredLength();
    
        for (Movie movie : movies) {
            Set<String> movieGenres = new HashSet<>(movie.getGenres());
            Set<String> movieActors = new HashSet<>(movie.getActors());
    
            if (userInterests.retainAll(movieGenres) &&
                userRating.equals(movie.getRating()) &&
                userActors.retainAll(movieActors) &&
                userMusic.equals(movie.getMusic()) &&
                userLength == movie.getLength()) {
                recommendedMovies.add(movie);
            }
        }
    
        return recommendedMovies;
    }
    
}

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Shawshank Redemption", Arrays.asList("Drama"), "R", Arrays.asList("Tim Robbins", "Morgan Freeman"), "Thomas Newman", 142));
        movies.add(new Movie("The Godfather", Arrays.asList("Drama", "Crime"), "R", Arrays.asList("Actor1", "Actor2"), "Composer1", 120));
        movies.add(new Movie("Inception", Arrays.asList("Action", "Adventure", "Sci-Fi"), "PG-13", Arrays.asList("Actor3", "Actor4"), "Composer2", 148));
        movies.add(new Movie("Pulp Fiction", Arrays.asList("Crime", "Drama"), "R", Arrays.asList("Actor5", "Actor6"), "Composer3", 154));
        movies.add(new Movie("The Heffalump Movie", Arrays.asList("Animated", "Adventure"), "G", Arrays.asList("Actor7", "Actor8"), "Composer4", 68));
        movies.add(new Movie("Robin Hood", Arrays.asList("Animated", "Adventure"), "G", Arrays.asList("Actor9", "Actor10"), "Composer5", 83));
        movies.add(new Movie("Beauty and the Beast", Arrays.asList("Adventure", "Fantasy"), "G", Arrays.asList("Actor11", "Actor12"), "Composer6", 84));
        movies.add(new Movie("The Hobbit: An Unexpected Journey", Arrays.asList("Adventure", "Fantasy"), "PG-13", Arrays.asList("Actor13", "Actor14"), "Composer7", 169));
        movies.add(new Movie("The Hobbit: The Desolation of Smaug", Arrays.asList("Adventure", "Fantasy"), "PG-13", Arrays.asList("Actor15", "Actor16"), "Composer8", 161));
        movies.add(new Movie("The Hobbit: The Battle of the Five Armies", Arrays.asList("Adventure", "Fantasy"), "PG-13", Arrays.asList("Actor17", "Actor18"), "Composer9", 144));
        movies.add(new Movie("The Count of Monte Cristo", Arrays.asList("Adventure", "Animation"), "PG-13", Arrays.asList("Actor19", "Actor20"), "Composer10", 131));
        movies.add(new Movie("Frequency", Arrays.asList("Crime", "Mystery"), "PG-13", Arrays.asList("Actor21", "Actor22"), "Composer11", 118));
        movies.add(new Movie("Field of Dreams", Arrays.asList("Drama"), "PG", Arrays.asList("Actor23", "Actor24"), "Composer12", 107));
        movies.add(new Movie("Toy Story", Arrays.asList("Animation", "Action", "Comedy"), "G", Arrays.asList("Actor25", "Actor26"), "Composer13", 81));
        movies.add(new Movie("Frozen", Arrays.asList("Animated"), "PG", Arrays.asList("Actor27", "Actor28"), "Composer14", 102));
        movies.add(new Movie("The Incredibles", Arrays.asList("Adventure", "Animation", "Action"), "PG", Arrays.asList("Actor29", "Actor30"), "Composer15", 115));
        movies.add(new Movie("Up", Arrays.asList("Adventure", "Animation", "Action"), "PG", Arrays.asList("Actor31", "Actor32"), "Composer16", 96));
        movies.add(new Movie("Coco", Arrays.asList("Animation","Adventure", "Family"), "PG", Arrays.asList("Actor33", "Actor34"), "Composer17", 105));
        movies.add(new Movie("Moana", Arrays.asList("Animation", "Action", "Comedy", "Musical"), "PG", Arrays.asList("Actor35", "Actor36"), "Composer18", 107));
        movies.add(new Movie("How to Train Your Dragon", Arrays.asList("Adventure", "Animation", "Action"), "PG", Arrays.asList("Actor37", "Actor38"), "Composer19", 98));
        movies.add(new Movie("Zootopia", Arrays.asList("Animation", "Adventure", "Comedy"), "PG", Arrays.asList("Actor39", "Actor40"), "Composer20", 108));

        Scanner scanner = new Scanner(System.in);

        String[] interests = {"Drama", "Crime", "Action", "Adventure", "Sci-Fi", "Animated", "Fantasy", "Mystery", "Comedy", "Musical"};
        System.out.println("Select your interests:");
        for (int i = 0; i < interests.length; i++) {
            System.out.println((i + 1) + ". " + interests[i]);
        }
        String interestsInput = scanner.nextLine();
        List<String> userInterests = Arrays.asList(interestsInput.split("\\s*,\\s*"));
        
        String[] ratings = {"G", "PG", "PG-13", "R"};
        System.out.println("Select your preferred rating:");
        for (int i = 0; i < ratings.length; i++) {
            System.out.println((i + 1) + ". " + ratings[i]);
        }
        String userRating = scanner.nextLine();
        
        System.out.println("Enter your preferred actors (separated by commas):");
        String actorsInput = scanner.nextLine();
        List<String> userActors = Arrays.asList(actorsInput.split("\\s*,\\s*"));
        
        System.out.println("Enter your preferred music:");
        String userMusic = scanner.nextLine();
        
        System.out.println("Enter your preferred length (in minutes):");
        int userLength = scanner.nextInt();
        
        User user = new User(userInterests, userRating, userActors, userMusic, userLength);
        
        MovieRecommendationSystem recommendationSystem = new MovieRecommendationSystem(movies);
        List<Movie> recommendedMovies = recommendationSystem.recommendMovies(user);
        
        if (recommendedMovies.isEmpty()) {
            System.out.println("Sorry, no movies found matching your preferences.");
        } else {
            for (Movie movie : recommendedMovies) {
                System.out.println(movie.getTitle());
            }
        }
    }
}        