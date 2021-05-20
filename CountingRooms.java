package com.company;

import java.util.*;
import java.io.*;

public class CountingRooms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        char[][] charArr = new char[row][column];
        for (int i = 0; i < row; i++)
            br.readLine().getChars(0, column, charArr[i], 0);
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int count = 0;
//        int row = input.nextInt(), column = input.nextInt();
//        input.nextLine();
//        char[][] charArr = new char[row][];
//        for (int i = 0; i < row; i++) {
//            charArr[i] = input.next().toCharArray();
//        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (charArr[i][j] == '.') {
                    DFS(charArr, row, column, i, j);
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
    public static void DFS(char[][] charArr, int row, int column, int i, int j) {
        if (i >= 0 && j >= 0 && i < row && j < column) {
            if (charArr[i][j] == '.') {
                charArr[i][j] = '#';
                DFS(charArr, row, column, i + 1, j);
                DFS(charArr, row, column, i, j + 1);
                DFS(charArr, row, column, i - 1, j);
                DFS(charArr, row, column, i, j - 1);
            }
        }
    }
}
