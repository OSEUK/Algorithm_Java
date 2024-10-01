/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 구슬 찾기
 * 문제 번호 : 2617
 * 난이도 : GOLD IV
 */

package baekjoon.dfs.gold;

import java.util.*;
import java.io.*;
public class BOJ2617 {
    static int N, M;
    static int Answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][N + 1];

        int a, b;
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
        }

        for (int k = 1; k <= N; k++){
            for (int i = 1; i <= N; i++){
                for (int j = 1; j <= N; j++){
                    if (graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                }
            }
        }
        Answer = 0;
        int half = (N+1)/2;
        int countBigger = 0, countSmaller = 0;
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                if (graph[i][j] == 1) countBigger++;
                if (graph[j][i] == 1) countSmaller++;
            }

            if (countBigger >= half || countSmaller >= half) Answer++;

            countSmaller = 0;
            countBigger = 0;
        }

        System.out.println(Answer);
    }
}
