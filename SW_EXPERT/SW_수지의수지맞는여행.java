package SW_EXPERT;
import java.io.*;
import java.util.*;

public class SW_수지의수지맞는여행 {
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int R, C;
	static char[][] map;
	static int ans = 0;
	static boolean alpha[];
	static boolean visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int Test = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= Test; test_case++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			alpha = new boolean[26];
			visit = new boolean[R][C];
			alpha[map[0][0] - 'A'] = true;
			visit[0][0] = true;
			DFS(1, 0, 0);

			System.out.println("#" + test_case + " " + ans);
		} // test_case
	}// main

	static public void DFS(int cnt, int x, int y) {
		if (cnt > ans)
			ans = cnt;

		for (int k = 0; k < 4; k++) {
			int tx = x + dx[k];
			int ty = y + dy[k];

			if (tx < 0 || ty < 0 || tx >= R || ty >= C)
				continue;

			if (!visit[tx][ty] && !alpha[map[tx][ty] - 'A']) {
				visit[tx][ty] = true;
				alpha[map[tx][ty] - 'A'] = true;
				DFS(cnt + 1, tx, ty);
				visit[tx][ty] = false;
				alpha[map[tx][ty] - 'A'] = false;

			}
		}

	}// DFS
}
