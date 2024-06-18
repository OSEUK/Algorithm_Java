package programmers.kit.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Clothes {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> uniforms = new HashMap<>();

        for (String[] c : clothes) {
            String key = c[1];
            if (!uniforms.containsKey(key)) {
                uniforms.put(key, 1);
                continue;
            }
            uniforms.put(key, uniforms.get(key) + 1);
        }

        int n = uniforms.size();
        int answer = 1;
        for (Map.Entry<String, Integer> entry : uniforms.entrySet()) {
            answer *= (entry.getValue() + 1);
        }
        return answer - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] clothes = new String[n][];
        for (int i = 0; i < n; i++){
            clothes[i] = br.readLine().split(" ");
        }

        System.out.println(solution(clothes));
    }
}
