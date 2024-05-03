import java.util.List;
import edu.princeton.cs.algs4.ST;

public class PuntajeTotal {
    public static ST<String, Integer> puntajeTotal(List<Review> reviews) {
        ST<String, Integer> puntajes = new ST<>();
        for (Review review : reviews) {
            String productId = review.getProductId();
            int score = review.getScore();
            if (puntajes.contains(productId)) {
                puntajes.put(productId, puntajes.get(productId) + score);
            } else {
                puntajes.put(productId, score);
            }
        }
        return puntajes;
    }
}