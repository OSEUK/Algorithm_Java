/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 빙산
 * 문제 번호 : 2573
 * 난이도 : GOLD IV
 */

package baekjoon.bfs.gold;

import java.util.*;
import java.io.*;

class Pos{
    int x;
    int y;
    int height;

    // 빙산의 좌표와 높이를 입력할 Class 선언
    public Pos(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }
}
public class BOJ2573 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
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

        int years = 0;
        System.out.println(simulate(years));
    }


    private static int simulate(int years) {
        while (true)
        {
            int bfsCount = 0;

            visited = new boolean[N][M];
            for (int i = 1; i < N-1; i++){
                for (int j = 1; j < M - 1; j++){
                    if (!visited[i][j] && map[i][j] != 0){
                        bfsCount++; // 빙산이 다 녹아있는지와 분리되어있는지 여부 판단
                        bfs(i, j);
                    }
                }
            }

            // 분리되었다면
            if (bfsCount > 1){
                return years;
            }

            // 다 녹았다면
            if (bfsCount == 0){
                return 0;
            }

            // 1년 경과
            years++;
        }
    }

    private static void bfs(int x, int y){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, y, map[x][y]));
        visited[x][y] = true;

        while (!q.isEmpty()){
            Pos p = q.poll();

            // 해당 칸의 빙산 높이
            int nextHeight = p.height;

            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 방문했던 칸이 0이 되었을 것을 생각하여 방문 여부와 0 여부 탐색
                if (!visited[nx][ny] && map[nx][ny] == 0){
                    // 0까지만 감소
                    if (nextHeight > 0) nextHeight--;
                    continue;
                }

                // 0이 아니고 방문한 적 없다면 방문
                if (!visited[nx][ny] && map[nx][ny] != 0){
                    q.offer(new Pos(nx, ny, map[nx][ny]));
                    visited[nx][ny] = true;
                }
            }

            // 방문 완료한 해당 칸의 높이 갱신
            map[p.x][p.y] = nextHeight;

        }
    }


}
