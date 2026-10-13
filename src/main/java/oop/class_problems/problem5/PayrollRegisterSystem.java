package oop.class_problems.problem5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PayrollRegisterSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Payslip> payslips = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            String type = parts[0];
            String name = parts[1];
            long pay;
            if (type.equals("PartTime")) {
                pay = Long.parseLong(parts[2]) * Long.parseLong(parts[3]);
            } else {
                pay = Long.parseLong(parts[2]);
            }
            payslips.add(new Payslip(name, type, pay));
        }

        long total = 0;
        Payslip topEarner = null;
        for (Payslip payslip : payslips) {
            System.out.println(payslip);
            total += payslip.pay;
            if (topEarner == null || payslip.pay > topEarner.pay) {
                topEarner = payslip;
            }
        }
        System.out.println("Total " + total);
        if (topEarner != null) {
            System.out.println("top earner " + topEarner.name);
        }
    }

    private static class Payslip {
        private final String name;
        private final String type;
        private final long pay;

        private Payslip(String name, String type, long pay) {
            this.name = name;
            this.type = type;
            this.pay = pay;
        }

        @Override
        public String toString() {
            return "Payslip[name=" + name + ", type=" + type + ", pay=" + pay + "]";
        }
    }
}