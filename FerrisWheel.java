package com.company;

import java.util.*;

public class FerrisWheel {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), weight = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);

        int i = 0, j = n - 1, count = 0;
        while (i <= j) {
            if (arr[i] + arr[j] <= weight)
                i++;
            count++;
            j--;
        }
        System.out.println(count);
    }
}

