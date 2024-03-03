package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4698 {

    static int D, A, B, cnt;
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb = new StringBuilder();
            sb.append("#").append(t + " ");

            st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            cnt = 0;
            isNotPrime = new boolean[B + 1];
            isNotPrime[0] = isNotPrime[1] = true;

            for (int i = 2; i * i <= B; i++) {
                if (!isNotPrime[i]) {
                    for (int j = i * i; j <= B; j += i) {
                        isNotPrime[j] = true;
                    }
                }
            }

            for (int i = Math.max(2, A); i <= B; i++) {
                if (!isNotPrime[i] && String.valueOf(i).contains(String.valueOf(D))) {
                    cnt++;
                }
            }

            sb.append(cnt);
            System.out.println(sb);
        }
    }
}
