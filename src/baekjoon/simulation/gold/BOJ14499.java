/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 주사위 굴리기
 * 문제 번호 : 14499
 * 난이도 : GOLD IV
 */

package baekjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {
    static int N, M, x, y, K;   // 입력 변수
    static int[][] map; // 지도
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    // static class 선언
    static class Dice{
        int top = 0;
        int bottom = 0;
        int left = 0;
        int right = 0;
        int front = 0;
        int back = 0;

        int x, y;

        public Dice(int x, int y){
            this.x = x;
            this.y = y;
        }

        public boolean move(int dir){
            int nx = this.x + dx[dir];
            int ny = this.y + dy[dir];

            if (!inRange(nx, ny)) return false;

            x = nx;
            y = ny;

            this.roll(dir);

            copyPos(x, y);

            return true;
        }
        private void copyPos(int x, int y){
            if (map[x][y] == 0) {
                map[x][y] = bottom;
                return;
            }

            bottom = map[x][y];
            map[x][y] = 0;
        }

        private void roll(int dir){
            int temp = bottom;
            switch (dir){
                case 0: // 동
                    bottom = right;
                    right = top;
                    top = left;
                    left = temp;
                    break;
                case 1: // 서
                    bottom = left;
                    left = top;
                    top = right;
                    right = temp;
                    break;
                case 2: // 남
                    bottom = back;
                    back = top;
                    top = front;
                    front = temp;
                    break;
                case 3: // 북
                    bottom = front;
                    front = top;
                    top = back;
                    back = temp;
                    break;
            }
        }
    }


    private static boolean inRange(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(x, y);
        st = new StringTokenizer(br.readLine());
        while (K-- > 0){
            int dir = Integer.parseInt(st.nextToken()) - 1;

            if (dice.move(dir)) System.out.println(dice.top);

        }
    }
}
