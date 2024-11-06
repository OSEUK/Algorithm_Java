/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 경사로
 * 문제 번호 : 14890
 * 난이도 : GOLD III
 */

package baekjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14890 {
    static int N, L;
    static int[][] map;

    private static boolean inRange(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }
    private static int simulate(){
        int answer = 0;
        // 가로 검사 1번
        for (int row = 0; row < N; row++){
            boolean[] used = new boolean[N];
            boolean canGo = true;
            for (int col = 1; col < N; col++){
                int curr = map[row][col];
                int prev = map[row][col-1];
                // 같으면 continue;
                if (curr == prev) continue;
                // 오르막길 검사
                if (curr - prev == 1){
                    for (int i = 1; i <= L; i++){
                        if (!inRange(row, col - i) || prev != map[row][col - i] || used[col - i] ) {
                            canGo = false;
                            break;
                        }
                        used[col - i] = true;
                    }
                    continue;
                }
                // 내리막길 검사
                if (curr - prev == -1){
                    for (int i = 0; i < L; i++){
                        if (!inRange(row, col + i) || curr != map[row][col + i] || used[col + i]){
                            canGo = false;
                            break;
                        }
                        used[col + i] = true;
                    }

                    continue;
                }

                // 세 가지 경우가 아니라면 경사 차이가 더 많이 나므로 놓지 못함.
                canGo = false;
            }
            if (canGo) answer++;
        }
        // 세로 검사 1번
        for (int col = 0; col < N; col++){
            boolean[] used = new boolean[N];
            boolean canGo = true;
            for (int row = 1; row < N; row++){
                int curr = map[row][col];
                int prev = map[row - 1][col];
                // 같으면 continue;
                if (curr == prev) continue;
                // 오르막길 검사
                if (curr - prev == 1){
                    for (int i = 1; i <= L; i++){
                        if (!inRange(row - i, col) || prev != map[row - i][col] || used[row - i] ) {
                            canGo = false;
                            break;
                        }
                        used[row - i] = true;
                    }

                    continue;
                }
                // 내리막길 검사
                if (curr - prev == -1){
                    for (int i = 0; i < L; i++){
                        if (!inRange(row + i, col) || curr != map[row + i][col] || used[row + i]){
                            canGo = false;
                            break;
                        }
                        used[row + i] = true;
                    }

                    continue;
                }
                canGo = false;
            }
            if (canGo) answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(simulate());
    }
}
