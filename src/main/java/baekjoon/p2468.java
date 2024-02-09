package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2468 {

    private static int N, rain, maxHeight, cnt, maxCnt;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        maxCnt = Integer.MIN_VALUE;
        maxHeight = 0;

        // 배열 입력받기
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                // 배열 입력받으면서 최대 높이 확인하기
                // 비가 오는 경우는 최대 높이 이상 확인해볼 필요 X
                if (map[r][c] > maxHeight) {
                    maxHeight = map[r][c];
                }
            }
        }

        for (rain = 0; rain < maxHeight; rain++) {
            visited = new boolean[N + 1][N + 1];
            cnt = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (visited[r][c] == false && map[r][c] > rain) {
                        dfs(r, c);
                        cnt++;
                    }
                }
            }

            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.println(maxCnt);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (visited[nr][nc] == true || map[nr][nc] <= rain) continue;
            dfs(nr, nc);
        }
    }
}