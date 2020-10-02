import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_3197_백조의호수 {
	static int R, C;
	static int map[][];
	static Point swan[] = new Point[2];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static Queue<Point> water = new LinkedList();
	static Queue<Point> swanq = new LinkedList();
	static boolean visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visit = new boolean[R][C];

		int idx = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'L') {
					map[i][j] = '.';
					swan[idx++] = new Point(i, j);
				}
				
				if (map[i][j] == '.')
					water.add(new Point(i, j));

			}
		}
		swanq.add(new Point(swan[0].x,swan[0].y));
		visit[swan[0].x][swan[0].y] = true;
		
		int ans = 0;
		while (true) {
			// 만날 수 있나 확인
			if (Swan())
				break;
			// 얼음 녹이기
			Melt();
			ans++;
		}

		System.out.println(ans);
	}

	public static void Melt() {
		int size = water.size();
		for (int i = 0; i < size; i++) {
			Point p = water.poll();
			int x = p.x;
			int y = p.y;

			for (int j = 0; j < 4; j++) {
				int tx = x + dx[j];
				int ty = y + dy[j];
				if (0 <= tx && tx < R && 0 <= ty && ty < C && map[tx][ty] == 'X') {
					map[tx][ty] = '.';
					water.add(new Point(tx, ty));
				}

			}
		}

	}// Melt

	public static boolean Swan() {
		 Queue<Point> nextq = new LinkedList();
		while (!swanq.isEmpty()) {
			Point p = swanq.poll();
			int x = p.x;
			int y = p.y;

			if (x == swan[1].x && y == swan[1].y)
				return true;

			for (int j = 0; j < 4; j++) {
				int tx = x + dx[j];
				int ty = y + dy[j];
				if (0 <= tx && tx < R && 0 <= ty && ty < C && !visit[tx][ty]) {
					visit[tx][ty] = true;
					if (map[tx][ty] == '.') 
						swanq.add(new Point(tx, ty));
					else if(map[tx][ty] == 'X')
						nextq.add(new Point(tx, ty));
				}
			}
		}
		swanq = nextq;
		return false;
	}// Swan
}
