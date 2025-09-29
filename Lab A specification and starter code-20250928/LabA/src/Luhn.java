import java.util.Scanner;

public class Luhn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        String input = scanner.nextLine().replaceAll("\\s", "");
        int checkDigit = Integer.parseInt(input.substring(input.length()-1));
        input = input.substring(0,input.length()-1);
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt((input.length()-1)-i);
            int digit = Character.getNumericValue(ch)*((i+1)%2+1);
            if (digit>9) {
                digit -= 9;
            }
            sum+=digit;
        }
        if (checkDigit == (10-(sum%10))%10) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
        scanner.close();
    }
}
