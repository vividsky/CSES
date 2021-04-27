package com.company;

import java.io.DataInputStream;
import java.io.IOException;

public final class FerrisAnkush {

    public static void main(final String[] args) throws IOException {
        final InputReader console = new InputReader();
        final int n = console.nextInt(), weight = console.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = console.nextInt();
        }
        mergeSort(arr, 0, n - 1);

        int i = 0, j = n - 1, count = 0;
        while (i <= j) {
            if (arr[i] + arr[j] <= weight) {
                i++;
            }
            count++;
            j--;
        }
        System.out.println(count);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            final int mid = (low + high) >> 1;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid + 1, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int i = low, j = mid, k = 0;
        int[] temp = new int[high - low + 1];
        while (i < mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i < mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        k = 0;
        for (int iter = low; iter <= high; iter++) {
            arr[iter] = temp[k++];
        }
    }

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
