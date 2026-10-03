package oop.assignment_problems.problem3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostPopularCanteenOrder {
    public static Result mostPopular(List<String> orders) {
        Map<String, Integer> counts = new HashMap<>();
        for (String order : orders) {
            counts.merge(order, 1, Integer::sum);
        }

        String popularItem = orders.get(0);
        int highestCount = counts.get(popularItem);
        for (String order : orders) {
            if (counts.get(order) > highestCount) {
                popularItem = order;
                highestCount = counts.get(order);
            }
        }
        return new Result(popularItem, highestCount);
    }

    public record Result(String item, int count) {
        @Override
        public String toString() {
            return "(\"" + item + "\", " + count + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println(mostPopular(
                List.of("dosa", "idli", "vada", "dosa", "idli", "dosa", "tea")));
        System.out.println(mostPopular(List.of("tea", "coffee", "coffee", "tea")));
    }
}
