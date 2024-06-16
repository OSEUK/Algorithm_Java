package programmers.kit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gymuniform {
    public static int solution(int n, int[] lost, int[] reserve) {
        int[] count = new int[n+1];

        // count 초기화
        for (int i = 0; i <= n; i++)
            count[i] = 1;
        for (int l : lost)
            count[l] -= 1;
        for (int r : reserve)
            count[r] += 1;

        // Greedy
        for(int i = 1; i <= n; i++){
            if (count[i] == 0 && count[i-1] == 2){
                count[i] += 1;
                count[i-1] -= 1;
            }
            if (count[i] == 2 && count[i-1] == 0) {
                count[i] -= 1;
                count[i - 1] += 1;
            }
        }

        // 체육복 입고있는 수 계산
        int answer = 0;
        for (int cnt : count) {
            if (cnt >= 1)
                answer += 1;
        }

        // 값이 1인 0번 인덱스도 방문하기 때문에 -1
        return answer-1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int lostsize = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] lost = new int[lostsize];
        int i = 0;
        for (String str : strs) {
            lost[i++] = Integer.parseInt(str);
        }

        int rsize = Integer.parseInt(br.readLine());
        strs = br.readLine().split(" ");
        int[] reserve = new int[rsize];
        i = 0;
        for (String str : strs) {
            reserve[i++] = Integer.parseInt(str);
        }

        System.out.println(solution(n, lost, reserve));
    }
}
