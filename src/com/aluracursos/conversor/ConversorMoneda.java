package com.aluracursos.conversor;
import java.util.Map;

public class ConversorMoneda {

            private Map<String, Double> conversionRates;

            public ConversorMoneda(Map<String, Double> conversionRates) {
                this.conversionRates = conversionRates;
            }

            public double convert(String fromCurrency, String toCurrency, double amount) {
                if (conversionRates.containsKey(fromCurrency) && conversionRates.containsKey(toCurrency)) {
                    double rate = conversionRates.get(toCurrency) / conversionRates.get(fromCurrency);
                    return amount * rate;
                } else {
                    throw new IllegalArgumentException("Moneda no admitida");
                }
            }
        }



