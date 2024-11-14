package baekjoon.dp.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14267 {
    static int N, M;
    static List<List<Integer>> employee;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        employee = new ArrayList<>();
        for (int i = 0; i <= N; i++){
            employee.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            int boss = Integer.parseInt(st.nextToken());
            if (boss == -1) continue;
            employee.get(boss).add(i);
        }

        dp = new int[N + 1];

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dp[i] += w;
        }

        praise(1);

        Arrays.stream(dp).skip(1).forEach(n -> System.out.print(n + " "));

    }

    private static void praise(int i) {
        for (int curr : employee.get(i)){

            dp[curr] += dp[i];

            praise(curr);
        }
    }
}
