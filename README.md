# ONE - Challenge 01 - Conversor de monedas
Implementación de un programa para la conversión entre monedas  en base al valor actual del tipo de cambio. 
La información se consulta en __https://www.exchangerate-api.com/__.

## Tecnologías Utilizadas
- Java

## Configuración
De momento, el programa se debe ejecutar en CLI o en una terminal dentro del IDE elegido por el usuario. El desarrollo del mismo se realizó con IntelliJ IDEA.

## Requisitos
- JDK 17
- IDE (IntelliJ IDEA recomendado)
- Gson (Librería para el manejo de la información remitida desde la API)
- Clave API personal (se genera en la página: __https://www.exchangerate-api.com/__)

## Instrucciones

1. Clonar o descargar el repositorio y abrirlo en IntelliJ IDEA.
2. Descargar Gson.jar y agregarla al proyecto.
3. Generar una clave API en la página. Sin esta, no se podrá avanzar al menú principal.

## Uso
Al inicio de la ejecución, se deberá ingresar la clave API generada en la página del exchange. En caso de querer finalizar la ejecución, tipear 'x' y presionar Enter.
Una vez ingresada una clave válida, se mostrará el menú principal:

                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Conversión personalizada
                8) Mostrar historial de transacciones
                9) Salir
                
                Elija una opción válida:

- Las opciones 1 a 6 permiten la conversión entre las monedas indicadas. En todos los casos, se solicitará el monto a convertir.
- Mediante la opción 7, se accederá al siguiente submenú:

                Conversión personalizada
                
                1) Nueva conversión
                2) Mostrar códigos válidos
                3) Salir

    - Eligiendo la opción 1, se solicitarán los códigos de las monedas deseadas y el monto a convertir.
    - Con la opción 2, se listarán todas las monedas y sus códigos correspondientes, soportados por la API

- Mediante la opción 8 del menú principal, se mostrará el listado de consultas/transacciones realizadas por el usuario.
