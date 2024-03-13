package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2477 {

    static int N, width, height, minusWidth, minusHeight, ground;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[5];
        width = Integer.MIN_VALUE;
        height = Integer.MIN_VALUE;

        // 육각형 모양의 밭이므로 6번만 읽어오면 된다
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());

            int way = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (map[way] != 0) {
                if (cnt == 0) {
                    minusWidth = dist;
                    cnt++;
                } else {
                    minusHeight = map[way];
                }
            } else {
                map[way] = dist;
                if (way == 3 || way == 4) {
                    height = Math.max(height, dist);
                } else {
                    width = Math.max(width, dist);
                }
            }
        }
        // 넓이 계산
        ground = (width * height) - (minusWidth * minusHeight);
        System.out.println(ground * N);
    }
}
