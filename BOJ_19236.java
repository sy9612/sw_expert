import java.awt.Point;
import java.io.*;
import java.util.*;
 
public class BOJ_19236 {
	public static class Shark {
		int dir;
		int x;
		int y;
		int ate;

		public Shark() {
		}

		public Shark(int x, int y, int dir, int ate) {
			this.dir = dir;
			this.x = x;
			this.y = y;
			this.ate = ate;
		}
	}

	static int dx[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dy[] = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static Point map[][];
	static Shark shark;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new Point[4][4];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[i][j] = new Point(a, b);
				if (i == 0 && j == 0) {
					shark = new Shark(i, j, a, b);
				}
			}
		}

		while (true) {
			MoveFish(shark.x, shark.y);
			if (!MoveShark())
				break;
		}

		System.out.println(shark.ate);
	}

	public static void MoveFish(int x, int y) {// x,y 는 상어 위취 좌표
		for (int num = 1; num <= 16; num++) {
			boolean flag = false;
			if (num == shark.dir)
				continue;
			for (int i = 0; i < 4; i++) {
				if (flag)
					break;
				for (int j = 0; j < 4; j++) {
					if (map[i][j].x == num) {
						int tx = i + dx[map[i][j].y];
						int ty = j + dy[map[i][j].y];
						int c = 1;
						if ((tx < 0 || 4 <= tx || ty < 0 || 4 <= ty) || (tx == x && ty == y)) {// 경계 벗어남
							for (int k = map[i][j].y + 1; c <= 8; c++, k++) {
								if (k % 9 == 0) {
									k %= 9;
									k += 1;
								}
								tx = i + dx[k];
								ty = j + dy[k];
								if (tx < 0 || 4 <= tx || ty < 0 || 4 <= ty)// 경계 벗어남
									continue;
								else if (tx == x && ty == y)// 상어
									continue;
								else {
									map[i][j].y = k;
									break;
								}
							}
						}
						if (c != 8) {// 들어갈 곳 있음
							swap(i, j, tx, ty);
							flag = true;
							break;
						}
					}
				}
			}
		}
	}

	public static boolean MoveShark() {
		int i = 1;
		boolean flag = false;
		while (true) {
			int tx = shark.x + dx[shark.dir] * i;
			int ty = shark.y + dy[shark.dir] * i;
			if (tx < 0 || 4 <= tx || ty < 0 || 4 <= ty)
				break;
			
			flag = true;
		}
		
		if (flag)
			return false;
		else
			return true;
	}

	public static void swap(int x1, int y1, int x2, int y2) {
		cnt++;
		Point temp = new Point();
		temp = map[x1][y1];
		map[x1][y1] = map[x2][y2];
		map[x2][y2] = temp;
	}
}
