import java.util.Scanner;
import java.util.Set;

public class AuxFunction {

    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    public static Boolean validateCode(String code, Set<String> codes) {
        return codes.contains(code);
    }

    public static Boolean validateCode(String code, String previousCode, Set<String> codes) {
        if ( code.equals(previousCode)) {
            System.out.println("Código repetido. Por favor, ingresa otro código válido.");
            return false;
        }
        return codes.contains(code);
    }

    private static boolean IsInteger(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static Double pedirMonto() {
        String amountString;
        do {
            System.out.println("Ingrese la cantidad a convertir: ");
            amountString = scanner.next();
        } while (!IsInteger(amountString));
        return Double.parseDouble(amountString);
    }

    public static String pedirCodigo(Set<String> codes) {
        String code;
        boolean flag;
        do {
            System.out.println("Ingrese el código de la moneda base: ");
            code = scanner.next();
            flag = validateCode(code, codes);
        } while(!flag);
        return code;
    }

    public static String pedirCodigo(Set<String> codes, String previousCode) {
        String code;
        boolean flag;
        do {
            System.out.println("Ingrese el código de la moneda objetivo: ");
            code = scanner.next();
            flag = validateCode(code, previousCode, codes);
        } while(!flag);
        return code;
    }

}
