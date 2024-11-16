package sumoong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam7 {
    static int T;
    static double R, B, M;

    private static int simulate(){
        if (B <= 0) return 0;
        int answer = 1;
        while (answer <= 1200){
            B += B * ((R / 100.0));

            B = (double)Math.round(B);
            B -= M;

            if (B <= 0) return answer;

            answer++;
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (T-- > 0){
            st = new StringTokenizer(br.readLine());
            R = Double.parseDouble(st.nextToken());
            B = Double.parseDouble(st.nextToken());
            M = Double.parseDouble(st.nextToken());

            int answer = simulate();
            if (answer == -1) System.out.println("impossible");
            else System.out.println(answer);
        }

    }
}
