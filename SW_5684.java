
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

class SW_5684 {
	static int N, M;
	static int map[][];
	static int result;
	static boolean visit[];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[s][e] = c;
			}

			for (int i = 1; i <= N; i++) {
				visit = new boolean[N + 1];
				dfs(i, i, 0);
			}

			System.out.println("#" + test_case + " " + (result == Integer.MAX_VALUE?-1:result));
		}
	}

	static void dfs(int start, int cur, int dist) {
		if (start == cur && visit[start] == true) {// 시작점에 다시 왔을 때
			if ( result > dist)
				result = dist;
			return;
		}
		
		if(dist > result)//없으면 제한시간 초과
			return;
		
		for (int i = 1; i <= N; i++) {
			if (map[cur][i] != 0 && visit[cur] != true) {
				visit[cur] = true;
				dfs(start, i, dist + map[cur][i]);
				visit[cur] = false;
			}

		}

	}
}