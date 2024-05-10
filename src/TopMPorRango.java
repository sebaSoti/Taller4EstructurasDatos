import edu.princeton.cs.algs4.ST;
import java.util.*;

public class TopMPorRango {
    public static void listarTopMPorRango(List<Review> reviews, Date fechaIni, Date fechaFin, int m) {
        // Obtener las reviews dentro del rango de fechas
        List<Review> reviewsRango = obtenerReviewsPorRango(reviews, fechaIni, fechaFin);

        // Calcular los puntajes totales para las reviews dentro del rango
        ST<String, Integer> puntajesRango = PuntajeTotal.puntajeTotal(reviewsRango);

        // Obtener las claves (ProductId) ordenadas descendentemente por puntaje
        List<String> claves = new ArrayList<>((Collection) puntajesRango.keys());
        claves.sort((a, b) -> puntajesRango.get(b).compareTo(puntajesRango.get(a)));

        System.out.println("Top " + m + " productos por puntaje entre " + fechaIni + " y " + fechaFin + ":");
        for (int i = 0; i < m && i < claves.size(); i++) {
            String productId = claves.get(i);
            int puntaje = puntajesRango.get(productId);
            System.out.println(productId + ": " + puntaje);

            // Obtener la cantidad de reseñas para este producto dentro del rango
            List<Review> reviewsProducto = obtenerReviewsPorProductoYRango(reviews, productId, fechaIni, fechaFin);
            int cantidadReviews = reviewsProducto.size();
            System.out.println("Cantidad de reviews para este producto: " + cantidadReviews);
        }
    }

    private static List<Review> obtenerReviewsPorRango(List<Review> reviews, Date fechaIni, Date fechaFin) {
        List<Review> reviewsRango = new ArrayList<>();
        for (Review review : reviews) {
            Date fecha = review.getDate();
            if (fecha.after(fechaIni) && fecha.before(fechaFin)) {
                reviewsRango.add(review);
            }
        }
        return reviewsRango;
    }

    private static List<Review> obtenerReviewsPorProductoYRango(List<Review> reviews, String productId, Date fechaIni, Date fechaFin) {
        List<Review> reviewsProducto = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getProductId().equals(productId)) {
                Date fecha = review.getDate();
                if (fecha.after(fechaIni) && fecha.before(fechaFin)) {
                    reviewsProducto.add(review);
                }
            }
        }
        return reviewsProducto;
    }
}