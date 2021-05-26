import java.io.*;
import java.util.*;
import java.awt.*;

public class BOJ_18428_감시피하기 {
	static int N;
	static char map[][];
	static boolean res;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static ArrayList<Point> teacher = new ArrayList();
	static ArrayList<Point> student = new ArrayList();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'T')
					teacher.add(new Point(i, j));
				else if (map[i][j] == 'S')
					student.add(new Point(i, j));
			}
		}

		DFS(0);

		if (res)
			System.out.println("YES");
		else
			System.out.println("NO");

	}// main

	static public void DFS(int cnt) {
		if (cnt == 3) {
			if (Check())
				res = true;
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'X') {
					map[i][j] = 'O';
					DFS(cnt + 1);
					map[i][j] = 'X';
				}
			}
		}

	}// DFS

	static public boolean Check() {
		for (int i = 0; i < teacher.size(); i++) {
			Point p = teacher.get(i);
			for (int j = 0; j < 4; j++) {
				int x = p.x + dx[j];
				int y = p.y + dy[j];
				while (true) {
					if (x < 0 || y < 0 || x >= N || y >= N)// 범위 벗어
						break;
					if (map[x][y] == 'S') {// 학생 보이면 실패야~
						return false;
					} else if (map[x][y] == 'O')
						break;
					x += dx[j];
					y += dy[j];
				}
			}

		}

		return true;
	}// Check

}
