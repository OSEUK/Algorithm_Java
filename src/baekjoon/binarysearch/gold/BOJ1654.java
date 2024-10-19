/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 랜선 자르기
 * 문제 번호 : 1654
 * 난이도 : SILVER II
 */

/*
    이분 탐색 문제.
    랜선의 개수 K, 필요한 랜선의 개수 N이 입력됨.
    랜선의 길이(start, end)를 바탕으로 이분 탐색을 하는 것으로 추정
    작업을 했을 때, 개수가 부족하면, 더 짧게, 개수가 넘치면 더 길게. 개수가 딱맞아도 더 길게, mid = start일때 종료.
 */
package baekjoon.binarysearch.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
    static int[] arr;
    static int N, K;
    static long answer = 0L;
    public static void binarySearch(long start, long end){
        while (start <= end) {
            long mid = (start + end) / 2;

            long count = 0L;
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }

            if (count < N) {
                end = mid - 1;
            }
            else{
                answer = mid;
                start = mid + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];
        for (int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        binarySearch(1, Integer.MAX_VALUE);

        System.out.println(answer);
    }
}
