package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p3190 {

    static int N, K, L;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1}; // 동남서북
    static int[] dc = {1, 0, -1, 0};
    static List<int[]> snake = new ArrayList<>();
    static Map<Integer, String> turn = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // map 의 한 변의 길이
        N = Integer.parseInt(br.readLine());
        // 사과의 개수
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        // 사과의 위치 입력받아 map에 저장
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = 1;
        }

        // 뱀의 방향 변환 횟수 입력받기
        L = Integer.parseInt(br.readLine());

        // 방향 변환 HashMap인 turn에 저장
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            turn.put(x, s);
        }

        move();
    }

    private static void move() {
        // 시작 지점
        int r = 0, c = 0;
        // 시작 시간
        int time = 0;
        // 시작 방향
        int d = 0;
        // 시작 방향을 queue에 저장
        snake.add(new int[]{0, 0});

        while (true) {
            time++;

            int nr = r + dr[d];
            int nc = c + dc[d];

            if (isFinish(nr, nc)) break;

            if (map[nr][nc] == 1) {
                map[nr][nc] = 0;
                snake.add(new int[]{nr, nc});
            } else {
                snake.add(new int[]{nr, nc});
                snake.remove(0);
            }

            if (turn.containsKey(time)) {
                if (turn.get(time).equals("D")) {
                    d++;
                    if (d == 4)
                        d = 0;
                } else {
                    d--;
                    if (d == -1)
                        d = 3;
                }
            }

            r = nr;
            c = nc;
        }

        System.out.println(time);
    }

    private static boolean isFinish(int nr, int nc) {
        if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
            return true;
        }

        for (int i = 0; i < snake.size(); i++) {
            int[] t = snake.get(i);
            if (nr == t[0] && nc == t[1]) {
                return true;
            }
        }
        return false;
    }
}
