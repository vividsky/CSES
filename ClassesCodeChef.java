package com.company;

import java.util.*;

class ClassesCodeChef
{
    private static ArrayList<ArrayList<Integer>> adj;

    public static int BFS(boolean[] vis,int val, int[] subjects, int[] dist,int K,   int source) {
        Queue<Integer> queue = new LinkedList();
        vis[source] = true;
        dist[source] = 0;
        queue.add(source);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if(subjects[curr] > 0 && K > 0){
                val += Math.min(K,subjects[curr])*dist[curr]*2;
                int t = Math.min(K,subjects[curr]);
                K-=t;
                subjects[curr]-=t;
                //cout<<levels[ele]*2<<" ";
            }
            for (int child: adj.get(curr)) {
                if (!vis[child]) {
                    vis[child] = true;
                    queue.add(child);
                    dist[child] = dist[curr] + 1;
                }
            }
        }
        return val;
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t --> 0) {
            adj = new ArrayList<>();
            int N = input.nextInt();
            int M = input.nextInt();
            int S = input.nextInt();
            int K = input.nextInt();
            int source = 0;
            int[] dist = new int[N+1];
            boolean[] vis = new boolean[N+1];
            for (int i = 0; i < N+1; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                int s = input.nextInt();
                int d = input.nextInt();
                adj.get(s).add(d);
                adj.get(d).add(s);
            }
            int val = 0;
            int subjects[] = new int[N+1];
            for(int i = 0; i < S ;i++){
                subjects[input.nextInt()]++;
            }
            int x = BFS(vis, val,  subjects, dist, K, source);
//            ArrayList<Integer> finalDist = new ArrayList();
//            for (int i = 1; i < N + 1; i++) {
//                while (subjects[i] != 0) {
//                    finalDist.add(dist[i]);
//                    subjects[i]--;
//                }
//            }
//            Collections.sort(finalDist);
//
//            for (int i = 0; i < K; i++ ) {
//
//                val+= finalDist.get(i) * 2;
//            }
            System.out.println(x);
//            System.out.println(finalDist);
//            System.out.println(Arrays.toString(subjects));
//            System.out.println(Arrays.toString(dist));
        }
    }

}

