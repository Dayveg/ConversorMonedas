import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConsultaMonedas {
    private static final String APPKEY = ConfiguracionAPI.getAPPKEY();
    private JsonObject conversionRates;

    public ConsultaMonedas(String moneda) throws IOException {
        // Configurando URL
        String url_str = "https://v6.exchangerate-api.com/v6/" + APPKEY + "/latest/" + moneda;

        try {
            // Realizando la solicitud
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convertir a JSON
            Gson gson = new Gson(); // Crea una instancia de Gson para parsear JSON
            JsonObject jsonobj = gson.fromJson(new InputStreamReader((InputStream) request.getContent()), JsonObject.class);

            // Verificar el resultado de la solicitud
            String req_result = jsonobj.get("result").getAsString();
            if (req_result.equals("success")) {
                System.out.println("Resultado de la consulta: " + req_result);
                this.conversionRates = jsonobj.getAsJsonObject("conversion_rates");
            } else {
                System.out.println("Error en la consulta: " + req_result);
                throw new IOException("Error en la consulta: " + req_result);
            }

        } catch (MalformedURLException e) {
            System.out.println("URL malformada: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }

    public double obtenerTasaCambio(String monedaDestino) {
        if (this.conversionRates != null && this.conversionRates.has(monedaDestino)) {
            return this.conversionRates.get(monedaDestino).getAsDouble();
        } else {
            throw new IllegalArgumentException("Moneda de destino no válida o no encontrada");
        }
    }
}
