package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb = new StringBuilder();
            sb.append("#").append(t + " ");

            char[] input = br.readLine().toCharArray();

            int cnt = 0;
            int result = 0;
            for (int i = 0; i < input.length; i++) {
                int num = input[i] - '0';
                if (cnt < i) {
                    result += (i - cnt);
                    cnt += (i - cnt);
                }
                cnt += num;
            }

            sb.append(result);
            System.out.println(sb);
        }
    }
}
