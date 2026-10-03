package oop.assignment_problems.problem2;

import java.util.ArrayList;
import java.util.List;

public class MergingTwoTokenQueues {
    public static List<Integer> mergeTokens(List<Integer> counterA, List<Integer> counterB) {
        List<Integer> merged = new ArrayList<>(counterA.size() + counterB.size());
        int first = 0;
        int second = 0;

        while (first < counterA.size() && second < counterB.size()) {
            if (counterA.get(first) <= counterB.get(second)) {
                merged.add(counterA.get(first++));
            } else {
                merged.add(counterB.get(second++));
            }
        }
        while (first < counterA.size()) {
            merged.add(counterA.get(first++));
        }
        while (second < counterB.size()) {
            merged.add(counterB.get(second++));
        }
        return merged;
    }

    public static void main(String[] args) {
        System.out.println(mergeTokens(
                List.of(3, 8, 15, 20),
                List.of(5, 8, 12)));
        System.out.println(mergeTokens(List.of(), List.of(4, 9)));
    }
}
