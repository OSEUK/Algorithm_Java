package programmers.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakePrime{
    public static int solution(int[] nums) {
        int count = 0;
        int n = nums.length;

        // 3개의 숫자를 고르는 모든 조합을 확인
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 1; j++) {
                for (int k = 0; k < n; k++) {
                    // i, j, k가 서로 다른 인덱스일 경우에만 계산
                    if (i < j && j < k) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (isPrime(sum)) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    // 소수인지 확인하는 메소드
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 테스트를 위한 main 메소드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()){
            nums[i++] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(nums));  // 예제 출력: 1
    }
}
