package programmers.kit.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class KthNumber {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int cnt = 0;
        for (int i = 0; i < commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int pos = commands[i][2];

            int[] arr = new int[end - start + 1];
            int num = 0;
            for (int j = start-1; j < end; j++){
                arr[num++] = array[j];
            }
            Arrays.sort(arr);
            answer[cnt++] = arr[pos-1];
        }

        return answer;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int[] array = new int[arr.length];
        int i = 0;
        for (String s : arr) {
            array[i++] = Integer.parseInt(s);
        }

        int arrsize = 3;
        String[][] cmds = new String[arrsize][3];
        for (int j = 0; j < arrsize; j++) {
            cmds[j] = br.readLine().split(" ");
        }
        int[][] commands = new int[arrsize][3];
        for (int j = 0; j < arrsize; j++){
            for (int k = 0; k < 3; k++){
                commands[j][k] = Integer.parseInt(cmds[j][k]);
            }
        }

        int[] result = solution(array, commands);
        for (int res : result) {
            System.out.print(res + " ");
        }

    }
}
