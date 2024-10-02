/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 인구 이동
 * 문제 번호 : 16234
 * 난이도 : GOLD IV
 */
package baekjoon.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BOJ16234 {
    private final static int[] dx = {1, 0, -1, 0};
    private final static int[] dy = {0, 1, 0, -1};

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;

    public static boolean isRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static boolean canMove(int x, int y, int nx, int ny){
        int num = Math.abs(map[x][y] - map[nx][ny]);
        return num >= L && num <= R;
    }
    public static boolean bfs(int x, int y){
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Pair> union = new ArrayList<>();
        q.add(new Pair(x, y));
        union.add(new Pair(x, y));
        visited[x][y] = true;
        int totalCount = map[x][y];

        while (!q.isEmpty()){
            Pair p = q.poll();

            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (isRange(nx, ny) && !visited[nx][ny] && canMove(p.x, p.y, nx, ny)){
                    q.add(new Pair(nx, ny));
                    union.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    totalCount += map[nx][ny];
                }
            }
        }

        if (union.size() == 1){
            return false;
        } else {
            int avg = totalCount / union.size();
            for (Pair p : union){
                map[p.x][p.y] = avg;
            }
            return true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true){
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if (!visited[i][j]){
                        if (bfs(i, j)) moved = true;
                    }
                }
            }

            if (!moved) break;

            days++;
        }

        System.out.println(days);


    }
}
