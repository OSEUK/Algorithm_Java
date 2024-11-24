/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 드래곤 커브
 * 문제 번호 : 15685
 * 난이도 : GOLD III
 */

package baekjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15685 {
    private final static int MAX_X = 101;
    static int N;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        visited = new boolean[MAX_X][MAX_X];

        while (N-- > 0){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());


            makeDragonCurve(y, x, d, g);
        }

        System.out.println(countSquare());
    }

    private static int countSquare(){
        int count = 0;
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                if (visited[i][j] && visited[i+1][j+1] && visited[i+1][j] && visited[i][j+1]){
                    count++;
                }
            }
        }

        return count;
    }
    private static void makeDragonCurve(int x, int y, int d, int g) {
        ArrayList<Integer> directions = new ArrayList<>();

        directions.add(d);

        for (int i = 0; i < g; i++){
            int size = directions.size();

            for (int j = size - 1; j >= 0; j--){
                directions.add((directions.get(j) + 1) % 4);    // 90도 회전한 좌표
            }
        }

        visited[x][y] = true;
        for (int direction : directions){
            x += dx[direction];
            y += dy[direction];

            visited[x][y] = true;
        }
    }
}
