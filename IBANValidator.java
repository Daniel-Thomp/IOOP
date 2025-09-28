import java.util.Scanner;
import java.math.BigInteger;

public class IBANValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean valid = false;
        while (!valid) {

            System.out.println("Enter the IBAN");
            String ibanInput = scanner.nextLine().replaceAll("\\s", "");

            if (ibanInput.length() > 14 && isDigitsOrCaps(ibanInput)) {
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
                if (bigInt.mod(BigInteger.valueOf(89)).intValue() == 1) {
                    System.out.println("Valid IBAN");
                    valid = true;
                } else {
                    System.out.println("Invalid IBAN");
                }
            } else {
                System.out.println("Invalid IBAN");
            }
        }
        scanner.close();
    }

    public static boolean isDigitsOrCaps(String a) {
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (!Character.isDigit(ch) && !Character.isUpperCase(ch)) {
                return false;
            }
        }
        return true;
    }
}
