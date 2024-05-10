import edu.princeton.cs.algs4.ST;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TopM {
    public static void listarTopM(List<Review> reviews, ST<String, Integer> puntajes, int m) {
        List<String> claves = new ArrayList<>((Collection) puntajes.keys());
        claves.sort((a, b) -> puntajes.get(b).compareTo(puntajes.get(a)));

        System.out.println("Primeros 10 elementos de la lista ordenada:");
        System.out.println("ID del producto:    Puntaje:");
        for (int i = 0; i < 10 && i < claves.size(); i++) {
            String clave = claves.get(i);
            int puntaje = puntajes.get(clave);
            System.out.println(clave + ":         " + puntaje);
        }

        System.out.println("Top " + m + " productos por puntaje:");
        for (int i = 0; i < m && i < claves.size(); i++) {
            String productId = claves.get(i);
            int puntaje = puntajes.get(productId);
            System.out.println(productId + ": " + puntaje);

            // Obtener la cantidad de reseñas para este producto
            List<Review> reviewsProducto = obtenerReviewsPorProducto(reviews, productId);
            int cantidadReviews = reviewsProducto.size();
            System.out.println("Cantidad de reviews para este producto: " + cantidadReviews);
        }

    }

    private static List<Review> obtenerReviewsPorProducto(List<Review> reviews, String productId) {
        List<Review> reviewsProducto = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getProductId().equals(productId)) {
                reviewsProducto.add(review);
            }
        }
        return reviewsProducto;
    }
}