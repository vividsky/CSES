//package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
public class Exponentiation {
    public static void main(final String[] args) throws IOException {
        int n = console.nextInt();
        PrintWriter output = new PrintWriter(System.out);
        while (n-->0) {
            long a = console.nextInt();
            long b = console.nextInt();
            long val = (long) (Math.pow(a, b)%(1000000007));
            output.println(val);
        }
        output.flush();
    }


    private static final Exponentiation.InputReader console = new InputReader();

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
