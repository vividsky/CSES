package com.company;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class BuildingRoads {

    public static void main(final String[] args) throws IOException {
        int n = console.nextInt();
        int m = console.nextInt();
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = console.nextInt() - 1;
            int v = console.nextInt() - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int components = 0;
        List<Integer> sources = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                components++;
                doBFS(i, visited, g);
                sources.add(i + 1);
            }
        }
        PrintWriter output = new PrintWriter(System.out);
        output.println(components - 1);
        for (int i = 1; i < sources.size(); i++) {
            output.println(sources.get(0) + " " + sources.get(i));
        }
        output.flush();
    }

    private static void doBFS(int start, boolean[] visited, List<List<Integer>> g) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : g.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    private static final InputReader console = new InputReader();

    static final class InputReader {

        private final int BUFFER_SIZE = 1 << 24;

        private final DataInputStream in;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        InputReader() {
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
