package programmers.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberBuddy {
    public String solution(String X, String Y){
        int[] countX = new int[10];
        int[] countY = new int[10];

        countNumbers(X, countX);
        countNumbers(Y, countY);

        StringBuilder common = new StringBuilder();
        for (int i = 0; i <= 9; i++){
            int commonCount = Math.min(countX[i], countY[i]);

            for (int j = 0; j < commonCount; j++){
                common.append(i);
            }
        }

        if (common.length() == 0){
            return "-1";
        }

        char[] commonArray = common.toString().toCharArray();
        Arrays.sort(commonArray);

        StringBuilder largestNumber = new StringBuilder(new String(commonArray)).reverse();

        if (largestNumber.toString().matches("0+")){
            return "0";
        }

        return largestNumber.toString();

    }

    public static void main(String[] args) throws IOException {
        NumberBuddy sol = new NumberBuddy();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String X = st.nextToken();
        String Y = st.nextToken();

        System.out.println(sol.solution(X, Y));
    }
    private void countNumbers(String X, int[] countX) {
        for (char c : X.toCharArray()){
            countX[c - '0']++;
        }
    }

}
