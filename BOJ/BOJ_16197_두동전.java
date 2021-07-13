package BOJ;
import java.io.*;
import java.util.*;
import java.awt.*;

public class BOJ_16197_두동전 {
	static int N, M, min = Integer.MAX_VALUE;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static char map[][];
	static Point coin1 = new Point();
	static Point coin2 = new Point();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'o') {
					if (cnt == 0) {
						coin1.x = i;
						coin1.y = j;
						cnt++;
					} else {
						coin2.x = i;
						coin2.y = j;
					}
				}
			}
		}

		Solve(0, coin1.x, coin1.y, coin2.x, coin2.y);

		if (min > 10)
			System.out.println(-1);
		else
			System.out.println(min);
	}// main

	public static void Solve(int cnt, int x1, int y1, int x2, int y2) {
		// 벽 -> 이동 안 함
		// 칸이 없으면 보드 바깥으로 떨어짐
		// 두 동전 중 하나만
		if(cnt > min)
			return;
		
		if(cnt > 10) {
			min = cnt;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int tx1 = x1 + dx[i];
			int ty1 = y1 + dy[i];
			int tx2 = x2 + dx[i];
			int ty2 = y2 + dy[i];

			boolean flag1 = false, flag2 = false;

			if (tx1 < 0 || tx1 >= N || ty1 < 0 || ty1 >= M)
				flag1 = true;
			if (tx2 < 0 || tx2 >= N || ty2 < 0 || ty2 >= M)
				flag2 = true;

			if (flag1 && flag2) {
				continue;
			}

			if (flag1 || flag2) {
				cnt += 1;
				if (min > cnt)
					min = cnt;
				return;
			}

			if (map[tx1][ty1] == '#') {
				tx1 = x1;
				ty1 = y1;
			}

			if (map[tx2][ty2] == '#') {
				tx2 = x2;
				ty2 = y2;
			}

			Solve(cnt+1, tx1, ty1, tx2, ty2);
		}

	}// Solve
}
