import java.util.Random;

public class SerieAleatoria {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numeros = new int[500];
        long suma = 0;

        for (int i = 0; i < 500; i++) {
            numeros[i] = random.nextInt(991) + 10; // 10 a 1000
            suma += numeros[i];
        }

        double promedio = (double) suma / 500;

        System.out.println("Suma total: " + suma);
        System.out.println("Promedio:   " + promedio);
    }
}