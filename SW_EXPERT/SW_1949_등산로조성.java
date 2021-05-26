import java.awt.Point;
import java.io.*;
import java.util.*;

public class SW_1949_등산로조성 {
	static int N, K, res;
	static int map[][];
	static boolean visit[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int max = Integer.MIN_VALUE;
			map = new int[N][N];
			ArrayList<Point> maxi = new ArrayList();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (max < map[i][j]) {
						max = map[i][j];
						maxi.clear();// 비워
						maxi.add(new Point(i, j));// 저장
					} else if (max == map[i][j]) {
						maxi.add(new Point(i, j));
					}
				}
			}

			for (int i = 0; i < maxi.size(); i++) {
				visit = new boolean[N][N];
				DFS(maxi.get(i).x, maxi.get(i).y, 1, map[maxi.get(i).x][maxi.get(i).y], false);
			}

			System.out.println("#" + test_case + " " + res);
			res = 0;
		} // for
	}// main

	public static void DFS(int x, int y, int cnt, int height, boolean flag) {
		res = Math.max(res, cnt);

		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];

			if (tx < 0 || tx >= N || ty < 0 || ty >= N)
				continue;
			if(visit[tx][ty])
				continue;

			// 갈 수 있는 경우
			if (height > map[tx][ty]) {
				DFS(tx, ty, cnt + 1, map[tx][ty], flag);
			}

			// 갈 수 없음
			else if (!flag && map[tx][ty] - K < height) {// 파자
				DFS(tx, ty, cnt + 1, height - 1, true);
			}

		} // for

		visit[x][y] = false;

	}
}
