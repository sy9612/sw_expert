import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_2239_스도쿠 {
	static boolean Row[][];
	static boolean Col[][];
	static boolean Square[][];
	static int map[][];
	static ArrayList<Point> arr = new ArrayList();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Row = new boolean[9][10];
		Col = new boolean[9][10];
		Square = new boolean[9][10];
		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 0)
					arr.add(new Point(i, j));
				else {
					Row[i][map[i][j]] = true;
					Col[j][map[i][j]] = true;
					Square[i / 3 * 3 + j / 3][map[i][j]] = true;
				}
			}
		}

		DFS(0);

	}// main

	public static void DFS(int cnt) {
		if (cnt == arr.size()) {

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}

		int x = arr.get(cnt).x;
		int y = arr.get(cnt).y;

		for (int j = 1; j <= 9; j++) {
			if (!Row[x][j] && !Col[y][j] && !Square[x / 3 * 3 + y / 3][j]) {
				Row[x][j] = true;
				Col[y][j] = true;
				Square[x / 3 * 3 + y / 3][j] = true;
				map[x][y] = j;
				DFS(cnt+1);
				Row[x][j] = false;
				Col[y][j] = false;
				Square[x / 3 * 3 + y / 3][j] = false;
				map[x][y] = 0;
			}
		}
	}//DFS
}
