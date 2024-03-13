package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p7964 {

    static int N, D;
    static int[] arr, isDoor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb = new StringBuilder();
            sb.append("#").append(t + " ");

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            arr = new int[N];
            isDoor = new int[N];

            st = new StringTokenizer(br.readLine());
            int idx = -1;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == 1) {
                    isDoor[++idx] = i;
                }
            }

            isDoor = Arrays.copyOf(isDoor, idx + 1);

            int result = 0;
            int min = Integer.MAX_VALUE;

            if (isDoor.length == 0) {
                for (int i = 0; i < D; i++) {
                    int index = i;
                    int cnt = 0;
                    while (index < arr.length) {
                        cnt++;
                        index += D;
                    }
                    min = Math.min(min, cnt);
                }
                result = min;
            } else {
                for (int i = 0; i < isDoor.length; i++) {
                    if (i == 0 && isDoor[i] >= D) {
                        int first = isDoor[0];
                        while (first >= D) {
                            result++;
                            first -= D;
                        }
                    } else if (i > 0 && isDoor[i] - isDoor[i - 1] >= D) {
                        int next = isDoor[i] - isDoor[i - 1];
                        while (next > D) {
                            result++;
                            next -= D;
                        }
                    } else continue;
                }
                int next = arr.length - isDoor[isDoor.length - 1] - 1;
                while (next > D) {
                    result++;
                    next -= D;
                }
            }

            sb.append(result);
            System.out.println(sb);
        }
    }
}
