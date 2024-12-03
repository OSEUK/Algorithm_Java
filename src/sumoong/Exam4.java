package sumoong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam4 {
    static int N, M;
    static List<Integer> numlist = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++){
            numlist.add(i);
        }
        while (M-- > 0){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < B - A + 1; i++){
                stack.push(numlist.remove(A - 1));
            }
            while (!stack.isEmpty()){
                numlist.add(C, stack.pop());
            }
        }

        for (int i = 0; i < N; i++){
            System.out.println(numlist.get(i));
        }
    }
}
