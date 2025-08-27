package com.java.String.problems;

import java.util.ArrayList;
import java.util.List;

public class Permutations {			// backtracking + recursion
    public static void main(String[] args) {
        String s = "123";
        List<String> result = new ArrayList<>();
        permute(s.toCharArray(), 0, result);
        System.out.println(result);
    }

    static void permute(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            permute(chars, index + 1, result);
            swap(chars, i, index); // backtrack
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
