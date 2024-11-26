package swea.d4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SW3124 {
    static int V, E;
    static int[] parent;

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static int find(int x){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            V = sc.nextInt();
            E = sc.nextInt();

            parent = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                parent[i] = i;
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < V; i++){
                int from = sc.nextInt();
                int to = sc.nextInt();
                int weight = sc.nextInt();

                pq.offer(new Edge(from, to, weight));
            }

            long result = 0;
            int count = 0;

            while (!pq.isEmpty()){
                Edge curr = pq.poll();

                if (find(curr.from) != find(curr.to)){
                    union(curr.from, curr.to);
                    result += curr.weight;
                    count++;
                }

                if (count == V - 1) break;
            }

            System.out.println("#" + test_case + " " + result);



        }
    }
}
