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

		public Shark(int x, int y, int dir,int ate) {
			this.dir = dir;
			this.x = x;
			this.y = y;
			this.ate = ate;
		}
	}

	static int dx[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dy[] = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static String direct[] = {"", "↑", "2", "←", "4", "↓", "6 ", "→","8" };
	static Point map[][];
	static Shark shark;
	static int cnt = 0;
	static int ans = 0;
	static boolean[] alive = new boolean[17];

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
					shark = new Shark(i, j, b, a);
					map[i][j] = new Point(0, 0);
					alive[a] = true;
				}
			}
		}

		MoveShark(shark.x, shark.y, shark.dir, shark.ate);

		System.out.println(ans);
	}

	public static void MoveFish(int x, int y) {// x,y 는 상어 위취 좌표
		for (int num = 1; num <= 16; num++) {
			boolean flag = false;
			if (alive[num])
				continue;
			for (int i = 0; i < 4; i++) {
				if (flag)
					break;
				for (int j = 0; j < 4; j++) {
					if (map[i][j].x == num) {//해당 번호
						int tx = i + dx[map[i][j].y];
						int ty = j + dy[map[i][j].y];
						int c = 1;
						if ((tx < 0 || 4 <= tx || ty < 0 || 4 <= ty) || (tx == x && ty == y)) {//이동 불가일 경우 각도 변경
							for (int k = map[i][j].y + 1; c <= 8; c++, k++) {
								if (k == 9)
									k = 1;
								
								tx = i + dx[k];
								ty = j + dy[k];
								if (tx < 0 || 4 <= tx || ty < 0 || 4 <= ty)// 경계 벗어남
									continue;
								else if (tx == x && ty == y)// 상어
									continue;
								else {
									map[i][j].y = k;//이 각도 된다!
									break;
								}
							}
						}
						if (c != 8) {// 들어갈 곳 있음
							swap(i, j, tx, ty);
							//print();
							flag = true;
							break;
						}
					}
				}
			}
		}
	}

	public static void MoveShark(int x, int y, int dir, int sum) {
		ans = Math.max(sum, ans);
		Point copymap[][] = new Point[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
			copymap[i][j]= map[i][j];
			}
		}
		///////////////////// 생선이동/////////////////////
		MoveFish(x, y);
		print();
		System.out.println("=====================" + sum + "=======================");
		///////////////////// 상어이동/////////////////////
		for (int i = 1; i <= 3; i++) {//최대 3번째까지 이동 가능
			int tx = x + dx[dir] * i;
			int ty = y + dy[dir] * i;
			if (tx < 0 || 4 <= tx || ty < 0 || 4 <= ty)// 범위 벗어남
				break;
			if (map[tx][ty].x == 0)//물고기 없음
				continue;
			
			int tnum = map[tx][ty].x;//번호
			int tdir = map[tx][ty].y;//방향
			alive[tnum] = true;//물고기 먹음
			map[tx][ty].x = 0;//물고기 없으니까 0
			map[tx][ty].y = 0;//방향 0
			MoveShark(tx, ty, tdir, sum + tnum);
			
			alive[tnum] = false;//물고기 살려
			map[tx][ty].x = tnum;
			map[tx][ty].y = tdir;
		}
		
		for (int i = 0; i < 4; i++) {//물고기 방향이랑 위치를 원위치 바뀌기전으로
			for (int j = 0; j < 4; j++) {
			map[i][j]= copymap[i][j];
			}
		}
		
	}

	public static void swap(int x1, int y1, int x2, int y2) {
		cnt++;
		Point temp = new Point();
		temp = map[x1][y1];
		map[x1][y1] = map[x2][y2];
		map[x2][y2] = temp;
	}
	
	public static void print() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(map[i][j].x + " " + direct[map[i][j].y] + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
