package com.company;

import java.util.Scanner;

public class GuessingTheNumber {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int low = 1, high = 1000000, answer = 0;

        while (low <= high) {
            int mid = low + (high - low)/2;
            System.out.println(mid);
            System.out.flush();
            String x = input.next();

            if (x.equals(">=")) {
                answer = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        System.out.println("! " + answer);
        System.out.flush();
    }
}
