import java.util.Scanner;

public class EANBarcodeCompleter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean valid = false;
        while (!valid) {
            System.out.println("Enter the barcode prefix");
            String barcodePrefix = scanner.nextLine();

            if (barcodePrefix.length() == 12 && isDigits(barcodePrefix)) {
                int sum = 0;
                for (int i = 0; i < barcodePrefix.length(); i++) {
                    int digit = Character.getNumericValue(barcodePrefix.charAt(i));
                    sum += digit * ((i % 2) * 3 + 1);
                }
                
                System.out.println("Complete barcode:" + barcodePrefix + (10 - (sum % 10)));

            } else {
                System.out.println("Invalid barcode prefix");
            }
        }
        scanner.close();
    }

    public static boolean isDigits(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (!Character.isDigit(a.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
