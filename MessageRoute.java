package com.company;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class MessageRoute {
    private static List<List<Integer>> adj;
    public static void main(String[] args) throws IOException {

        int n = console.nextInt();
        int m = console.nextInt();
        adj = new ArrayList<>();

        int destination = n-1;
        int[] parent = new int[n];
        ArrayList<Integer> route = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }
        for (int i = 0; i < m; i++) {
            int s = console.nextInt() - 1;
            int d = console.nextInt() - 1;
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        int val = BFS(n, destination, parent);
        if ( val == -1) System.out.println("IMPOSSIBLE");
        else {
            System.out.println(val);
            int x = destination;
            while (parent[x] != -1) {
                route.add(x+1);
                x = parent[x];
            }
            route.add(x + 1);
            for (int i = route.size() - 1; i > -1; i--){
                System.out.print(route.get(i) + " ");
            }
        }
    }
    public static int BFS(int n, int destination, int[] parent) {
        boolean[] vis = new boolean[n];
        int[] dist = new int[n];
//        Source is Zero
        dist[0] = 1;
        parent[0] = -1;
        vis[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbour : adj.get(curr)) {
                if (!vis[neighbour]) {
                    queue.add(neighbour);
                    vis[neighbour] = true;
                    parent[neighbour] = curr;
                    dist[neighbour] = dist[curr] + 1;
                    if (neighbour == destination) return dist[neighbour];
                }
            }
        }
        return -1;
    }

    private static final MessageRoute.InputReader console = new MessageRoute.InputReader();

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
