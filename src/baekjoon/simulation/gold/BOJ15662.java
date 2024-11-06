/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 톱니바퀴 (2)
 * 문제 번호 : 15662
 * 난이도 : GOLD V
 */

package baekjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15662 {
    static int T, K;
    static Gear[] gears;    // T개 보유
    static boolean[] visited;   // T개 보유

    // 톱니바퀴 클래스
    static class Gear{
        // tops[2] = 오른쪽 접점
        // tops[6] = 왼쪽 접점
        int idx;
        int[] tops;

        public Gear(int[] tops, int idx){
            this.tops = tops;
            this.idx = idx;
        }


        public void rotate(int dir){
            int nextDir = dir == 1 ? -1 : 1;    // 연쇄적으로 돌아갈 방향
            visited[idx] = true;    // 무한 반복을 막기 위해 방문 배열

            // 옆에 있는 시계들의 회전 여부를 알아내고 방향 설정
            if (checkPrevRotate(idx))
                gears[idx - 1].rotate(nextDir);
            if (checkNextRotate(idx))
                gears[idx + 1].rotate(nextDir);

            // 시계 방향으로
            if (dir == 1){
                int temp = tops[7];
                for (int i = 7; i >= 1; i-- ){
                    tops[i] = tops[i - 1];
                }
                tops[0] = temp;
                return;
            }

            // 반시계 방향으로
            int temp = tops[0];
            for (int i = 0; i < 7; i++){
                tops[i] = tops[i + 1];
            }
            tops[7] = temp;
        }

        // 상단부터 시계방향으로 입력받았으므로, tops[2] -> 오른쪽, tops[6] -> 왼쪽임.
        private boolean checkPrevRotate(int idx){
            return idx > 0 && gears[idx - 1].tops[2] != this.tops[6] && !visited[idx - 1];
        }

        private boolean checkNextRotate(int idx){
            return idx < T - 1 && gears[idx + 1].tops[6] != this.tops[2] && !visited[idx + 1];
        }

    }

    private static int simulate(BufferedReader br) throws IOException {
        int answer = 0;
        StringTokenizer st;
        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            visited = new boolean[T];

            int num = Integer.parseInt(st.nextToken()); // 톱니바퀴의 번호
            int dir = Integer.parseInt(st.nextToken()); // 돌릴 방향

            visited[num - 1] = true;
            gears[num - 1].rotate(dir);
        }

        for (int i = 0; i < T; i++){
            if (gears[i].tops[0] == 1) answer++;
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        gears = new Gear[T];

        for (int i = 0; i < T; i++){
            String s = br.readLine();
            char[] nums = s.toCharArray();

            int[] tops = new int[8];
            for (int j = 0; j < 8; j++){
                tops[j] = Integer.parseInt(String.valueOf(nums[j]));
            }

            gears[i] = new Gear(tops, i);
        }

        K = Integer.parseInt(br.readLine());

        System.out.println(simulate(br));
    }
}
