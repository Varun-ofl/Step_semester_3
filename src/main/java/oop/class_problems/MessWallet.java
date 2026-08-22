import java.util.Scanner;

public class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Opening balance cannot be negative; starting at 0.0");
            balance = 0;
        } else {
            balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected");
        } else {
            balance += amount;
        }
    }

    public void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter opening balance: ");
        MessWallet wallet = new MessWallet(scanner.nextDouble());

        System.out.print("Enter top-up amount: ");
        wallet.topUp(scanner.nextDouble());
        System.out.printf("Balance after top-up: %.1f%n", wallet.getBalance());

        System.out.print("Enter deduction amount: ");
        wallet.deduct(scanner.nextDouble());
        System.out.printf("Final balance: %.1f%n", wallet.getBalance());
        scanner.close();
    }
}