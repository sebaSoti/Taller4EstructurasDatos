import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static List<Review> leerCsv(String ruta) {
        List<Review> reviews = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                Review review = getReview(linea);
                reviews.add(review);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    public static Review getReview(String linea) {
        String[] campos = linea.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

        int reviewId = Integer.parseInt(campos[0]);
        String productId = campos[1];
        String userId = campos[2]; // Cambio: userId es String
        String profileName = campos[3];
        int helpfulnessNumerator = Integer.parseInt(campos[4]);
        int helpfulnessDenominator = Integer.parseInt(campos[5]);
        int score = Integer.parseInt(campos[6]);
        long unixTime = Long.parseLong(campos[7]);
        String summary = campos[8];
        String text = campos[9];

        return new Review(reviewId, productId, userId, profileName,helpfulnessNumerator, helpfulnessDenominator,
                score, unixTime, summary, text);
    }
}
