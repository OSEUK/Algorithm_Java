package codetree.samsung;
import java.util.*;
public class VirusCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] customers = new int[n];

        for (int i = 0; i < n; i++){
            customers[i] = sc.nextInt();
        }

        int l = sc.nextInt();
        int m = sc.nextInt();

        long answer = 0L;

        for (int i = 0; i < n; i++){
            customers[i] -= l;
            answer += 1;

            if (customers[i] < 0){
                continue;
            }
            int div = customers[i] / m;
            int mod = customers[i] % m;

            if (mod > 0) answer += div + 1;
            if (mod == 0) answer += div;
        }

        System.out.println(answer);
    }
}
