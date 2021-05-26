import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

	public class SW_1767 {
	static int N;
	static int map[][];
	static int ans;
	static ArrayList<Point> arr;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int totalcore;
	static int maxcore = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			totalcore = 0;
			maxcore = 0;
            ans = Integer.MAX_VALUE;
            arr = new ArrayList();
            
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && i != 0 && j != 0 && i!=N-1 && j!= N-1) {
						arr.add(new Point(i, j));
						totalcore++;
					}
				}
			}

			DFS(0, 0, 0);

			System.out.println("#" + test_case + " " + ans);
		}
	}

	public static void DFS(int index, int core, int line) {

		// 최대 core 연결
		if (core + totalcore - index < maxcore)
			return;

		if (index == totalcore) {
			if (maxcore < core) {
				maxcore = core;
				ans = line;
			}
			if (maxcore == core)
				ans = Math.min(ans, line);
			return;
		}

		Point p = arr.get(index);
		int len = 0;
		for (int d = 0; d < 4; d++) {
			len = Check(p, d);// 연결 불가능 0, 연결 가능 양수
			if (len != 0) {// 연결 가능하면
				// 연결
				Setline(p, d, len, 2);
				// 재귀
				DFS(index + 1, core + 1, line + len);
				// 연결해제
				Setline(p, d, len, 0);
			}
		}
		DFS(index + 1, core, line);
	}

	public static int Check(Point p, int d) {
		int tx = p.x;
		int ty = p.y;
		int cnt = 0;
		boolean flag = true;
		while (true) {
			tx += dx[d];
			ty += dy[d];
			if (tx < 0 || tx >= N || ty < 0 || ty >= N)
				break;
			if (map[tx][ty] != 0) {
				flag = false;
				break;
			}
			cnt++;
		}
		if (!flag)
			cnt = 0;
		return cnt;
	}

	public static void Setline(Point p, int d, int len, int onf) {// 전선 연결 or 제거
		int tx = p.x;
		int ty = p.y;
		for (int i = 0; i < len; i++) {
			tx += dx[d];
			ty += dy[d];
			map[tx][ty] = onf;
		}
	}
}
