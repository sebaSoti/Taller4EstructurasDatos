/*
Daniela Gerena Lopera
Gregorio Carvajal Gaviria
Sebastián Soto Ángel
 */
import edu.princeton.cs.algs4.ST;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Leer el archivo CSV y obtener la lista de reseñas
        //Aca se coloca la ruta del archivo, en nuestro caso "src/Reviews-Part-aa"
        List<Review> reviews = CsvReader.leerCsv("src/Reviews-Part-aa");

        //Calcular el puntaje total de cada producto
        ST<String, Integer> puntajes = PuntajeTotal.puntajeTotal(reviews);

        //Listar los Top-10 productos por puntaje
        TopM.listarTopM(reviews, puntajes, 10);

        // Crear los objetos Date a partir de los timestamps de Unix
        Date fechaIni = new Date(1200096000000L);
        Date fechaFin = new Date(1303862400000L);

        //Listar los Top-M productos por puntaje en un rango de fechas
        int m = 5; // Valor de Top M
        TopMPorRango.listarTopMPorRango(reviews, fechaIni, fechaFin, m);

        //Para imprimir las reseñas con el toString
        //for (Review review : reviews) {
            //System.out.println(review.toString());
        //}

    }
}
