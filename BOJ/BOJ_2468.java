package BOJ;
import java.awt.Point;
import java.util.*;

public class BOJ_2468 {
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static public int map[][];
	static boolean visit[][];

	static int N;
	static int max = 0, min = 101;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		int cnt = 0, res = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (max < map[i][j])
					max = map[i][j];
				if (min > map[i][j])
					min = map[i][j];
			}
		}

		for (int k = min; k <= max; k++) {
			visit = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > k && visit[i][j] == false) {
						visit[i][j] = true;
						bfs(i, j, k);
						cnt++;
					}
				}
			}
			if (cnt > res)
				res = cnt;
		}
		System.out.println(res);
	}

	static void bfs(int cx, int cy, int h) {
		int cnt = 0;
		Queue<Point> q = new LinkedList();
		q.offer(new Point(cx, cy));

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();

			for (int i = 0; i < 4; i++) {
				int tx = x + dx[i];
				int ty = y + dy[i];
				if (0 <= tx && tx < N && 0 <= ty && ty < N && visit[tx][ty] == false && map[tx][ty] > h) {
					q.offer(new Point(tx, ty));
					visit[tx][ty] = true;
				}
			}
		}
	}

}
