package com.company.backtrack.subsets;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSumII {
    public void getCombinations(
            ArrayList<Integer> numbers,
            ArrayList<ArrayList<Integer>> combinations,
            ArrayList<Integer> state,
            int sum,
            int target,
            int index
    ) {
        if (target == sum) {
            combinations.add(state);
        }
        if (sum >= target) {
            return;
        }

        int prev = Integer.MIN_VALUE;

        for (int i = index; i < numbers.size(); i++) {
            if (prev == numbers.get(i)) {
                continue;
            }
            ArrayList<Integer> arrayList = new ArrayList<>(state);
            arrayList.add(numbers.get(i));
            getCombinations(
                    numbers,
                    combinations,
                    arrayList,
                    sum + numbers.get(i),
                    target,
                    i + 1
            );
            prev = numbers.get(i);
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(15);
        numbers.add(8);
        numbers.add(15);
        numbers.add(10);
        numbers.add(19);
        numbers.add(18);
        numbers.add(10);
        numbers.add(3);
        numbers.add(11);
        numbers.add(7);
        numbers.add(17);


        int target = 33;

        CombinationSumII combinationSum = new CombinationSumII();


        Collections.sort(numbers);

        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        ArrayList<Integer> state = new ArrayList<>();
        combinationSum.getCombinations(
                numbers,
                combinations,
                state,
                0,
                target,
                0
        );

        System.out.println(combinations);

    }
}
