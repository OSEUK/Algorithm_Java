package sumoong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam1 {
    static int N;
    static String S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = br.readLine().trim();

        int answer = 0;

        for (int i = 0; i < S.length(); i++){
            char c = S.charAt(i);

            if (!(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) && c != ' ') answer++;
        }
        System.out.println(answer);

    }
}
