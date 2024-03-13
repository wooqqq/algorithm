package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int idx = 0;
        int num = 1;
        int[] arr = new int[N];

        // 만들어야 하는 수열 값 입력받기
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        while (idx < N) {
            if (!stack.isEmpty() && arr[idx] < stack.get(stack.size() - 1)) {
                break;
            } else if (!stack.isEmpty() && arr[idx] == stack.get(stack.size() - 1)) {
                stack.pop();
                sb.append("-").append("\n");
                idx++;
            } else {
                while (num <= N) {
                    if (arr[idx] != num) {
                        stack.push(num);
                        sb.append("+").append("\n");
                        num++;
                    } else {
                        stack.push(num);
                        sb.append("+").append("\n");
                        num++;
                        break;
                    }
                }
            }
        }

        if (idx == N) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
