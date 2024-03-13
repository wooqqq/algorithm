package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4047 {

    static boolean[][] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb = new StringBuilder();
            sb.append("#").append(t + " ");

            cards = new boolean[4][13];

            String[] input = br.readLine().split("");

            int sCnt = 13, dCnt = 13, hCnt = 13, cCnt = 13;
            int idx = 0;
            check: while (idx < input.length) {
                String shape = input[idx];
                int num = Integer.parseInt(input[idx + 1]) * 10 + Integer.parseInt(input[idx + 2]);

                switch (shape) {
                    case "S":
                        if (cards[0][num - 1] == true) {
                            sb.append("ERROR");
                            break check;
                        }
                        cards[0][num - 1] = true;
                        sCnt--;
                        break;
                    case "D":
                        if (cards[1][num - 1] == true) {
                            sb.append("ERROR");
                            break check;
                        }
                        cards[1][num - 1] = true;
                        dCnt--;
                        break;
                    case "H":
                        if (cards[2][num - 1] == true) {
                            sb.append("ERROR");
                            break check;
                        }
                        cards[2][num - 1] = true;
                        hCnt--;
                        break;
                    case "C":
                        if (cards[3][num - 1] == true) {
                            sb.append("ERROR");
                            break check;
                        }
                        cards[3][num - 1] = true;
                        cCnt--;
                        break;
                }

                idx += 3;
            }

            if (idx != input.length) {
                System.out.println(sb);
            } else {
                sb.append(sCnt + " " + dCnt + " " + hCnt + " " + cCnt);
                System.out.println(sb);
            }
        }
    }
}
