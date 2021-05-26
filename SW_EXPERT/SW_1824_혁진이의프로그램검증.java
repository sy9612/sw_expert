import java.io.*;
import java.util.*;

public class SW_1824_혁진이의프로그램검증 {
	static int R, C;
	static String res;
	static boolean check;
	static char map[][];
	static boolean[][][][] visit;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visit = new boolean[R][C][4][16];
			boolean checkE = false;
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '@')
						checkE = true;
				}
			}
			check = false;
			if(checkE)
				Solve(0, 0, 1, 0);
			res = (check == true) ? "YES" : "NO";
			System.out.println("#" + test_case + " " + res);
		} // test_case
	}// main

	static void Solve(int x, int y, int d, int memory) {
		if(check)
			return;
		
		if (map[x][y] == '@') {
			check = true;
			return;
		}
		if (visit[x][y][d][memory]) {
			return;
		}

		visit[x][y][d][memory] = true;
		
		switch (map[x][y]) {
		case '<':
			d = 3;
			break;
		case '>':
			d = 1;
			break;
		case '^':
			d = 0;
			break;
		case 'v':
			d = 2;
			break;
		case '_':
			d = (memory == 0 ? 1 : 3);
			break;
		case '|':
			d = (memory == 0 ? 2 : 0);
			break;
		case '+':
			memory = (memory == 15 ? 0 : memory + 1);
			break;
		case '-':
			memory = (memory == 0 ? 15 : memory - 1);
			break;
		case '.':
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			memory = map[x][y] - '0';
			break;
		}// switch

		if (map[x][y] == '?') {
			for (int i = 0; i < 4; i++) {
				int tx = x + dx[i];
				int ty = y + dy[i];

				if (tx < 0)
					Solve(R - 1, ty, i, memory);
				else if (ty < 0)
					Solve(tx, C - 1, i, memory);
				else if (tx >= R)
					Solve(0, ty, i, memory);
				else if (ty >= C)
					Solve(tx, 0, i, memory);
				else
					Solve(tx, ty, i, memory);
			}

		} else {
			int tx = x + dx[d];
			int ty = y + dy[d];
			
			if (tx < 0)
				Solve(R - 1, ty, d, memory);
			else if (ty < 0)
				Solve(tx, C - 1, d, memory);
			else if (tx >= R)
				Solve(0, y, d, memory);
			else if (ty >= C)
				Solve(tx, 0, d, memory);
			else
				Solve(tx, ty, d, memory);
		}
	}// Solve

}
