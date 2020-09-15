import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_16234 {
	static int N, L, R;
	static int map[][];
	static int visit[][];
	static int ans = 0;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int sum = 0;
	static int cnt = 0;
	static Queue<Point> q2 = new LinkedList();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int flag = N*N;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			flag = N*N;
			visit = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum = 0;
					cnt = 0;
					if (visit[i][j] == 0) {
						BFS(i, j);
						if (cnt != 1) {
							flag--;
						}
						while (!q2.isEmpty()) {
							Point p = q2.poll();
							map[p.x][p.y] = sum / cnt;
						}
					}
				}
			}
			if(flag == N*N)
				break;
			ans++;
		}
		System.out.println(ans);
	}

	static public void BFS(int x, int y) {
		Queue<Point> q = new LinkedList();
		q.add(new Point(x, y));
		visit[x][y] = 1;
		sum += map[x][y];
		cnt++;
		while (!q.isEmpty()) {
			Point p = q.poll();
			x = p.x;
			y = p.y;
			q2.add(new Point(x, y));

			for (int i = 0; i < 4; i++) {
				int tx = x + dx[i];
				int ty = y + dy[i];
				if (tx < 0 || N <= tx || ty < 0 || N <= ty)
					continue;
				if (visit[tx][ty] != 0)
					continue;
				if (Math.abs(map[x][y] - map[tx][ty]) > R || Math.abs(map[x][y] - map[tx][ty]) < L)
					continue;

				visit[tx][ty] = 1;
				sum += map[tx][ty];
				cnt++;
				q.add(new Point(tx, ty));
			}
		}

	}
}
