import java.awt.Point;
import java.io.*;
import java.util.*;

public class SW_8382_방향전환 {
	static int x1, y1, x2, y2;
	static int ver = 0, hor = 1;

	public static class Point {
		int x, y, cnt, dir;

		Point(int x, int y, int cnt, int dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;
			
			System.out.println("#" + test_case + " " + BFS());
		} // test_case
	}// main

	public static int BFS() {
		boolean visit[][][] = new boolean[201][201][2];
		Queue<Point> q = new LinkedList();
		visit[x1][y1][ver] = true;
		q.add(new Point(x1, y1, 0, ver));
		visit[x1][y1][hor] = true;
		q.add(new Point(x1, y1, 0, hor));

		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.x == x2 && cur.y == y2) {
				return cur.cnt;
			}

			if (cur.dir == ver) {// 세로
				int tx = cur.x;
				int ty = cur.y + 1;
				if (ty <= 200 && !visit[tx][ty][hor]) {
					visit[tx][ty][hor] = true;
					q.add(new Point(tx, ty, cur.cnt + 1, hor));
				}
				tx = cur.x;
				ty = cur.y - 1;
				if (ty >= 0 && !visit[tx][ty][hor]) {
					visit[tx][ty][hor] = true;
					q.add(new Point(tx, ty, cur.cnt + 1, hor));
				}
			} else {// 가로
				int tx = cur.x - 1;
				int ty = cur.y;
				if (tx >= 0 && !visit[tx][ty][ver]) {
					visit[tx][ty][ver] = true;
					q.add(new Point(tx, ty, cur.cnt + 1, ver));
				}
				tx = cur.x + 1;
				ty = cur.y;
				if (tx <= 200 && !visit[tx][ty][ver]) {
					visit[tx][ty][ver] = true;
					q.add(new Point(tx, ty, cur.cnt + 1, ver));
				}
			}
		}
		return 0;
	}// BFS
}
