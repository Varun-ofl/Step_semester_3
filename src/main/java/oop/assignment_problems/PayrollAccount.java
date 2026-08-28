import java.util.Scanner;

public class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Basic salary cannot be negative; starting at 0.0");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount < 0) {
            System.out.println("Bonus rejected: amount cannot be negative");
        } else {
            bonus += amount;
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: percent must be between 0 and 100");
        } else {
            basicSalary -= basicSalary * percent / 100;
        }
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayrollAccount account = new PayrollAccount(scanner.nextDouble());
        account.creditBonus(scanner.nextDouble());
        double taxPercent = scanner.nextDouble();
        account.deductTax(taxPercent);
        System.out.printf("Bonus credited: Rs %.1f%n", account.bonus);
        System.out.printf("Tax deducted: %.1f%%%n", taxPercent);
        System.out.printf("Net salary: Rs %.1f%n", account.getNetSalary());
        scanner.close();
    }
}