package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11725_2 {

	static int N;
	static int[][] arr;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 정점 개수
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		visited = new int[N + 1];

		// 노드 간 관계 연결
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		dfs(1);
		
		// 출력
		for (int i = 2; i <= N; i++) {
			for (int c = 1; c <= N; c++) {
				if (arr[c][i] == 2) {
					sb.append(c + "\n");
				}
			}
		}
		System.out.println(sb);
	}
	
	private static void dfs(int node) {
		visited[node] = 1;
		
		for (int next = 1; next <= N; next++) {
			if (visited[next] == 1 || arr[node][next] == 0) {
				continue;
			} else {
				arr[node][next] = 2;
				dfs(next);
			}
		}
	}

}
