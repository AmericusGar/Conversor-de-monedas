package com.aluracursos.conversor;

public class Moneda {


        private String code;
        private double rate;

        public Moneda(String code, double rate) {
            this.code = code;
            this.rate = rate;
        }

        public String getCode() {
            return code;
        }

        public double getRate() {
            return rate;
        }
    }


