import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");

        while (true) {
            System.out.println("\nSelect the conversion type:");
            System.out.println("1. INR to USD");
            System.out.println("2. USD to INR");
            System.out.println("3. INR to EURO");
            System.out.println("4. EURO to INR");
            System.out.println("5. INR to GBP");
            System.out.println("6. GBP to INR");
            System.out.println("7. Exit");

            System.out.print("Enter your choice (1-7): ");
            int choice = scanner.nextInt();

            if (choice == 7) {
                System.out.println("Thank you for using the Currency Converter!");
                break;
            }

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            double convertedAmount = 0;

            switch (choice) {
                case 1:
                    convertedAmount = amount * 0.012; // INR to USD (Example Rate)
                    System.out.printf("₹%.2f = $%.2f\n", amount, convertedAmount);
                    break;
                case 2:
                    convertedAmount = amount * 83.0; // USD to INR (Example Rate)
                    System.out.printf("$%.2f = ₹%.2f\n", amount, convertedAmount);
                    break;
                case 3:
                    convertedAmount = amount * 0.011; // INR to EURO (Example Rate)
                    System.out.printf("₹%.2f = €%.2f\n", amount, convertedAmount);
                    break;
                case 4:
                    convertedAmount = amount * 91.0; // EURO to INR (Example Rate)
                    System.out.printf("€%.2f = ₹%.2f\n", amount, convertedAmount);
                    break;
                case 5:
                    convertedAmount = amount * 0.0095; // INR to GBP (Example Rate)
                    System.out.printf("₹%.2f = £%.2f\n", amount, convertedAmount);
                    break;
                case 6:
                    convertedAmount = amount * 105.0; // GBP to INR (Example Rate)
                    System.out.printf("£%.2f = ₹%.2f\n", amount, convertedAmount);
                    break;
                default:
                    System.out.println("Invalid choice! Please select from 1 to 7.");
            }
        }

        scanner.close();
    }
}