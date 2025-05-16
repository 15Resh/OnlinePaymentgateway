import java.util.Scanner;


class PaymentDetails {
    String cardNumber;
    String cvv;
    String expiryDate;
    double amount;

    public PaymentDetails(String cardNumber, String cvv, String expiryDate, double amount) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.amount = amount;
    }

    public boolean isValid() {
        return cardNumber.length() == 16 &&
               cvv.length() == 3 &&
               expiryDate.matches("\\d{2}/\\d{2}") &&
               amount > 100;
    }
}


class PaymentProcessor {

    public boolean process(PaymentDetails details) {
        if (details.amount <= 10000) {
            return true; 
        } else {
            return false; 
        }
    }
}

public class OnlinePaymentgateway {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Online Payment Gateway ===");

        System.out.print("Enter Card Number (16 digits): ");
        String cardNumber = scanner.nextLine();

        System.out.print("Enter CVV (3 digits): ");
        String cvv = scanner.nextLine();

        System.out.print("Enter Expiry Date (MM/YY): ");
        String expiryDate = scanner.nextLine();

        System.out.print("Enter Amount to Pay: ₹");
        double amount = scanner.nextDouble();

        PaymentDetails details = new PaymentDetails(cardNumber, cvv, expiryDate, amount);

        if (details.isValid()) {
            PaymentProcessor processor = new PaymentProcessor();
            boolean result = processor.process(details);
            if (result) {
                System.out.println("Payment of ₹" + amount + " successful!");
            } else {
                System.out.println("Payment failed: Amount exceeds limit.");
            }
        } else {
            System.out.println("Invalid payment details. Please check and try again.");
        }

        scanner.close();
    }
}
