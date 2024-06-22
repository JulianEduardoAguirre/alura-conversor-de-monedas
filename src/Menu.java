import java.util.Scanner;
import java.util.Set;

public class Menu {

    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private final Converter converter = new Converter();
    private String option;

//    private CommonInfo commonInfo;

    public void principalMenu() {
        printDivider(40);
        System.out.println("---- Bienvenido al Conversor de Monedas ----");
        System.out.println("Para continuar, por favor ingrese una clave API válida.");
        System.out.println("https://www.exchangerate-api.com/");
        System.out.println("Presione 'x' para finalizar");
        do{
            option = scanner.nextLine();
            converter.validateApiKey(option.replaceAll("[^a-zA-Z0-9]", ""));
            if(option.equalsIgnoreCase("x")){
                System.out.println("Finalizado programa");
            } else if (!converter.isApiKeyValid()){
                System.out.print("Clave incorrecta. ");
                System.out.println("Ingrese nuevamente una clave API o genere una en https://www.exchangerate-api.com/");
                System.out.println("presiona 'x' para finalizar\"");
            }


        } while (!option.equalsIgnoreCase("x") && !converter.isApiKeyValid());

        if (!option.equalsIgnoreCase("x")) {
            System.out.println("Clave correcta. Accediendo al menú");
            innerMenu();
        }

        System.out.println("Hasta luego.");
    }

    public void innerMenu() {
        this.printDivider(40);
        option = "";
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
            option = scanner.nextLine();
            innerMenuSwitch(option);
        } while (!option.equalsIgnoreCase("8"));

        this.printDivider(40);

    }

    public void customConversionMenu() {
        this.printDivider(40);
        option = "";
        do{
            System.out.println("""
                Conversión personalizada
                
                1) Nueva conversión
                2) Mostrar códigos válidos
                3) Salir
                
                Elija una opción válida:
                """);
            option = scanner.nextLine();
            customConversionMenuSwitch(option);
        } while (!option.equalsIgnoreCase("3"));
        this.printDivider(40);

    }

    private void printDivider(Integer numberOfAsterisks) {
        for (int i = 0; i < numberOfAsterisks; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void innerMenuSwitch(String option) {
        Double amountToConvert;
        switch (option) {
            case "1" -> {
                System.out.println("Dólar =>> Peso argentino");
                amountToConvert = AuxFunction.askAmount();
                converter.convertFromTo("USD", "ARS", amountToConvert);
            }
            case "2" -> {
                System.out.println("Peso argentino =>> Dólar");
                amountToConvert = AuxFunction.askAmount();
                converter.convertFromTo("ARS", "USD", amountToConvert);
            }
            case "3" -> {
                System.out.println("Dólar =>> Real brasileño");
                amountToConvert = AuxFunction.askAmount();
                converter.convertFromTo("USD", "BRL", amountToConvert);
            }
            case "4" -> {
                System.out.println("Real brasileño =>> Dólar");
                amountToConvert = AuxFunction.askAmount();
                converter.convertFromTo("BRL", "USD", amountToConvert);
            }
            case "5" -> {
                System.out.println("Dólar =>> Peso colombiano");
                amountToConvert = AuxFunction.askAmount();
                converter.convertFromTo("USD", "COP", amountToConvert);
            }
            case "6" -> {
                System.out.println("Peso colombiano =>> Dólar");
                amountToConvert = AuxFunction.askAmount();
                converter.convertFromTo("COP", "USD", amountToConvert);
            }
            case "7" -> {
                System.out.println("Conversión personalizada");
                customConversionMenu();
            }
            case "8" -> System.out.println("Saliendo de la aplicación");
            default -> System.out.println("Debe elegir una opción válida");
        }
    }

    public void customConversionMenuSwitch(String option) {
        switch (option) {
            case "1" -> customConversion();
            case "2" -> {
                System.out.println("Códigos aceptados");
                converter.showCodes();
            }
            default -> System.out.println("Debe ingresar una opción válida");
        }
    }

    public void customConversion() {
        Set<String> codes = converter.returnCodes();

        String codeFrom = AuxFunction.askCode(codes);
        String codeTo = AuxFunction.askCode(codes, codeFrom);
        Double amountToConvert = AuxFunction.askAmount();

        converter.convertFromTo(codeFrom, codeTo, amountToConvert);

    }


}
