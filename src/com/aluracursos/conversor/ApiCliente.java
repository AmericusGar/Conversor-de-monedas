package com.aluracursos.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;


public class ApiCliente {

        private static final String API_URL = "https://v6.exchangerate-api.com/v6/8bb110999d0475779dd07a8b/latest/USD";
    public static Map<String, String> getMonedas;
    private HttpClient cliente;

    private static final Map<String, String> Monedas = new HashMap<>();

    static {
        Monedas.put("USD", "USA");
        Monedas.put("ARS", "Argentina");
        Monedas.put("BRL", "Brazil");
        Monedas.put("CLP", "Chile");
        Monedas.put("COP", "Colombia");
        Monedas.put("CRC", "Costa Rica");
        Monedas.put("CUP", "Cuba");
        Monedas.put("DOP", "Dominican Republic");
        Monedas.put("GTQ", "Guatemala");
        Monedas.put("HNL", "Honduras");
        Monedas.put("MXN", "Mexico");
        Monedas.put("NIO", "Nicaragua");
        Monedas.put("PAB", "Panama");
        Monedas.put("PEN", "Peru");
        Monedas.put("PYG", "Paraguay");
        Monedas.put("UYU", "Uruguay");
        Monedas.put("VES", "Venezuela");
    }

        public ApiCliente() {
            this.cliente = HttpClient.newHttpClient();
        }

        public Map<String, Double> getConversionRates() throws IOException, InterruptedException {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new IOException("Unexpected code " + response.statusCode());
            }

                String responseData = response.body();
                JsonObject jsonObject = JsonParser.parseString(responseData).getAsJsonObject();
                JsonObject conversionRatesJson = jsonObject.getAsJsonObject("conversion_rates");

                Map<String, Double> conversionRates = new HashMap<>();
                for (String moneda : Monedas.keySet()) {
                    if (conversionRatesJson.has(moneda)){
                        conversionRates.put(moneda, conversionRatesJson.get(moneda).getAsDouble());

                    }
                }

                return conversionRates;
            }

            static Map<String, String> getMonedas(){
                return Monedas;
            }
        }



