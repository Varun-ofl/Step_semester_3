package oop.assignment_problems.problem1;

public class ClassTopperFinder {
    public static Result findTopper(int[][] marks) {
        int bestRow = 0;
        int bestTotal = -1;

        for (int row = 0; row < marks.length; row++) {
            int total = 0;
            for (int mark : marks[row]) {
                total += mark;
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = row;
            }
        }
        return new Result(bestRow, bestTotal);
    }

    public record Result(int rowIndex, int total) {
        @Override
        public String toString() {
            return "(" + rowIndex + ", " + total + ")";
        }
    }

    public static void main(String[] args) {
        int[][] marks = {{78, 85, 90}, {88, 92, 79}, {65, 70, 95}};
        System.out.println(findTopper(marks));
    }
}
