import java.awt.Point;
import java.io.*;
import java.util.*;

public class SW_7699 {
	static int max;
	static char map[][];
	static int R, C;
	static boolean visit[];

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			max = 0;
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visit = new boolean[26];
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			visit[map[0][0] - 'A'] = true;
			dfs(0, 0, 1);

			System.out.println("#" + test_case + " " + max);
		}
	}

	public static void dfs(int x, int y, int cnt) {
		
		if(cnt > max)
			max = cnt;
		
		for (int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			if (0 <= tx && tx < R && 0 <= ty && ty < C && !visit[map[tx][ty] - 'A']) {
				visit[map[tx][ty] - 'A'] = true;
				dfs(tx, ty, cnt + 1);
				visit[map[tx][ty] - 'A'] = false;

			}

		}

	}
}
