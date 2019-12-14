package com.company.backtrack.subsets;

import java.util.ArrayList;
import java.util.Collections;

public class Combinations {
    public void getCombinations(ArrayList<Integer> numbers, ArrayList<ArrayList<Integer>> combinations, ArrayList<Integer> state, int index, int k) {
        if (state.size() == k) {
            combinations.add(state);
            return;
        }

        for (int i = index; i < numbers.size(); i++) {
            ArrayList<Integer> arrayList = new ArrayList<>(state);
            arrayList.add(numbers.get(i));
            getCombinations(numbers, combinations, arrayList, i + 1, k);
        }
    }

    public static void main(String[] args) {
        Combinations combinations1 = new Combinations();
        int n = 4;
        int k = 2;

        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.sort(numbers);

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        ArrayList<Integer> state = new ArrayList<>();
        combinations1.getCombinations(numbers, combinations, state, 0, k);

        System.out.println(combinations);
    }
}
