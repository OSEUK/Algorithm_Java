package sumoong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam2 {
    static int N, M;
    static String[] map;
    static int min_x = Integer.MAX_VALUE;
    static int min_y = Integer.MAX_VALUE;
    static int max_x = Integer.MIN_VALUE;
    static int max_y = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N];
        for (int i = 0; i < N; i++){
            map[i] = br.readLine();
        }

        boolean changed = false;
        for (int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                char curr = map[i].charAt(j);
                if (curr == 'D'){
                    changed = true;
                    if (i < min_x) min_x = i;
                    if (j < min_y) min_y = j;
                    if (i > max_x) max_x = i;
                    if (j > max_y) max_y = j;
                }
            }
        }

        if (changed) System.out.printf("%d %d %d %d", min_x, min_y, max_x + 1, max_y + 1);
        else System.out.println(0);
    }
}
