// 프로그래머스 3xN 타일링
package programmers.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiling {
    private static final int MOD = 1000000007;
    public int solution(int n) {
        if (n % 2 != 0)
            return 0;

        long[] dp = new long[n / 2 + 1];
        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i <= n / 2; i++ ){
            dp[i] = (dp[i-1] * 3) % MOD;
            for (int j = i - 2; j >= 0; j--){
                dp[i] = (dp[i] + 2*dp[j]) % MOD;
            }
        }
        return (int)dp[n/2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Tiling sol = new Tiling();
        System.out.println(sol.solution(n));
    }
}
