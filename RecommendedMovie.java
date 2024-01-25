public class RecommendMovie extends Movie {
    private String recommendationReason;

    public RecommendMovie(String title, String genre, String recommendationReason) {
        super(title, genre);
        this.recommendationReason = recommendationReason;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Recommendation Reason: " + recommendationReason);
    }
}
