/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 나무 자르기
 * 문제 번호 : 2805
 * 난이도 : SILVER II
 */

/**
 * 총 M 길이 이상의 나무를 가져가야 함.
 * 총 길이가 M이 안되면, 높이를 내림.
 * 총 길이가 M 이상이면, 높이를 높임.
 * 높이를 기점으로 이분탐색
 */
package baekjoon.binarysearch.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {
    private static final int MAX_HEIGHT = 1000000000;
    static int N, M;
    static int[] trees;

    public static int cutTrees(int s, int e){
        int answer = 0;

        while (s <= e){
            int mid = (s + e) / 2;

            long sum = 0L;
            for (int i = 0; i < trees.length; i++){
                sum += Math.max(trees[i] - mid, 0);
            }

            if (sum < M) e = mid - 1;
            else {
                answer = mid;
                s = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        trees = new int[N];
        for (int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(cutTrees(1, MAX_HEIGHT));
    }
}
