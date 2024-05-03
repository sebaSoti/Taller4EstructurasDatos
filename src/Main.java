import edu.princeton.cs.algs4.ST;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Leer el archivo CSV y obtener la lista de reseñas
        List<Review> reviews = CsvReader.leerCsv("Aqui poner la ruta del archivo");

        // 2. Calcular el puntaje total de cada producto
        ST<String, Integer> puntajes = PuntajeTotal.puntajeTotal(reviews);

        // 3. Listar los Top-10 productos por puntaje
        TopM.listarTopM(reviews, puntajes, 10);

        // Crear los objetos Date a partir de los timestamps de Unix
        Date fechaIni = new Date(1200096000000L);
        Date fechaFin = new Date(1303862400000L);

        // 5. Listar los Top-M productos por puntaje en un rango de fechas
        int m = 5; // Valor de Top M
        TopMPorRango.listarTopMPorRango(reviews, fechaIni, fechaFin, m);

    }
}
