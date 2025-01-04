
import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        // Solicitar moneda base
        System.out.print("Ingrese la moneda base (ej: USD, EUR, COP): ");
        String monedaBase = lectura.nextLine().toUpperCase();

        // Solicitar moneda de destino
        System.out.print("Ingrese la moneda de destino (ej: USD, EUR, COP): ");
        String monedaDestino = lectura.nextLine().toUpperCase();

        // Pedir el monto a convertir
        System.out.print("Ingrese el monto en " + monedaBase + " a convertir: ");
        double monto = lectura.nextDouble();

        try {
            ConsultaMonedas consulta = new ConsultaMonedas(monedaBase);
            double tasaCambio = consulta.obtenerTasaCambio(monedaDestino);
            double montoConvertido = monto * tasaCambio;
            System.out.printf("El monto en %s es: %.2f %s%n", monedaDestino, montoConvertido, monedaDestino);
        } catch (IOException e) {
            System.out.println("Error al consultar la tasa de cambio: " + e.getMessage());
        } catch (IllegalArgumentException e) { System.out.println("Moneda no válida: " +  e.getMessage());
        } finally {
            lectura.close();
        }
    }
}
