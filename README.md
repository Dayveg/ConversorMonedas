# Conversor de Monedas

Este es un proyecto de ejemplo de un conversor de monedas en Java que utiliza la API de ExchangeRate-API para obtener las tasas de cambio en tiempo real.

## Descripción

El programa permite a los usuarios convertir un monto de una moneda base a una moneda de destino ingresada por el usuario. La tasa de cambio se obtiene en tiempo real a través de una API.

## Características

- Conversión de monedas en tiempo real.
- Manejo de errores en caso de que la moneda no esté disponible.
- Menú interactivo para seleccionar la moneda base y la moneda de destino.
- Uso de la API de ExchangeRate-API para obtener las tasas de cambio.

## Requisitos

- Java 11 o superior
- Maven
- Una clave API de [ExchangeRate-API](https://www.exchangerate-api.com/)

## Instalación

1. Clona este repositorio en tu máquina local:

    ```bash
    git clone https://github.com/tu_usuario/conversor-monedas.git
    cd conversor-monedas
    ```

2. Configura tu clave API en el archivo `ConfiguracionAPI.java`:

    ```java
    public class ConfiguracionAPI {
        private static final String APPKEY = "tu_api_key"; // Reemplaza "tu_api_key" con tu clave API real

        public static String getAPPKEY() {
            return APPKEY;
        }
    }
    ```


## Uso

1. Ejecuta el programa:

    ```bash
    java -cp target/conversor-monedas-1.0-SNAPSHOT.jar com.alura.conversor.Principal
    ```

2. Ingresa la moneda base y la moneda de destino cuando se te solicite.
3. Ingresa el monto que deseas convertir.
4. El programa mostrará el monto convertido en la moneda de destino.

## Ejemplo

```plaintext
Ingrese la moneda base (ej: USD, EUR, COP): USD
Ingrese la moneda de destino (ej: USD, EUR, COP): EUR
Ingrese el monto en USD a convertir: 100
El monto en EUR es: 85.42 EUR
