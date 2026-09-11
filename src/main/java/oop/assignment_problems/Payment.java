public class Payment {
    public void pay(double amount) {
        System.out.printf("Paid (cash): Rs %.1f%n", amount);
    }

    public static void processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment cardPayment = (CardPayment) payment;
            double chargedAmount = cardPayment.payWithProcessingFee(amount);
            System.out.printf("Charged (card, incl. fee): Rs %.1f%n", chargedAmount);
        } else {
            payment.pay(amount);
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(), new Payment(), new CardPayment(), new Payment(), new CardPayment()
        };
        double[] amounts = {100, 50, 200, 75, 120};
        double totalCollected = 0;

        for (int index = 0; index < payments.length; index++) {
            processTransaction(payments[index], amounts[index]);
            totalCollected += payments[index] instanceof CardPayment
                    ? ((CardPayment) payments[index]).calculateAmountWithFee(amounts[index])
                    : amounts[index];
        }

        System.out.printf("Total Collected: Rs %.1f%n", totalCollected);
    }
}

class CardPayment extends Payment {
    public double payWithProcessingFee(double amount) {
        return calculateAmountWithFee(amount);
    }

    public double calculateAmountWithFee(double amount) {
        return amount * 1.02;
    }
}