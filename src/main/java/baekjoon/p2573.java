package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2573 {

    static int N, M, cnt, year;
    static int[][] sea;
    static boolean[][] visited;
    static Queue<int[]> ice;
    static List<Integer> cntList;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sea = new int[N][M];
        ice = new LinkedList<>();

        // 입력 받으면서 만약 빙산에 해당한다면 큐에 저장
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                sea[r][c] = Integer.parseInt(st.nextToken());

                if (sea[r][c] != 0) ice.add(new int[]{r, c});
            }
        }



    }

    // 녹이는 과정
    private static void melt() {
        cntList = new ArrayList<>();
        visited = new boolean[N][M];

        while (!ice.isEmpty()) {
            int[] num = ice.poll();
            int x = num[0];
            int y = num[1];

            for (int d = 0; d < 4; d++) {
                int nr = x + dr[d];
                int nc = y + dc[d];

                // x, y 좌표가 0이 될 때도 체크해줘야 할듯
                if (sea[x][y] == 0) break;

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (sea[nr][nc] != 0) continue;
                sea[x][y] = sea[x][y] - 1;
            }

        }


        cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (sea[r][c] != 0) {
                    dfs(r, c);
                }
                if (cnt > 0) cntList.add(cnt);
            }
        }

    }


    // 사방탐색 하면서 이어진 빙산이 있는지 확인
    private static void dfs(int r, int c) {
        ice.add(new int[]{r, c});
        visited[r][c] = true;
        cnt++;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (visited[nr][nc] || sea[nr][nc] == 0) continue;
            dfs(nr, nc);
        }
    }


}
