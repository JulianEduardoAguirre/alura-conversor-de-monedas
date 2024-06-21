import java.util.Scanner;
import java.util.Set;

public class Menu {

    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private final Converter converter = new Converter();
    private String opcion;

//    private CommonInfo commonInfo;

    public void menu1() {
        imprimirSeparador(40);
        System.out.println("---- Bienvenido al Conversor de Monedas ----");
        System.out.println("Para continuar, por favor ingrese una clave API válida.");
        System.out.println("Presione 'x' para finalizar");
        do{
            opcion = scanner.nextLine();
            converter.validateApiKey(opcion.replaceAll("[^a-zA-Z0-9]", ""));
            if(opcion.equalsIgnoreCase("x")){
                System.out.println("Finalizado programa");
            } else if (!converter.isApiKeyValid()){
                System.out.print("Clave incorrecta. ");
                System.out.println("Ingrese nuevamente una clave API o presiona 'x' para finalizar");
            }


        } while (!opcion.equalsIgnoreCase("x") && !converter.isApiKeyValid());

        System.out.println("y?");
        if (!opcion.equalsIgnoreCase("x")) {
            System.out.println("Clave correcta. Accediendo al menú");
            menuFijos();
        }

        System.out.println("Hasta luego.");
    }
    public void menuFijos() {
        this.imprimirSeparador(40);
        opcion = "";
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        do{
            System.out.println("""                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Conversión personalizada
                8) Salir
                Elija una opción válida:
                """);
            opcion = scanner.nextLine();
            granSwitch(opcion);
        } while (!opcion.equalsIgnoreCase("8"));

        this.imprimirSeparador(40);

    }

    public void menuConversionPersonalizada() {
        this.imprimirSeparador(40);
        opcion = "";
        do{
            System.out.println("""
                Conversión personalizada
                
                1) Nueva conversión
                2) Mostrar códigos válidos
                3) Salir
                
                Elija una opción válida:
                """);
            opcion = scanner.nextLine();
            switchConversorPersonalizada(opcion);
        } while (!opcion.equalsIgnoreCase("3"));
        this.imprimirSeparador(40);

    }

    private void imprimirSeparador(Integer cantidad) {
        for (int i = 0; i < cantidad; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void granSwitch(String opcion) {
        Double amountToConvert;
        switch (opcion) {
            case "1" -> {
                System.out.println("Dólar =>> Peso argentino");
                amountToConvert = AuxFunction.pedirMonto();
                converter.convertFromTo("USD", "ARS", amountToConvert);
            }
            case "2" -> {
                System.out.println("Peso argentino =>> Dólar");
                amountToConvert = AuxFunction.pedirMonto();
                converter.convertFromTo("ARS", "USD", amountToConvert);
            }
            case "3" -> {
                System.out.println("Dólar =>> Real brasileño");
                amountToConvert = AuxFunction.pedirMonto();
                converter.convertFromTo("USD", "BRL", amountToConvert);
            }
            case "4" -> {
                System.out.println("Real brasileño =>> Dólar");
                amountToConvert = AuxFunction.pedirMonto();
                converter.convertFromTo("BRL", "USD", amountToConvert);
            }
            case "5" -> {
                System.out.println("Dólar =>> Peso colombiano");
                amountToConvert = AuxFunction.pedirMonto();
                converter.convertFromTo("USD", "COL", amountToConvert);
            }
            case "6" -> {
                System.out.println("Peso colombiano =>> Dólar");
                amountToConvert = AuxFunction.pedirMonto();
                converter.convertFromTo("COL", "USD", amountToConvert);
            }
            case "7" -> {
                System.out.println("Conversión personalizada");
                menuConversionPersonalizada();
                break;
            }
            case "8" -> System.out.println("Saliendo de la aplicación");
            default -> System.out.println("Debe elegir una opción válida");
        }
    }

    public void switchConversorPersonalizada(String opcion) {
        switch (opcion) {
            case "1" -> customCodes();
            case "2" -> {
                System.out.println("Códigos aceptados");
                converter.showCodes();
            }
            default -> System.out.println("Debe ingresar una opción válida");
        }
    }
    public void customCodes() {
        Set<String> codes = converter.returnCodes();

        String codeFrom = AuxFunction.pedirCodigo(codes);
        String codeTo = AuxFunction.pedirCodigo(codes, codeFrom);
        Double amountToConvert = AuxFunction.pedirMonto();

        converter.convertFromTo(codeFrom, codeTo, amountToConvert);

    }


}
