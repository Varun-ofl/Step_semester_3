package oop.class_problems.problem2;

public class WarehouseGridSummary {
    public static Summary warehouseSummary(int[][] grid) {
        int totalItems = 0;
        int maximum = -1;
        int maximumRow = -1;
        int maximumColumn = -1;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                int items = grid[row][column];
                totalItems += items;
                if (items > maximum) {
                    maximum = items;
                    maximumRow = row;
                    maximumColumn = column;
                }
            }
        }
        return new Summary(totalItems, maximumRow, maximumColumn);
    }

    public record Summary(int totalItems, int maximumRow, int maximumColumn) {
        @Override
        public String toString() {
            return "(" + totalItems + ", (" + maximumRow + ", " + maximumColumn + "))";
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 9, 2}, {7, 1, 6}, {3, 12, 5}};
        System.out.println(warehouseSummary(grid));
    }
}
