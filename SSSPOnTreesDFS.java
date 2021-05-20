package com.company;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class SSSPOnTreesDFS {
    private static List<List<Integer>> adj;
    public static void main(String[] args) throws IOException {

        int n = console.nextInt();
        int m = console.nextInt();
        adj = new ArrayList<>();

        int source = 0;
        int dis = 0;
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];


        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }
        for (int i = 0; i < m; i++) {
            int s = console.nextInt() - 1;
            int d = console.nextInt() - 1;
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        DFS(vis, dist, dis, source);
        System.out.println(Arrays.toString(dist));

    }
    public static void DFS(boolean[] vis, int[] dist, int dis, int source) {
        vis[source] = true;
        int curr = source;
        for (int neighbour: adj.get(curr)) {
            if (!vis[neighbour]) {
                 DFS(vis, dist, dis + 1, neighbour);
            }
        }dist[curr] = dis;
    }

    private static final SSSPOnTreesDFS.InputReader console = new SSSPOnTreesDFS.InputReader();

    public static final class InputReader {

        private final int BUFFER_SIZE = 1 << 24;

        private final DataInputStream in;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public InputReader() {
            in = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

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

        public int nextInt() throws IOException {
            int ret = 0, c = read();
            do {
                ret = (ret << 3) + (ret << 1) + c - 48;
            } while ((c = read()) > 47 && c < 58);
            return ret;
        }
    }
}
