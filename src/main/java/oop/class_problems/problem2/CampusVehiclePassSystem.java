package oop.class_problems.problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CampusVehiclePassSystem {
    private static final Map<String, Vehicle> vehicles = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            if (parts[0].equals("PASS")) {
                Vehicle vehicle = createVehicle(parts[1], parts[2], parts[3]);
                vehicles.put(vehicle.passNumber, vehicle);
                System.out.println(vehicle.passNumber + " (" + vehicle.type + ") pass fee " + vehicle.passFee());
            } else if (parts[0].equals("CHARGE")) {
                charge(parts[1]);
            }
        }
    }

    private static Vehicle createVehicle(String type, String passNumber, String owner) {
        if (type.equals("Bike")) {
            return new Bike(passNumber, owner);
        }
        if (type.equals("Car")) {
            return new Car(passNumber, owner);
        }
        if (type.equals("E-Bike") || type.equals("EBike")) {
            return new ElectricBike(passNumber, owner, type);
        }
        return new ElectricCar(passNumber, owner, type);
    }

    private static void charge(String passNumber) {
        Vehicle vehicle = vehicles.get(passNumber);
        if (vehicle == null || !(vehicle instanceof Chargeable)) {
            System.out.println(passNumber + " rejected: charging unsupported");
        } else {
            System.out.println(passNumber + " charging bay allotted");
        }
    }

    private interface Chargeable {
    }

    private abstract static class Vehicle {
        private final String passNumber;
        private final String owner;
        private final String type;

        private Vehicle(String passNumber, String owner, String type) {
            this.passNumber = passNumber;
            this.owner = owner;
            this.type = type;
        }

        protected abstract int passFee();
    }

    private static class Bike extends Vehicle {
        private Bike(String passNumber, String owner) {
            super(passNumber, owner, "Bike");
        }

        @Override
        protected int passFee() {
            return 300;
        }
    }

    private static class Car extends Vehicle {
        private Car(String passNumber, String owner) {
            super(passNumber, owner, "Car");
        }

        @Override
        protected int passFee() {
            return 1000;
        }
    }

    private static class ElectricBike extends Vehicle implements Chargeable {
        private ElectricBike(String passNumber, String owner, String type) {
            super(passNumber, owner, type);
        }

        @Override
        protected int passFee() {
            return 300;
        }
    }

    private static class ElectricCar extends Vehicle implements Chargeable {
        private ElectricCar(String passNumber, String owner, String type) {
            super(passNumber, owner, type);
        }

        @Override
        protected int passFee() {
            return 1000;
        }
    }
}