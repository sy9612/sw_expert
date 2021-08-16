import java.io.*;
import java.util.*;

public class BOJ_1922_네트워크연결 {
	static int N, M;
	static int parent[];

	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		int cost;

		Edge(int v1, int v2, int cost) {
			this.cost = cost;
			this.v1 = v1;
			this.v2 = v2;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws Exception {
		int ans = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Edge> list = new ArrayList();

		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;

		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.add(new Edge(a, b, c));
		}

		list.sort(null);

		for (int i = 0; i < list.size(); i++) {
			Edge edge = list.get(i);
			if (!findParent(edge.v1, edge.v2)) {
				ans += edge.cost;
				unionParent(edge.v1, edge.v2);
			}
		}

		System.out.println(ans);
	}// main

	// 부모 가져오기
	public static int getParent(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = getParent(parent[x]);
	}

	// 부모 합치기
	public static void unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);

		if (b > a)
			parent[b] = a;
		else
			parent[a] = b;
	}

	// 같은 부모를 가지는지 확인
	public static boolean findParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);

		if (a == b)
			return true;
		return false;
	}

}
