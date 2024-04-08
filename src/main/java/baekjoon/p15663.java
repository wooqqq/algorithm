package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p15663 {

    static int N, M;
    static int[] nums, ans;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        ans = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            String tmp = "";
            for (int num : ans) {
                tmp += num + " ";
            }
            sb.append(tmp);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                visited[i] = true;
                ans[depth] = nums[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
