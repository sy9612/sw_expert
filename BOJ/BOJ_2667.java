import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2667 {
	static int map[][];
	static boolean visit[][];

	static int dx[] = { -1,  0, 1,  0 };
	static int dy[] = {  0, 1, 0, -1 };
	static ArrayList<Integer> arr = new ArrayList<>();
	static int N;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new boolean[N][N];

		int res = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visit[i][j] == false)
					arr.add(bfs(i, j));
			}
		}
		arr.sort(null);
		System.out.println(arr.size());
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

////////////////////
	static public int bfs(int a, int b) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(a, b));
		int x = q.peek().x;
		int y = q.peek().y;
		int cnt = 0;
		while (!q.isEmpty()) {
			x = q.peek().x;
			y = q.peek().y;
			q.poll();
			
			visit[x][y] = true;
			cnt++;
			int tx, ty;
			for (int i = 0; i < 4; i++) {
				tx = x + dx[i];
				ty = y + dy[i];
				if (tx >= 0 && tx < N && ty >= 0 && ty < N && map[tx][ty] == 1 && visit[tx][ty] == false) {
					visit[tx][ty] = true;
					q.add(new Point(tx, ty));
				}

			}

		}
		return cnt;

	}
}
