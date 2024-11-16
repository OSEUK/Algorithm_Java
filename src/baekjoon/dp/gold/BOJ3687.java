package baekjoon.dp.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3687 {
    private static final int MAX_N = 100;
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        // 0 ~ 9 의 숫자 만들기에 필요한 성냥 개수
        int[] nums = {6,2,5,5,4,5,6,3,7,6};

        long[] dp = new long[MAX_N + 1];
        for (int i = 0; i <= 100; i++){
            dp[i] = Long.MAX_VALUE;
        }

        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;

        for (int i = 8; i <= 100; i++){
            for (int j = 0; j < 10; j++){
                if (dp[i - nums[j]] != Long.MAX_VALUE){
                    if (dp[i - nums[j]] == 0) continue;

                    dp[i] = Math.min(dp[i], dp[i-nums[j]] * 10 + j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (T-- > 0){
            int n = Integer.parseInt(br.readLine());

            // 최솟값
            sb.append(dp[n]).append(" ");

            //최댓값
            if (n % 2 == 1){
                sb.append("7");
                for (int i = 0; i < (n-3) / 2; i++){
                    sb.append("1");
                }
            } else {
                for (int i = 0; i < n/2; i++){
                    sb.append("1");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
