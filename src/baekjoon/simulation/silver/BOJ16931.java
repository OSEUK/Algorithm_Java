/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 겉넓이 구하기
 * 문제 번호 : 16931
 * 난이도 : SILVER II
 */

package baekjoon.simulation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16931 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(simulate());
    }

    private static int simulate(){
        int result = 2 * N * M; // 위 아래 겉넓이

        result += front_back();
        return result;
    }

    private static int front_back(){
        int[] max_i = new int[N];
        int[] max_j = new int[M];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] > max_i[i]) max_i[i] = map[i][j];
                if (map[i][j] > max_j[j]) max_j[j] = map[i][j];
            }
        }

        int result = Arrays.stream(max_i).sum();
        result += Arrays.stream(max_j).sum();

        return 2 * result;
    }


}
