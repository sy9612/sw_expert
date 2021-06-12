import java.util.*;
import java.io.*;

public class PG_49189_가장먼노드 {
	static public void main(String[] args) throws Exception {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		System.out.println(solution(n, edge));
	}// main

	public static int solution(int n, int[][] edge) {
		int answer = 0;
		int max = 0;
		int dist[] = new int[n + 1];
		boolean visit[] = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		boolean[][] map = new boolean[n + 1][n + 1];
		for (int i = 0; i < edge.length; i++) {
			map[edge[i][0]][edge[i][1]] = true;
			map[edge[i][1]][edge[i][0]] = true;

		}

		int cur = 1;
		dist[cur] = 0;
		Queue<Integer> q = new LinkedList();
		q.add(cur);
		visit[cur] = true;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 2; i <= n; i++) {
				if (map[cur][i]) {
					if (!visit[i]) {
						q.add(i);
						visit[i] = true;
					}
					if (dist[i] > dist[cur] + 1) {
						dist[i] = dist[cur] + 1;
						if(dist[i] > max)
							max = dist[i];
					}
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			if(max == dist[i])
				answer++;
		}
		return answer;
	}// solution
}
