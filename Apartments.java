package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Apartments {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

//        int[] desiredSize = new int[n];
//        int[] actualSize = new int[m];
        List<Integer> desiredSize = new ArrayList<>();
        List<Integer> actualSize = new ArrayList<>();
        StringTokenizer s1 = new StringTokenizer(input.readLine());
        StringTokenizer s2 = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++)
        {
            desiredSize.add(i, Integer.parseInt(s1.nextToken()));
        }
        for(int i = 0; i < m; i++)
        {
            actualSize.add(i, Integer.parseInt(s2.nextToken()));
        }
        Collections.sort(desiredSize);
        Collections.sort(actualSize);
        int flag = 0, count = 0;
        for (int j = 0; j < m && flag < n;) {
            if (Math.abs(actualSize.get(j) - desiredSize.get(flag)) > k) {
                if (actualSize.get(j) > desiredSize.get(flag)) flag++;
                else j++;
            } else {
                count++;
                j++;
                flag++;
            }
        }
        System.out.println(count);

//        Another way to write the approach:

//        for (int i = 0,j = 0; i < n; i++){
//
//            while (j < m && (actualSize[j] < (desiredSize[i]-k))) j++;
//            if(j < m && (actualSize[j]-desiredSize[i])<=k ) {
//                count++;
//                j++;
//            }
//        }
    }
}
