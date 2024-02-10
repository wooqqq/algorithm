package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p2667 {

    private static int N, cnt, villageCnt;
    private static int[][] map;
    private static List<Integer> cntList;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        cntList = new ArrayList<>();

        // 지도 입력
        for (int r = 0; r < N; r++) {
            String[] input = br.readLine().split("");
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(input[c]);
            }
        }

        villageCnt = 0;

        // 탐색
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                cnt = 0;
                if (map[r][c] == 1 && visited[r][c] == false) {
                    dfs(r, c);
                    villageCnt++;
                }
                if (cnt > 0)
                    cntList.add(cnt);
            }
        }

        Collections.sort(cntList);
        System.out.println(villageCnt);
        for (int i = 0; i < cntList.size(); i++) {
            System.out.println(cntList.get(i));
        }
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (visited[nr][nc] == true || map[nr][nc] == 0) continue;
            dfs(nr, nc);
        }
    }
}
