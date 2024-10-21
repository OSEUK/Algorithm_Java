/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 공유기 설치
 * 문제 번호 : 2110
 * 난이도 : GOLD IV
 */

package baekjoon.binarysearch.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    private static final int MAX_DISTANCE = 1000000000; // 공유기 간 최대 거리
    static int N, C;
    static int[] houses;

    public static int getMaxDistance(int s, int e){
        int answer = 0;

        while(s <= e){
            int mid = (s + e) / 2;  // 공유기 간의 거리.
            int cnt = 1;
            int lastHouse = houses[0];
            for (int i = 1; i < N; i++){
                // 이전 공유기와의 거리가 mid 이상이면 설치.
                if (houses[i] - lastHouse >= mid){
                    cnt++;
                    lastHouse = houses[i];
                }
            }

            if (cnt >= C){
                answer = mid;
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];
        for (int i = 0; i < N; i++){
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        System.out.println(getMaxDistance(1, MAX_DISTANCE));
    }
}
