import edu.princeton.cs.algs4.BST;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewsPorFecha {
    public static BST<Date, List<Review>> reviewsPorFecha(List<Review> reviews) {
        BST<Date, List<Review>> arbol = new BST<>();
        for (Review review : reviews) {
            Date fecha = review.getDate();
            if (arbol.contains(fecha)) {
                arbol.get(fecha).add(review);
            } else {
                List<Review> reviewsFecha = new ArrayList<>();
                reviewsFecha.add(review);
                arbol.put(fecha, reviewsFecha);
            }
        }
        return arbol;
    }
}