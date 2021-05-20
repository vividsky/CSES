//package com.company;
import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Subordinates {
    private static List<List<Integer>> adj;
    public static void main(String[] args) throws IOException {

        int n = console.nextInt();
        adj = new ArrayList<>();
        int[] STS = new int[n];
        boolean vis[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }
        int emp = 1;
        int p = 0;
        for (int i = 0; i < n - 1; i++) {
            int s = console.nextInt() - 1;
            adj.get(emp).add(s);
            adj.get(s).add(emp);
            emp++;
        }
        DFS(STS, p, vis);
        for (int i = 0; i < STS.length; i++) {
            System.out.print(STS[i] - 1 + " ");
        }


    }
    public static int DFS(int[] STS, int p, boolean[] vis){
        int curr_size = 1;
        vis[p] = true;
        for (int child: adj.get(p)) {
            if (!vis[child]) {
                curr_size += DFS(STS, child, vis);
            }
            STS[p] = curr_size;
        }return curr_size;
    }


    private static final Subordinates.InputReader console = new InputReader();

    private static final class InputReader {

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
