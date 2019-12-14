package com.backtrack.subsets;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsII {
    public static void getSubsets(
        ArrayList<Integer> numbers,
        ArrayList<ArrayList<Integer>> combinations,
        ArrayList<Integer> state,
        int index
    ) {
        combinations.add(state);
        int prev = Integer.MIN_VALUE;
        for (int i = index; i < numbers.size(); i++) {
            if (prev == numbers.get(i)) continue;

            ArrayList<Integer> newState = new ArrayList<>(state);
            newState.add(numbers.get(i));
            getSubsets(numbers, combinations, newState, i + 1);

            prev = numbers.get(i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);

        Collections.sort(numbers);

        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        ArrayList<Integer> state = new ArrayList<>();

        SubsetsII.getSubsets(numbers, combinations, state, 0);

        System.out.println(combinations);

    }
}
