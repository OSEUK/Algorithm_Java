/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 나락도 락이다
 * 문제 번호 : 26156
 * 난이도 : GOLD III
 */

package baekjoon.dynamicprogramming.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ26156 {
    private static final int MOD = 100000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        long count_R = 0;
        long count_RO = 0;
        long count_ROC = 0;
        long count_ROCK = 0;

        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);

            if (c == 'R') {
                count_R = (count_R * 2 + 1) % MOD;
            } else if (c == 'O') {
                count_RO = (count_RO * 2 + count_R) % MOD;
            } else if (c == 'C') {
                count_ROC = (count_ROC * 2 + count_RO) % MOD;
            } else if (c == 'K') {
                count_ROCK = (count_ROCK * 2 + count_ROC) % MOD;
            }
        }

        System.out.println(count_ROCK);
    }
}
