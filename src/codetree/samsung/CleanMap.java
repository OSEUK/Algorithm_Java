/**
 * CODE TREE 삼성 SW 역량테스트
 * 2020 하반기 오후 1번 문제
 * 문제 이름 : 청소는 즐거워
 * 난이도 : GOLD III
 */
package codetree.samsung;

import java.util.*;
import java.io.*;

public class CleanMap {
    static int n;
    static int[][] map;
    static long Answer = 0L;
    static int remaining = 0;

    // 좌 하 우 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};


    // 범위검사
    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void calculate(int x, int y, int number, int percent){
        int durt = (int)((double)number * ((double)percent / 100.0));
        if (!inRange(x, y)){
            Answer += durt;
        } else {
            map[x][y] += durt;
        }

        remaining -= durt;
    }

    public static void move(int x, int y, int dir){
        int number = map[x][y];
        remaining = number;
        map[x][y] = 0;

        int i = dir;
        int nx = x + 2 * dx[i];
        int ny = y + 2 * dy[i];
        calculate(nx, ny, number, 5);

        nx = x + dx[dir];
        ny = y + dy[dir];

        i = (i + 1) % 4;

        nx = nx + dx[i];
        ny = ny + dy[i];
        calculate(nx, ny, number, 10);

        nx = nx - 2 * dx[i];
        ny = ny - 2 * dy[i];
        calculate(nx, ny, number, 10);

        nx = x + dx[i];
        ny = y + dy[i];
        calculate(nx, ny, number, 7);

        nx = x - dx[i];
        ny = y - dy[i];
        calculate(nx, ny, number, 7);

        nx = x + 2 * dx[i];
        ny = y + 2 * dy[i];
        calculate(nx, ny, number, 2);

        nx = x - 2 * dx[i];
        ny = y - 2 * dy[i];
        calculate(nx, ny, number, 2);

        i = (i + 1) % 4;

        nx = x + dx[i];
        ny = y + dy[i];

        i = (i + 1) % 4;
        nx = nx + dx[i];
        ny = ny + dy[i];
        calculate(nx, ny, number, 1);

        nx = nx - 2 * dx[i];
        ny = ny - 2 * dy[i];
        calculate(nx, ny, number, 1);

        i = (i + 1) % 4;
        nx = x + dx[i];
        ny = y + dy[i];

        if (!inRange(nx, ny)){
            Answer += remaining;
        } else {
            map[nx][ny] += remaining;
        }

    }
    // 실행
    public static void simulate(){
        int x = n / 2, y = n / 2;

        int i = 0;
        int addMove = 1;
        int cnt = 0;
        int cntcnt = 0;

        int nx = x;
        int ny = y;
        while (true){
            // 다음 위치 지정
            nx = nx + dx[i];
            ny = ny + dy[i];

            // 움직임 + 청소
            move(nx, ny, i);

            // 0, 0 도착 시 종료
            if(nx == 0 && ny == 0) break;

            cnt++;
            if (cnt == addMove){
                i = (i + 1) % 4;
                cnt = 0;
                cntcnt++;
            }

            if (cntcnt == 2){
                cntcnt = 0;
                addMove++;
            }
        }
    }

    // 입출력
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate();

        System.out.println(Answer);
    }
}
