# Conversor de Monedas

Este proyecto es un conversor de monedas basado en Java que permite a los usuarios convertir entre varias monedas de Latinoamérica. Utiliza una API de tasas de cambio para obtener las tasas de conversión en tiempo real.

## Características

- Conversión de monedas entre varias monedas latinoamericanas.
- Interfaz de línea de comandos para una fácil interacción.
- Uso de una API para obtener tasas de conversión actualizadas.
- Manejo de errores para entradas inválidas.

## Monedas Soportadas

El conversor soporta las siguientes monedas:

- ARS (Peso Argentino) - Argentina
- BRL (Real Brasileño) - Brasil
- CLP (Peso Chileno) - Chile
- COP (Peso Colombiano) - Colombia
- CRC (Colón Costarricense) - Costa Rica
- CUP (Peso Cubano) - Cuba
- DOP (Peso Dominicano) - República Dominicana
- GTQ (Quetzal Guatemalteco) - Guatemala
- HNL (Lempira Hondureña) - Honduras
- MXN (Peso Mexicano) - México
- NIO (Córdoba Nicaragüense) - Nicaragua
- PAB (Balboa Panameño) - Panamá
- PEN (Sol Peruano) - Perú
- PYG (Guaraní Paraguayo) - Paraguay
- USD (Dolar) - USA
- UYU (Peso Uruguayo) - Uruguay
- VES (Bolívar Venezolano) - Venezuela

## Requisitos

- Java 8 o superior
- Librería Gson
- Una cuenta en [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener una clave de API.

## Configuración del Proyecto

1. Clona el repositorio en tu máquina local:
    git clone https://github.com/tu-usuario/nombre-del-repositorio.git
    cd nombre-del-repositorio

2. Agrega la librería Gson a tu proyecto. Descarga el archivo `gson-2.8.6.jar` y colócalo en el directorio `libs`.

3. Agrega el archivo JAR de Gson al classpath de tu proyecto. Si estás usando un IDE como IntelliJ IDEA o Eclipse, puedes hacer esto a través de la configuración del proyecto.

## Uso

1. Abre una terminal en el directorio raíz del proyecto.

2. Compila las clases de Java:
    ```
    javac -cp ".;libs/gson-2.8.6.jar" -d bin src/com/aluracursos/conversor/*.java
    ```

3. Ejecuta el programa:
    ```sh
    java -cp ".;libs/gson-2.8.6.jar;bin" com.aluracursos.conversor.Usuario
    ```

4. Sigue las instrucciones en la terminal para seleccionar las monedas y realizar conversiones.
5. 
   <img width="300" alt="image" src="https://github.com/AmericusGar/Conversor-de-monedas/assets/85145783/b801d18d-5679-4545-9c94-b604066d5994">

6. Video de ejemplo
   [![Video de ejemplo](https://img.youtube.com/vi/ID_DEL_VIDEO/hqdefault.jpg)(https://youtu.be/XHYztUKjvBc?si=Ha_vDfATBHkvW5VO)

   

## Estructura del Proyecto

```plaintext
conversor-monedas/
├── src/
│   └── com/aluracursos/conversor/
│       ├── ApiCliente.java
│       ├── ConversorMoneda.java
│       └── Moneda.java
│       └── Usuario.java
├── libs/
│   └── gson-2.8.6.jar
├── bin/
│   └── (archivos compilados)
└── README.md


