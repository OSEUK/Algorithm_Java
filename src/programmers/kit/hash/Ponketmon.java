// 프로그래머스 lv1 폰켓몬
package programmers.kit.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Ponketmon {
    public static int solution(int[] nums) {

        HashSet<Integer> a = new HashSet<>();
        for (int num : nums) a.add(num);

        return Math.min(a.size(), nums.length / 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        int[] nums = new int[numbers.length];
        int i = 0;
        for (String number : numbers) {
            nums[i++] = Integer.parseInt(number);
        }

        System.out.println(solution(nums));
    }
}
