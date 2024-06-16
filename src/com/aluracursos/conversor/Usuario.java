package com.aluracursos.conversor;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Usuario {

        private Map<String, Double> conversionRates;
        private Map<String, String> Monedas;

        public Usuario(Map<String, Double> conversionRates, Map<String, String> Monedas) {
            this.conversionRates = conversionRates;
            this.Monedas = Monedas;
        }

        public void start() {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("*****************************************");
                System.out.println("Conversor de Monedas");
                System.out.println("*****************************************");
                System.out.println("Monedas disponibles: ");
                for (Map.Entry<String, String> entry : Monedas.entrySet()){
                    if (conversionRates.containsKey(entry.getKey())){
                        System.out.println(entry.getKey() + " - " + entry.getValue());
                    }
                }
                System.out.print("Ingresa la moneda que desea convertir ");
                String fromCurrency = scanner.nextLine().toUpperCase();

                    System.out.print("Ingresa la moneda destino ");
                String toCurrency = scanner.nextLine().toUpperCase();

                System.out.print("Ingresa el monto: ");
                String amountText = scanner.nextLine();

                if (fromCurrency.equalsIgnoreCase("exit") || toCurrency.equalsIgnoreCase("exit")) {
                    System.out.println("Saliendo del programa.");
                    break;
                }

                try {
                    double amount = Double.parseDouble(amountText);
                    ConversorMoneda converter = new ConversorMoneda(conversionRates);
                    double result = converter.convert(fromCurrency, toCurrency, amount);
                    System.out.println(amount + " " + fromCurrency + " is " + result + " " + toCurrency);
                } catch (NumberFormatException ex) {
                    System.out.println("Por favor ingrese un número válido para el monto.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }

                System.out.println("Escriba 'Exit'  o presione Enter para continuar.");
                String exitChoice = scanner.nextLine();
                if (exitChoice.equalsIgnoreCase("Exit")) {
                    System.out.println("Saliendo del programa");
                    break;
                }
            }

            scanner.close();
        }

        public static void main(String[] args) {
            // Load conversion rates
            ApiCliente apiClient = new ApiCliente();
            try {
                Map<String, Double> conversionRates = apiClient.getConversionRates();
                Map<String, String> Monedas = ApiCliente.getMonedas();
                Usuario cli = new Usuario(conversionRates, Monedas);
                cli.start();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                System.out.println("No se pudieron recuperar las tasas de conversión.");
            }
        }
    }

