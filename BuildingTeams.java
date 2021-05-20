//package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildingTeams {
    private static final BuildingTeams.InputReader console = new InputReader();
    private static List<List<Integer>> adj;

    public static void main(String[] args) throws IOException {

        adj = new ArrayList<>() ;
        int n = console.nextInt();
        int m = console.nextInt();
        StringBuilder sc = new StringBuilder();
        boolean[] vis = new boolean[n];
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = console.nextInt() - 1;
            int d = console.nextInt() - 1;
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                boolean isValid = checkBipartiteByDFS(vis, color, i);
                if (isValid == false)
                    System.out.println("IMPOSSIBLE");
            }
        }
        for (int i = 0; i < color.length; i++) {
            System.out.print(color[i] + 2 + " ");
        }
    }
    public static boolean checkBipartiteByDFS(boolean[] vis, int[] color, int i) {
        Stack<Integer> stack = new Stack<>();
        vis[i] = true;
        stack.add(i);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int child : adj.get(curr)) {
                if (!vis[child]) {
                    stack.add(child);
                    vis[child] = true;
                    color[child] = ~color[curr];
                } else {
                    if (color[child] == color[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static final class InputReader {
        private final int BUFFER_SIZE = 1 << 24;

        private final DataInputStream in = new DataInputStream(System.in);
        private final byte[] buffer = new byte[BUFFER_SIZE];
        private final byte[] buf = new byte[BUFFER_SIZE];
        private int bufferPointer = 0, bytesRead = 0;

        private void fillBuffer() throws IOException {
            bytesRead = in.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public String next() throws IOException {
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c < 33) {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public String nextLine() throws IOException {
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\r' || c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            return (int) nextLong();
        }

        public long nextLong() throws IOException {
            long ret = 0L, c = read();
            while (c < 33L) {
                c = read();
            }
            boolean neg = (c == 45L);
            if (neg) {
                c = read();
            }
            do {
                ret = (ret << 3) + (ret << 1) + c - 48L;
            } while ((c = read()) > 47 && c < 58);
            return (neg ? -ret : ret);
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public void close() throws IOException {
            in.close();
        }
    }
}


