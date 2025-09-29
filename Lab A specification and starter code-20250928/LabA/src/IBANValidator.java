import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.math.BigInteger;

public class IBANValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean valid = false;
        while (!valid) {

            System.out.println("Enter the IBAN");
            String ibanInput = scanner.nextLine().replaceAll("\\s", "");

            if (isDigitsOrCaps(ibanInput)) {
                if (countryCode(ibanInput)){
                    ibanInput = ibanInput + ibanInput.substring(0, 4);
                    ibanInput = ibanInput.substring(4);
                    String result = "";
                    for (int i = 0; i < ibanInput.length(); i++) {
                        char ch = ibanInput.charAt(i);
                        if (Character.isUpperCase(ch)) {
                            result += (int) ch - 55;
                        } else {
                            result += ch;
                        }
                    }
                    BigInteger bigInt = new BigInteger(result);
                    System.out.println(bigInt);
                    if (bigInt.mod(BigInteger.valueOf(89)).intValue() == 1) {
                        System.out.println("Valid IBAN");
                        valid = true;
                    } else {
                        System.out.println("Invalid IBAN");
                    }
                }
            } else {
                System.out.println("Invalid IBAN");
            }
        }
        scanner.close();
    }

    public static boolean isDigitsOrCaps(String iban) {

        for (int i = 0; i < iban.length(); i++) {
            char ch = iban.charAt(i);
            if (!Character.isDigit(ch) && !Character.isUpperCase(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean countryCode(String iban) {
        Map<String, Integer> codes = new HashMap<>();
        codes.put("GB", 22);
        codes.put("DE", 22);
        codes.put("FR", 27);
        codes.put("ES", 24);
        codes.put("IT", 27);
        codes.put("NL", 18);
        codes.put("BE", 16);
        codes.put("CH", 21);

        if (iban.length() == codes.get(iban.substring(0, 2))) {
            return true;
        } else {
            System.out.println("IBAN length does not match ISO");
            return false;
        }
    }
}
