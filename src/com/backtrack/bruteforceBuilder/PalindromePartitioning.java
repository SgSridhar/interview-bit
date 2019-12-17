package com.backtrack.bruteforceBuilder;

import java.util.ArrayList;

public class PalindromePartitioning {
    public static boolean isPalindrome(String string) {
        for (int i = 0; i < (string.length() / 2); i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void partitions(
        String input,
        ArrayList<ArrayList<String>> palindromes,
        ArrayList<String> state,
        int index
    ) {
        if (index == input.length()) {
            palindromes.add(state);
            return;
        }

        ArrayList<String> arrayList1 = new ArrayList<>(state);
        arrayList1.add(input.charAt(index) + "");

        partitions(input, palindromes, arrayList1, index + 1);

        if (!state.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(state);
            int lastIndex = arrayList.size() - 1;
            arrayList.set(lastIndex, arrayList.get(lastIndex) + input.charAt(index));
            partitions(input, palindromes, arrayList, index + 1);
        }
    }

    public static void main(String[] args) {
        String input = "efe";
        ArrayList<ArrayList<String>> palindromes = new ArrayList<>();
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> state = new ArrayList<>();

        partitions(input, palindromes, state, 0);

        palindromes
                .forEach(item -> {
                    boolean isPalindrome = true;
                    for (String s : item) {
                        if (!isPalindrome(s)) {
                            isPalindrome = false;
                        }
                    }

                    if (isPalindrome) {
                        res.add(item);
                    }
                });

        System.out.println(res);
    }
}
