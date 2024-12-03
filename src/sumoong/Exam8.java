package sumoong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exam8 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> sumoong = new PriorityQueue<>();
        PriorityQueue<Integer> stair = new PriorityQueue<>((o1, o2) -> o2 - o1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            sumoong.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            stair.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());

        while (M-- > 0){
            int n = Integer.parseInt(br.readLine());

            if (n == 1) sumoong.offer(stair.poll());
            if (n == -1) stair.offer(sumoong.poll());
        }

        System.out.printf("%d %d", sumoong.poll(), stair.poll());

    }
}
