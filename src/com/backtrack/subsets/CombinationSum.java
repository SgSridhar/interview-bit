package com.backtrack.subsets;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {
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

        for (int i = index; i < numbers.size(); i++) {
            ArrayList<Integer> arrayList = new ArrayList<>(state);
            arrayList.add(numbers.get(i));
            getCombinations(
                numbers,
                combinations,
                arrayList,
                sum + numbers.get(i),
                target,
                i
            );
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(6);
        numbers.add(7);


        int target = 7;

        CombinationSum combinationSum = new CombinationSum();


        Collections.sort(numbers);
        ArrayList<Integer> dedupNumbers = new ArrayList<>();

        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > prev) {
                dedupNumbers.add(numbers.get(i));
            }
            prev = numbers.get(i);
        }

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
