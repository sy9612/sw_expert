import java.io.*;
import java.util.*;

public class SW_2112_보호필름 {
	static int map[][];
	static int res = Integer.MAX_VALUE;
	static int D, W, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			res = Integer.MAX_VALUE;
			
			Solve(0, 0);

			System.out.println("#" + test_case + " " + res);
		} // test_case

	}// main

	public static void Solve(int row, int cnt) {
		// K만큼 됐는지 확인한다
		if (Check()) {
			res = Math.min(res, cnt);
			return;
		}

		if (res < cnt)
			return;

		if (row == D)
			return;

		// 그냥 가기
		Solve(row + 1, cnt);
		int[] temp = new int[W];
		for (int i = 0; i < W; i++)
			temp[i] = map[row][i];
		
		// A로 바꾸고 가기
		for (int i = 0; i < W; i++)
			map[row][i] = 0;
		Solve(row + 1, cnt + 1);
		
		// B로 바꾸고 가기
		for (int i = 0; i < W; i++)
			map[row][i] = 1;
		Solve(row + 1, cnt + 1);
		
		for (int i = 0; i < W; i++)
			map[row][i] = temp[i];
	}

	public static boolean Check() {
		int prev = 0, cnt = 0;
		for (int j = 0; j < W; j++) {
			prev = map[0][j];
			cnt = 1;
			for (int i = 1; i < D; i++) {
				if (prev == map[i][j])
					cnt++;
				else {
					cnt = 1;
					prev = map[i][j];
				}
				if(cnt == K)
					break;
			}
			if (cnt != K) {
				return false;
			}
		}
		return true;
	}// Check

}
