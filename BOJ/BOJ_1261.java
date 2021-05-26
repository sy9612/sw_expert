import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_1261 {
	static int N, M, result;
	static int arr[][];
	static int visit[][];
	static int MAX = 10001;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
				visit[i][j] = MAX;
			}
		}
		bfs(0, 0);
		System.out.println(visit[N - 1][M - 1]);
	}

	static void bfs(int cx, int cy) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(cx, cy));
		visit[cx][cy] = 0;
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();

			for (int i = 0; i < 4; i++) {
				int tx = x + dx[i];
				int ty = y + dy[i];

				if (0 <= tx && tx < N && 0 <= ty && ty < M) {
					if (arr[tx][ty] == 0 && visit[tx][ty] > visit[x][y]) {
						visit[tx][ty] = visit[x][y];
						q.offer(new Point(tx, ty));

					}
					if (arr[tx][ty] == 1 && visit[tx][ty] > visit[x][y] + 1) {
						visit[tx][ty] = visit[x][y] + 1;
						q.offer(new Point(tx, ty));
					}
				}
			}
		}

	}

}
