package oop.class_problems.problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ClassMarksGridAnalysis {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = new ArrayList<>();
        List<int[]> marks = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            int openingBracket = line.indexOf('[');
            String name = line.substring(0, openingBracket).trim();
            String values = line.substring(openingBracket + 1, line.indexOf(']'));
            String[] valueParts = values.split(",");
            int[] studentMarks = new int[valueParts.length];
            for (int index = 0; index < valueParts.length; index++) {
                studentMarks[index] = Integer.parseInt(valueParts[index].trim());
            }
            names.add(name);
            marks.add(studentMarks);
        }

        if (marks.isEmpty()) {
            return;
        }

        StringBuilder totals = new StringBuilder("Totals");
        double[] subjectTotals = new double[marks.get(0).length];
        int topperIndex = 0;
        int topperTotal = -1;

        for (int studentIndex = 0; studentIndex < marks.size(); studentIndex++) {
            int total = 0;
            for (int subjectIndex = 0; subjectIndex < marks.get(studentIndex).length; subjectIndex++) {
                total += marks.get(studentIndex)[subjectIndex];
                subjectTotals[subjectIndex] += marks.get(studentIndex)[subjectIndex];
            }
            totals.append(' ').append(names.get(studentIndex)).append(' ').append(total).append(',');
            if (total > topperTotal) {
                topperTotal = total;
                topperIndex = studentIndex;
            }
        }

        totals.deleteCharAt(totals.length() - 1);
        System.out.println(totals);

        StringBuilder averages = new StringBuilder("averages");
        for (double subjectTotal : subjectTotals) {
            averages.append(' ').append(String.format(Locale.ROOT, "%.2f", subjectTotal / marks.size())).append(',');
        }
        averages.deleteCharAt(averages.length() - 1);
        System.out.println(averages);
        System.out.println("topper " + names.get(topperIndex) + " (" + topperTotal + ")");
    }
}