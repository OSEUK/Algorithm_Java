package programmers.skilltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class lv2_1 {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int sco : scoville) {
            pq.add(sco);
        }
        int count = 0;
        while (pq.size() > 1){
            if (pq.peek() >= K)
                return count;

            int first = pq.poll();
            int second = pq.poll();

            int newScoville = first + 2*second;
            count++;
            pq.add(newScoville);
        }

        if (pq.peek() >= K)
            return count;

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int K = Integer.parseInt(br.readLine());
        int[] scoville = new int[strs.length];

        for (int i = 0; i < scoville.length; i++){
            scoville[i] = Integer.parseInt(strs[i]);
        }

        System.out.println(solution(scoville, K));
    }
}
