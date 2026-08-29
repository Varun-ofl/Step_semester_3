class FeeAccount {
}

class HostelFeeAccount extends FeeAccount {
}

class PaymentProcessor {
    public static void processPayment(FeeAccount account, double amount, int[] counters) {
        if (account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
            counters[0]++;
        } else if (account instanceof FeeAccount) {
            System.out.println("Paid in one go (day-scholar account)");
            counters[1]++;
        }
    }
}

class Main {
    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        int[] counters = {0, 0};

        for (FeeAccount acc : accounts) {
            PaymentProcessor.processPayment(acc, 60000, counters);
        }

        System.out.println("Hostel accounts processed: " + counters[0] + " | Day-scholar accounts processed: " + counters[1]);
    }
}
