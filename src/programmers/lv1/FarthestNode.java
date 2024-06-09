package programmers.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode {
    // 실행 위한 입력 코드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 문제엔 입력 안받는데 간선개수 입력받도록 설정
        int e = Integer.parseInt(br.readLine());

        int[][] vertex = new int[e][2];
        for(int i = 0; i < e; i++){
            String[] edge = br.readLine().split(" ");
            vertex[i][0] = Integer.parseInt(edge[0]);
            vertex[i][1] = Integer.parseInt(edge[1]);
        }

        FarthestNode sol = new FarthestNode();
        int result = sol.solution(n, vertex);
        System.out.println(result);
    }
    // 문제풀이 코드
    public int solution(int n, int[][] edge){

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }

        // 양방향 그래프로 설정
        for (int[] e : edge){
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return findFarthestNode(bfs(n, graph));
    }

    // 거리값으로 가장 먼 노드들의 개수 반환
    private int findFarthestNode(int[] distance){
        int maxDistance = 0;
        for (int dist : distance){
            if (dist > maxDistance){
                maxDistance = dist;
            }
        }

        int count = 0;
        for (int dist : distance){
            if (dist == maxDistance){
                count++;
            }
        }
        return count;
    }

    // 너비 우선 탐색
    private int[] bfs(int n, ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        distance[1] = 0;

        while (!q.isEmpty()){
            int num = q.poll();

            for (int next : graph.get(num)){
                if (!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    distance[next] = distance[num] + 1;
                }
            }
        }

        return distance;
    }

}
