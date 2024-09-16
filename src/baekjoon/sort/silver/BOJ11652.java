/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 카드
 * 문제 번호 : 11652
 * 난이도 : SILVER IV
 */

package baekjoon.sort.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> cards = new HashMap<>(); // String 대신 Long 사용

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine()); // 입력 값을 long으로 파싱

            cards.put(num, cards.getOrDefault(num, 0) + 1); // getOrDefault 사용하여 간결하게 처리
        }

        long result = 0;
        int maxCount = -1;

        // 가장 많이 등장한 수 중 작은 수 찾기
        for (Map.Entry<Long, Integer> entry : cards.entrySet()) {
            long cardNum = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && cardNum < result)) {
                maxCount = count;
                result = cardNum;
            }
        }

        System.out.println(result);
    }
}

