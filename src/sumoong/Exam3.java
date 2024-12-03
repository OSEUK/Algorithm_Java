package sumoong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam3 {
    static int N, K;
    static List<Pair> list = new ArrayList<>();

    static class Pair implements Comparable<Pair> {
        String name;
        int num;

        public Pair(String name, int num) {
            this.name = name;
            this.num = num;
        }

        @Override
        public int compareTo(Pair o) {
            return num - o.num;
        }
    }
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Pair(name, x));
            list.add(new Pair(name, y));
        }

        Collections.sort(list);

        int idx = K % (2 * N);
        System.out.println(list.get(idx - 1).name);





    }
}
