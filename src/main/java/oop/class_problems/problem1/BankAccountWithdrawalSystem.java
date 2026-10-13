package oop.class_problems.problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BankAccountWithdrawalSystem {
    private static final Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            if (parts[0].equals("Savings") || parts[0].equals("Current")) {
                accounts.put(parts[1], new Account(parts[0], Long.parseLong(parts[2])));
            } else if (parts[0].equals("WITHDRAW")) {
                withdraw(parts[1], Long.parseLong(parts[2]));
            }
        }
    }

    private static void withdraw(String id, long amount) {
        Account account = accounts.get(id);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        long newBalance = account.balance - amount;
        if (account.type.equals("Savings") && newBalance < 1000) {
            System.out.println(id + " rejected: minimum balance 1000");
        } else if (account.type.equals("Current") && newBalance < -5000) {
            System.out.println(id + " rejected: overdraft limit 5000");
        } else {
            account.balance = newBalance;
            System.out.println(id + " balance " + account.balance);
        }
    }

    private static class Account {
        private final String type;
        private long balance;

        private Account(String type, long balance) {
            this.type = type;
            this.balance = balance;
        }
    }
}