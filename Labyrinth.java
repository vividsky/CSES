//package com.company;

import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;
    int d;
    public Pair(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Labyrinth {
    private static int srcx;
    private static int srcy;
    private static int destx;
    private static int desty;
    private static char c;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder route = new StringBuilder();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        char[] m = "URDL".toCharArray();

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        Pair[][] parent = new Pair[row][column];
        char[][] parentz = new char[row][column];

        char[][] charArr = new char[row][column];
        for (int i = 0; i < row; i++) {
            br.readLine().getChars(0, column, charArr[i], 0);
            for (int j = 0; j < column; j++) {
                if (charArr[i][j] == 'A') {
                    srcx = i;
                    srcy = j;
                }
            }
        }
        int val = BFS(parent, parentz, charArr, srcx, srcy, dy, dx, m,  row, column);
        if (val == -1) System.out.println("NO");
        else {
            System.out.println("YES");
            System.out.println(val);
            int u = destx;
            int v = desty;

            while (parent[u][v].x != -1 && parent[u][v].y != -1) {
                route.append(parentz[u][v]);
                Pair now = parent[u][v];
                u = now.x;
                v = now.y;
            }
            System.out.println(new String(route.reverse().toString()));
        }


    }
    public static boolean isValid(int x, int y, int row, int column, char[][] charArr) {
        if (x < 0 || x >= row || y < 0 || y >= column) return false;
        if (charArr[x][y] == '#') return false;
        return true;
    }
    public static int BFS(Pair[][] parent, char[][] parentz, char[][] charArr, int srcx, int srcy, int[] dy, int[] dx, char[] m, int row, int column) {
        Queue<Integer> queuex =  new LinkedList<>();
        Queue<Integer> queuey =  new LinkedList<>();
        queuex.add(srcx);
        queuey.add(srcy);
        charArr[srcx][srcy] = '#';
        parentz[srcx][srcy] = ' ';
        parent[srcx][srcy] = new Pair(-1, -1, 0);
        while (!queuex.isEmpty()) {
            int currx = queuex.poll();
            int curry = queuey.poll();

            for (int i = 0; i < 4; i++) {
                int newx = currx + dx[i];
                int newy = curry + dy[i];
                if (isValid(newx, newy, row, column, charArr)) {
                    parent[newx][newy] = new Pair(currx, curry, parent[currx][curry].d + 1);
                    parentz[newx][newy] = m[i];

                    if (charArr[newx][newy] == 'B') {
                        destx = newx;
                        desty = newy;
                        return parent[newx][newy].d;
                    } else {
                        charArr[newx][newy] = '#';
                        queuex.add(newx);
                        queuey.add(newy);
                    }
                }
            }
        }
        return -1;
    }
}
