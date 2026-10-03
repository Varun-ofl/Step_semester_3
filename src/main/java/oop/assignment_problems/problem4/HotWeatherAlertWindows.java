package oop.assignment_problems.problem4;

public class HotWeatherAlertWindows {
    public static int countAlerts(int[] readings, int k, int threshold) {
        long windowSum = 0;
        for (int index = 0; index < k; index++) {
            windowSum += readings[index];
        }

        int alerts = windowSum >= (long) k * threshold ? 1 : 0;
        for (int index = k; index < readings.length; index++) {
            windowSum += readings[index] - readings[index - k];
            if (windowSum >= (long) k * threshold) {
                alerts++;
            }
        }
        return alerts;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(countAlerts(readings, 3, 4));
    }
}
