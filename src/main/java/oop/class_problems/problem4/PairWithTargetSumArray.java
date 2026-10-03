package oop.class_problems.problem4;

import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSumArray {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> complements = new HashSet<>();
        for (int number : nums) {
            if (complements.contains(number)) {
                return true;
            }
            complements.add(target - number);
        }
        return false;
    }

    public static boolean hasPairWithSumBruteForce(int[] nums, int target) {
        for (int first = 0; first < nums.length; first++) {
            for (int second = first + 1; second < nums.length; second++) {
                if (nums[first] + nums[second] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(hasPairWithSum(new int[]{3, 4, 6}, 20));
    }
}
