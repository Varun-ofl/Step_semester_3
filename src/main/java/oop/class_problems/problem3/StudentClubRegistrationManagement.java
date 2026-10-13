package oop.class_problems.problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class StudentClubRegistrationManagement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Student> members = new HashSet<>();
        StringBuilder addOutput = new StringBuilder();
        StringBuilder containsOutput = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            if (parts[0].equals("ADD")) {
                if (members.add(new Student(parts[1], parts[2]))) {
                    addOutput.append("Added\n");
                } else {
                    addOutput.append("duplicate rejected\n");
                }
            } else if (parts[0].equals("CONTAINS")) {
                boolean contains = members.contains(new Student(parts[1], parts[2]));
                containsOutput.append("contains: ").append(contains).append('\n');
            }
        }

        System.out.print(addOutput);
        System.out.println("member count " + members.size());
        System.out.print(containsOutput);
    }

    private static class Student {
        private final String rollNumber;
        private final String name;

        private Student(String rollNumber, String name) {
            this.rollNumber = rollNumber;
            this.name = name;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Student student)) {
                return false;
            }
            return rollNumber.equals(student.rollNumber);
        }

        @Override
        public int hashCode() {
            return rollNumber.hashCode();
        }
    }
}