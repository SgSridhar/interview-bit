package com.backtrack.bruteforceBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LetterPhone {
    public static void getLetterMappings(
        HashMap<Character, ArrayList<Character>> catalog,
        String digits,
        ArrayList<String> combinations,
        String state,
        int digitIndex
    ) {
        if (state.length() == digits.length()) combinations.add(state);

        for (int i = digitIndex; i < digits.length(); i++) {
            char digitAtI = digits.charAt(i);
            ArrayList<Character> digitCatalog = catalog.get(digits.charAt(i));

            if (digitAtI == '0' || digitAtI == '1') {
                getLetterMappings(
                        catalog,
                        digits,
                        combinations,
                        state + digitAtI,
                        i + 1
                );
            } else {
                for (Character character : digitCatalog) {
                    getLetterMappings(
                            catalog,
                            digits,
                            combinations,
                            state + character,
                            i + 1
                    );
                }

            }
        }

    }

    public static void main(String[] args) {
        String digits = "1234";
        ArrayList<String> combinations = new ArrayList<>();

        HashMap<Character, ArrayList<Character>> catalog = new HashMap<>();

        catalog.put('2', new ArrayList<Character>(Arrays.asList('a', 'b', 'c')));
        catalog.put('3', new ArrayList<Character>(Arrays.asList('d', 'e', 'f')));
        catalog.put('4', new ArrayList<Character>(Arrays.asList('g', 'h', 'i')));
        catalog.put('5', new ArrayList<Character>(Arrays.asList('j', 'k', 'l')));
        catalog.put('6', new ArrayList<Character>(Arrays.asList('m', 'n', 'o')));
        catalog.put('7', new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's')));
        catalog.put('8', new ArrayList<Character>(Arrays.asList('t', 'u', 'v')));
        catalog.put('9', new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z')));

        LetterPhone.getLetterMappings(catalog, digits, combinations, "", 0);

        System.out.println(combinations);
    }
}
