package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	String data;
	Node left;
	Node right;

	Node() {
	}

	Node(String data) {
		this.data = data;
	}
}

public class p1991 {

	static int N;
	static Node[] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		tree = new Node[N];

		// 트리 생성
		for (int i = 0; i < N; i++) {
			tree[i] = new Node();
		}

		// 연결관계 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String parent = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();

			tree[i].data = parent;

			if (!left.equals(".")) {
				tree[i].left = new Node(left);
			} else {
				tree[i].left = null;
			}
			
			if (!right.equals(".")) {
				tree[i].right = new Node(right);
			} else {
				tree[i].right = null;
			}
		}
		
		// 자식 연결
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (tree[i].left == null && tree[i].right == null) continue;
				
				if (tree[i].left != null && tree[i].left.data.equals(tree[j].data)) {
					tree[i].left = tree[j];
				} else if (tree[i].right != null && tree[i].right.data.equals(tree[j].data)) {
					tree[i].right = tree[j];
				}
			}
		}

		sb = new StringBuilder();
		preorder(tree[0]);
		System.out.println(sb);

		sb = new StringBuilder();
		inorder(tree[0]);
		System.out.println(sb);
		
		sb = new StringBuilder();
		postorder(tree[0]);
		System.out.println(sb);
	}

	private static void preorder(Node node) {
		if (node == null) return;

		sb.append(node.data);
		preorder(node.left);
		preorder(node.right);
	}
	
	private static void inorder(Node node) {
		if (node == null) return;
		
		inorder(node.left);
		sb.append(node.data);
		inorder(node.right);
	}
	
	private static void postorder(Node node) {
		if (node == null) return;
		
		postorder(node.left);
		postorder(node.right);
		sb.append(node.data);
	}

}
