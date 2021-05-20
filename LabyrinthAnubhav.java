//package com.company;
//import java.io.*;
//import java.util.*;
//
//public class LabyrinthAnubhav {
//    static int srcx;
//    static int srcy;
//    static int destx;
//    static int desty;
//    static char[] dir = "URDL".toCharArray();
//
//    class Pair {
//        int x;
//        int y;
//
//        public Pair(int x, int y)
//        {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int[] dx = {-1, 0, 1, 0};
//        int[] dy = {0, 1, 0, -1};
//
//        int row = Integer.parseInt(st.nextToken());
//        int column = Integer.parseInt(st.nextToken());
//
//        char[][] parentz = new char[row][column];
//
//
//        Pair[][] parent = new Pair[row][column];
//
//        int[][] dist = new int[row][column];
//        char[][] charArr = new char[row][column];
//        for (int i = 0; i < row; i++) {
//            br.readLine().getChars(0, column, charArr[i], 0);
//            for (int j = 0; j < column; j++) {
//                if (charArr[i][j] == 'A') {
//                    srcx = i;
//                    srcy = j;
//                    char source = charArr[i][j];
//                }
//            }
//        }
//        int val = BFS(parent, parentz, charArr, dist, srcx, srcy, dy, dx,dir, row, column);
//        if (val == -1) System.out.println("NO");
//        else {
//            System.out.println("YES");
//            System.out.println(val);
//
//            int u = destx;
//            int v = desty;
//
//            parent[srcx][srcy] = new Pair(-1,-1);
//            StringBuilder route = new StringBuilder();
//
//            while (u != -1 && v != -1) {
//                route.append(parentz[u][v]);
//                Pair now = parent[u][v];
//                u = now.x;
//                v = now.y;
//            }
//            System.out.println(new String(route.reverse().toString()));
//            // System.out.println("RDD");
//            return;
//        }
//    }
//
//    public static boolean isValid(int x, int y, int row, int column, char[][] charArr) {
//        if (x < 0 || x >= row || y < 0 || y >= column) return false;
//        if (charArr[x][y] == '#') return false;
//        return true;
//    }
//
//    public static int BFS(Pair[][] parent, char[][] parentz, char[][] charArr, int[][] dist, int srcx, int srcy, int[] dy, int[] dx, char dir[], int row, int column) {
//        Queue<Integer> queuex =  new LinkedList<>();
//        Queue<Integer> queuey =  new LinkedList<>();
//        dist[srcx][srcy] = 0;
//        queuex.add(srcx);
//        queuey.add(srcy);
//        parentz[srcx][srcy] = ' ';
//        charArr[srcx][srcy] = '#';
//        while (!queuex.isEmpty()) {
//            int currx = queuex.poll();
//            int curry = queuey.poll();
//
//            for (int i = 0; i < 4; i++) {
//                int newx = currx + dx[i];
//                int newy = curry + dy[i];
//                if (isValid(newx, newy, row, column, charArr)) {
//                    parent[newx][newy] = new Pair(currx,curry);
//                    parentz[newx][newy] = dir[i];
//
//                    dist[newx][newy] = dist[currx][curry] + 1;
//
//                    if (charArr[newx][newy] == 'B') {
//                        destx = newx;
//                        desty = newy;
//                        return dist[newx][newy];
//                    } else {
//                        charArr[newx][newy] = '#';
//                        queuex.add(newx);
//                        queuey.add(newy);
//                    }
//                }
//            }
//        }
//        return -1;
//    }
//}