/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 테트로미노
 * 문제 번호 : 14500
 * 난이도 : GOLD IV.
 */
package baekjoon.dfs.gold;

import java.io.*;
import java.util.*;

public class BOJ14500 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int result = 0;
    public static void dfs(int x, int y, int depth, int sum) {
        // 길이가 4일 경우 테트로미노 완성.
        if (depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny) && !visited[nx][ny]) {
                dfs(nx, ny, depth + 1, sum + map[nx][ny]);

                // T자 모양을 위한 추가 탐색
                if (depth == 2) {
                    visited[nx][ny] = true;
                    for (int j = 0; j < 4; j++) {
                        int nnx = x + dx[j];
                        int nny = y + dy[j];
                        if (isValid(nnx, nny) && !visited[nnx][nny]) {
                            result = Math.max(result, sum + map[nx][ny] + map[nnx][nny]);
                        }
                    }
                    visited[nx][ny] = false;
                }
            }
        }

        visited[x][y] = false;
    }

    public static boolean isValid(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map  = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                dfs(i, j, 1, map[i][j]);
            }
        }

        System.out.println(result);
    }
}
