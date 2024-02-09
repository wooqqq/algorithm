package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1260 {

    private static int N, M, V;
    private static int[][] arr;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        visited[V] = 1;
        dfs(V);
        System.out.println();

        visited = new int[N + 1];
        bfs();

    }

    private static void dfs(int node) {
        System.out.print(node + " ");

        for (int next = 1; next <= N; next++) {
            if (visited[next] == 1 || arr[node][next] == 0) continue;

            visited[next] = 1;
            dfs(next);
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        visited[V] = 1;
        q.offer(V);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int next = 1; next <= N; next++) {
                if (visited[next] == 1 || arr[node][next] == 0) continue;
                visited[next] = 1;
                q.offer(next);
            }
        }
    }
}
