import java.awt.*;
import java.io.*;
import java.util.*;

public class SW_4013_특이한자석 {
	static int magnet[][];
	static int K;
	static int res;
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			magnet = new int[5][8];
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < K; i++) {
				visit = new boolean[5];
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				Solve(num, d);
			}

			for (int i = 1; i <= 4; i++) {
				res += magnet[i][0] * (int) Math.pow(2, i-1);
			}
			System.out.println("#"+ test_case + " " + res);
		} // test_case
	}// main

	public static void Solve(int num, int d) {// 1 시계, -1 반시계
		Queue<Point> q = new LinkedList();
		q.add(new Point(num, d));
		visit[num] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			num = p.x;
			d = p.y;

			if (num > 1 && !visit[num - 1] && magnet[num - 1][2] != magnet[num][6]) {
				q.add(new Point(num - 1, -d));
				visit[num - 1] = true;
			}
			if (num < 4 && !visit[num + 1] && magnet[num + 1][6] != magnet[num][2]) {
				q.add(new Point(num + 1, -d));
				visit[num + 1] = true;
			}

			Rotate(num, d);
		}
	}// Solve

	public static void Rotate(int num, int d) {
		int prev = 0, temp = 0;
		if (d == 1) {
			prev = magnet[num][7];
			for (int i = 0; i < 8; i++) {
				temp = magnet[num][i];
				magnet[num][i] = prev;
				prev = temp;
			}
		}

		if (d == -1) {
			prev = magnet[num][0];
			for (int i = 7; i >= 0; i--) {
				temp = magnet[num][i];
				magnet[num][i] = prev;
				prev = temp;
			}
		}
	}// Rotate
}