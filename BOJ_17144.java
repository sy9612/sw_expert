import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_17144 {
	static class Node {
		int x;
		int y;
		int cnt;

		public Node() {
		}

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static ArrayList<Point> air = new ArrayList();
	static int R, C, T;
	static int A[][], copyA[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int[] ccw = { 1, 0, 3, 2 };
	static int[] cw = { 1, 2, 3, 0 };
	static int total = 0;
	static Queue<Node> q1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		A = new int[R][C];
		copyA = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				if (A[i][j] == -1)
					air.add(new Point(i, j));
			}
		}

		for (int k = 0; k < T; k++) {
			Spread();
			for (int ii = 0; ii < R; ii++) {
				for (int j = 0; j < C; j++) {
					copyA[ii][j] = A[ii][j];
				}
			}
			AirCleaner(air.get(0).x, air.get(0).y, ccw);//반시계
			AirCleaner(air.get(1).x, air.get(1).y, cw);//시계
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (A[i][j] > 0) {
					total += A[i][j];
				}
			}
		}

		System.out.println(total);
	}

	public static void AirCleaner(int cleanerX, int cleanerY, int[] direction) {
		int x = cleanerX;
		int y = cleanerY+1;
		
		A[x][y] = 0;
		for (int k = 0; k < 4; k++) {
			while (true) {
				int nx = x + dx[direction[k]];
				int ny = y + dy[direction[k]];

				if (!Range(nx, ny)) {
					break;
				}

				if (cleanerY == ny && cleanerX == nx) {
					break;
				}

				A[nx][ny] = copyA[x][y];
				x = nx;
				y = ny;
			}
		}
	}

	public static void Spread() {
		q1 = new LinkedList();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (A[i][j] != 0) {
					Node node = new Node(i, j, A[i][j]);
					q1.add(node);
				}
			}
		}
		while (!q1.isEmpty()) {
			int x = 0, y = 0, cnt = 0;
			Node node = q1.poll();
			x = node.x;
			y = node.y;
			cnt = node.cnt;

			int DiffusedDir = 0;
			for (int i = 0; i < 4; i++) {// 4방면 확인
				int tx = x + dx[i];
				int ty = y + dy[i];
				int tcnt = cnt / 5;
				if (Range(tx, ty) && A[tx][ty] != -1) {
					DiffusedDir++;
					A[tx][ty] += tcnt;
				}
			}
			A[x][y] -= (cnt / 5) * DiffusedDir;
		}
	}

	public static boolean Range(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C) {
			return true;
		}
		return false;
	}
}
