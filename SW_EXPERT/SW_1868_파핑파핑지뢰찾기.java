import java.awt.Point;
import java.io.*;
import java.util.*;

public class SW_1868_파핑파핑지뢰찾기 {
	static int map[][];
	static int nmap[][];
	static boolean visit[][];
	static int N;
	static int res = 0;
	static int dx[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int dy[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static ArrayList<Point> bomb;
	static ArrayList<Point> notbomb;
	static int cnb;// 지뢰 아닌 자리 갯수
	static int cnt, zero;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			nmap = new int[N][N];
			visit = new boolean[N][N];
			bomb = new ArrayList();
			notbomb = new ArrayList();
			cnb = 0;
			cnt = 0;
			zero = 0;

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '*') {
						nmap[i][j] = 9;
						bomb.add(new Point(i, j));
					} else {
						notbomb.add(new Point(i, j));
					}
				}
			}

			for (int i = 0; i < bomb.size(); i++) {
				Point p = bomb.get(i);
				Check(p.x, p.y);
			}

			cnb = notbomb.size();

			for (int i = 0; i < notbomb.size(); i++) {
				Point p = notbomb.get(i);
				if (!visit[p.x][p.y] && nmap[p.x][p.y] == 0) {
					zero++;
					BFS(p.x, p.y);
				}
			}

			res = zero + (cnb - cnt);
			System.out.println("#" + test_case + " " + res);
		} // test_case
	}// main

	public static void Check(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			if (tx < 0 || tx >= N || ty < 0 || ty >= N)
				continue;
			nmap[tx][ty]++;
		}
	}

	public static void BFS(int x, int y) {
		Queue<Point> q = new LinkedList();
		q.add(new Point(x, y));
		visit[x][y] = true;
		cnt++;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			x = p.x;
			y = p.y;
			
			for (int j = 0; j < 8; j++) {
				int tx = x + dx[j];
				int ty = y + dy[j];

				if (tx < 0 || tx >= N || ty < 0 || ty >= N)
					continue;
				if(visit[tx][ty])
					continue;

				if (nmap[tx][ty] == 0) {
					q.add(new Point(tx, ty));
					visit[tx][ty] = true;
					cnt++;
				}
				else {
					visit[tx][ty] = true;
					cnt++;
				}
			}

		}
	}

}
