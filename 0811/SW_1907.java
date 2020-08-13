import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1907 {
	static int arr[][];
	static int dx[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int dy[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int H, W;
	static Queue<Point> q = new LinkedList();
	static Queue<Point> q2 = new LinkedList();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			arr = new int[H][W];
			int result = -1;

			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					arr[i][j] = str.charAt(j)-'0';
					if(arr[i][j] == -2) {
						q2.offer(new Point(i, j));
						arr[i][j] = 0;
					}
				}
			}
			
			while (!q2.isEmpty()) {
				
				int size = q2.size();
				for(int i=0; i<size; i++) {
					int x = q2.peek().x;
					int y = q2.peek().y;
					q2.poll();
					bfs(x, y);
				}
				result++;
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

	public static void bfs(int cx, int cy) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int tx = cx + dx[i];
			int ty = cy + dy[i];
			if (0 <= tx && tx < H && 0 <= ty && ty < W && arr[tx][ty] > 0) {
				arr[tx][ty] -= 1;
				if(arr[tx][ty] == 0)
					q2.offer(new Point(tx, ty));
			}
		}
	}

}
/*
 while(!q.isEmpty()) {
					Point p = q.peek();
					int x = p.x;
					int y = p.y;
					q.poll();
					arr[x][y] = 0;
				}

*/