package com.company;

import java.io.DataInputStream;
import java.io.IOException;

final class InputReader {
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

