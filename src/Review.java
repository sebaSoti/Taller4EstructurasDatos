import java.util.Date;

public class Review {
    private final int reviewId;
    private final String productId;
    private final String userId;
    private final String profileName;
    private final int helpfulnessNumerator;
    private final int helpfulnessDenominator;
    private final int score;
    private final long unixTime;
    private final String summary;
    private final String text;

    public Review(int reviewId, String productId, String userId, String profileName,
                  int helpfulnessNumerator, int helpfulnessDenominator, int score,
                  long unixTime, String summary, String text) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.userId = userId;
        this.profileName = profileName;
        this.helpfulnessNumerator = helpfulnessNumerator;
        this.helpfulnessDenominator = helpfulnessDenominator;
        this.score = score;
        this.unixTime = unixTime;
        this.summary = summary;
        this.text = text;
    }

    public Date getDate() {
        return new Date(unixTime * 1000L);
    }
    @Override
    public String toString() {
        String summaryCortado = summary.length() > 30 ? summary.substring(0, 30) + "..." : summary;
        String textCortado = text.length() > 30 ? text.substring(0, 30) + "..." : text;
        return "ReviewId: " + reviewId + ", ProductId: " + productId + ", UserId: " + userId +
                ", ProfileName: " + profileName + ", HelpfulnessNumerator: " + helpfulnessNumerator +
                ", HelpfulnessDenominator: " + helpfulnessDenominator + ", Score: " + score +
                ", Date: " + getDate() + ", Summary: " + summaryCortado + ", Text: " + textCortado;
    }
    public String getProductId() {
        return productId;
    }
    public int getScore() {
        return score;
    }

}