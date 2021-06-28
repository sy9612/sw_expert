package BOJ;
import java.util.*;
import java.io.*;

public class BOJ_1916_최소비용구하기 {
	static int N, M;
	static boolean visit[];
	static int dist[], map[][];

	public static class Node implements Comparable<Node> {
		int num;
		int cost;

		Node() {

		}

		Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(map[i], 1000000001);
		}

			for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int charge = Integer.parseInt(st.nextToken());

			if (map[start][end] > charge)
				map[start][end] = charge;
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, 1000000001);
		dijkstra(s);

		System.out.println(dist[e]);
	}// main

	static public void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		map[start][start] = 0;
		
		while (!pq.isEmpty()) {
			Node n = pq.poll();

			for (int i = 1; i <= N; i++) {
				if (dist[i] > dist[n.num] + map[n.num][i]) {
					dist[i] = dist[n.num] + map[n.num][i];
					pq.add(new Node(i, dist[i]));
				}

			}

		}

	}

}
