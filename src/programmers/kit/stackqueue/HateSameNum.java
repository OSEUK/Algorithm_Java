package programmers.kit.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HateSameNum {
    public static int[] solution(int []arr) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(arr[0]);
        for (int i = 1; i < arr.length; i++){
            if (arr[i-1] == arr[i])
                continue;
            nums.add(arr[i]);
        }

        int[] answer = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++){
            answer[i] = nums.get(i);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int[] arr = new int[strings.length];
        int i = 0;
        for (String string : strings) {
            arr[i++] = Integer.parseInt(string);
        }

        int[] answer = solution(arr);
        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }

}
