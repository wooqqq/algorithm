package swea;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p4194_보호필름_보충 {

    static int R, C, K, minCnt;
    static int[][] orgMap, map;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
//        check() : 연속약물 개수가 K 개 이상인지 확인
//        0 -> 1 -> 2 -> 3 -> ... 행, 조합 = 부분집합 (최소값)
//        부분집합 isSelected[] 2^13
//        A/B 약물을 선택한 행에 투입해보기
//        원복을 위해 이전상태 기억할 배열 보관
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());   // 50개
        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());   // 보호필름의 두께, D 3~13
            C = Integer.parseInt(st.nextToken());   // 보호필름의 가로, W 1~20
            K = Integer.parseInt(st.nextToken());   // 합격기준, K 1~D

            orgMap = new int[R][C]; // 원본배열 배열
            map = new int[R][C];    // 작업할 배열
            for (int i = 0; i < R; i++) {
                String s = br.readLine();
                for (int j = 0, index = 0; j < C; j++, index += 2) {
                    map[i][j] = s.charAt(index) - '0'; // '0' '1'
                }
            }
            isSelected = new boolean[R];  // 선택한 행을 저장할 배열
            minCnt = Integer.MAX_VALUE;  // 성능검사를 통과할 수 있도록, 약물을 투입할 최소 횟수
            subset(0);

            sb.append("#").append(testCase).append(" ").append(minCnt).append("\n");
        } // end of for testCase

        System.out.println(sb.toString());
    } // end of main

    // 부분집합, 약품을 투입할 행을 선택
    public static void subset(int index) {
        if (index == R) { // 종료 파트, 부분집합 선택완료
            go(0, 0); // 부분집합으로 선택한 행에 약품 A/B를 투입해보기
            mapCopy(); // 맵 복사
            return;
        }

        // 재귀파트
        isSelected[index] = true; // 선택
        subset(index + 1);
        isSelected[index] = false; // 미선택
        subset(index + 1);
    }

    private static void mapCopy() {
        for (int r = 0; r < R; r++) {
            System.arraycopy(orgMap, 0, map, 0, map[r].length);
        }
    }

    // 약품 투입해서 체크, index: 현재단계, cnt: 지금까지의 약품투입 횟수
    private static void go(int index, int cnt) {
        if (index == R) { // 종료파트, 부분집합 선택완료
            if (check(map) && minCnt > cnt) { // 성능검사 통과 체크
                minCnt = cnt;
            }
            return;
        }
        if (isSelected[index]) { // 약품을 투입할 행인가?
            Arrays.fill(map[index], 0); // A 약품 투입
            go(index + 1, cnt + 1);
            Arrays.fill(map[index], 1); // B 약품 투입
            go(index + 1, cnt + 1);
        } else {
            go(index + 1, cnt);
        }
    }

    // 성능검사 통과하는지 체크, false 통과 못함 / true 통과
    private static boolean check(int[][] arr) {
        for (int c = 0; c < C; c++) {
            int pre = arr[0][c];
            int cnt = 1;
            boolean flag = false;
            for (int r = 0; r < R; r++) { // 1부터 시작
                if (pre == arr[r][c]) { // 이전 행값과 같으냐 = 연속, 카운팅
                    cnt++;
                } else { // 연속이 아니면,
                    pre = arr[r][c];
                    cnt = 1;
                }
                if (cnt == K) { // 이번열은 통과. 더이상 안봐도 됨
                    flag = true;
                    break;
                }
            }
            if (!flag) return false;
        }
        return true;
    }

} // end of class
