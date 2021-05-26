import java.awt.*;
import java.io.*;
import java.util.*;

//지하 터널 지도의 세로 크기 N, 가로 크기 M
//맨홀 뚜껑이 위치한장소의 세로 위치 R, 가로 위치 C
//탈출 후 소요된 시간 L 
public class SW_1953_탈주범검거 {
	static int map[][];
	static boolean visit[][];
	static int N, M, R, C, L;
	static int res;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int num[][] = { { 0 }, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 3 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visit = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Solve();

			System.out.println("#" + test_case + " " + res);
		}
	}// main

	public static void Solve() {
		Queue<Point> q = new LinkedList();
		q.add(new Point(R, C));
		visit[R][C] = true;
		res++;
		int cnt = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			if (cnt == L)
				break;
			for (int k = 0; k < size; k++) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				for (int i = 0; i < num[map[x][y]].length; i++) {

					int tx = x + dx[num[map[x][y]][i]];
					int ty = y + dy[num[map[x][y]][i]];

					if (tx < 0 || tx >= N || ty < 0 || ty >= M)
						continue;
					if (visit[tx][ty])
						continue;
					boolean flag = false;
					for (int h = 0; h < num[map[tx][ty]].length; h++) {
						if (Math.abs(num[map[x][y]][i] - num[map[tx][ty]][h]) == 2) {
							flag = true;
							break;
						}
					}
					if (!flag)
						continue;
					if (map[tx][ty] != 0) {
						visit[tx][ty] = true;
						res++;
						q.add(new Point(tx, ty));
					}
				}
			} // for-size
			cnt++;
		} // while

	}// Solve

}
