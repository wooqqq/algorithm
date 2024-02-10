package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> top = new Stack<>();
        Stack<Integer> result = new Stack<>();

        st = new StringTokenizer(br.readLine());

        // 탑의 높이를 각각 stack에 넣기
        for (int i = 0; i < N; i++) {
            top.push(Integer.parseInt(st.nextToken()));
        }

        int num = top.pop();
        for (int i = 0; i < N; i++) {
            if (top.isEmpty()) {
                while (result.size() != N) {
                    result.push(0);
                }
            } else if (num <= top.peek()) {
                while (result.size() != N - top.size()) {
                    result.push(top.size());
                }
                num = top.pop();
            } else {
                top.pop();
            }
        }

        while (!result.isEmpty()) {
            System.out.print(result.pop() + " ");
        }
    }
}
