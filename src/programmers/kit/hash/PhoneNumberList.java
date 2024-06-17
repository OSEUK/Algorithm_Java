package programmers.kit.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PhoneNumberList {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++){
            if (phone_book[i].startsWith(phone_book[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] phone_book = br.readLine().split(" ");

        System.out.println(solution(phone_book));
    }
}
