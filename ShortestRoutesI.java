//package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

class Pair implements Comparable<Pair> {
    int v;
    long weight;
    public Pair(int v, long weight) {
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair pair2) {
        if (this.weight > pair2.weight) return 1;
        else if (this.weight < pair2.weight) return -1;
        else return 0;
    }
}

public class ShortestRoutesI {
    private static final ShortestRoutesI.InputReader console = new InputReader();
    public static List<List<Pair>> adj;
    public static void main(String[] args) throws IOException {
        int n = console.nextInt();
        int m = console.nextInt();
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int s = console.nextInt() - 1;
            int d = console.nextInt() - 1;
            long weight = console.nextInt();
            adj.get(s).add(new Pair(d, weight));
        }
        doBFSUsingDijkstra(adj, n);

    }
    public static void doBFSUsingDijkstra(List<List<Pair>> adj, int n) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0L;
        PriorityQueue<Pair> qp = new PriorityQueue<>();
        qp.add(new Pair(0, 0));
        while (!qp.isEmpty()) {
            Pair curr = qp.poll();

            if (curr.weight > dist[curr.v])
                continue;

            for (Pair pair: adj.get(curr.v)) {
                if (dist[curr.v] + pair.weight < dist[pair.v]) {
                    dist[pair.v] = curr.weight + pair.weight;
                    qp.add(new Pair(pair.v, dist[pair.v]));
                }

            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
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







