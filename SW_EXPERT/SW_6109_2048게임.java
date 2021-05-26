import java.io.*;
import java.util.*;

public class SW_6109_2048게임 {
	static int N;
	String S;
	static int map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			solve(S);

			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}

		} // testcase
	}

	public static void solve(String S) {
		boolean flag = true;
		if (S.equals("right")) {
			for (int i = 0; i < N; i++) {
				ArrayList<Integer> arr = new ArrayList();

				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] == 0)
						continue;
					if (flag && arr.size() > 0 && arr.get(arr.size() - 1) == map[i][j]) {
						arr.remove(arr.size() - 1);
						arr.add(map[i][j] * 2);
						flag = false;
					} else {
						arr.add(map[i][j]);
						flag = true;
					}
				}

				int idx = 0;
				for (int j = N - 1; j >= 0; j--) {
					if (idx < arr.size()) {
						map[i][j] = arr.get(idx++);
					} else
						map[i][j] = 0;
				}
			}
		} // right

		if (S.equals("left")) {
			for (int i = 0; i < N; i++) {
				ArrayList<Integer> arr = new ArrayList();

				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0)
						continue;
					if (flag && arr.size() > 0 && arr.get(arr.size() - 1) == map[i][j]) {
						arr.remove(arr.size() - 1);
						arr.add(map[i][j] * 2);
						flag = false;
					} else {
						arr.add(map[i][j]);
						flag = true;
					}
				}

				int idx = 0;
				for (int j = 0; j < N; j++) {
					if (idx < arr.size()) {
						map[i][j] = arr.get(idx++);
					} else
						map[i][j] = 0;
				}
			}
		} // left

		if (S.equals("up")) {
			for (int i = 0; i < N; i++) {
				ArrayList<Integer> arr = new ArrayList();

				for (int j = 0; j < N; j++) {
					if (map[j][i] == 0)
						continue;
					if (flag && arr.size() > 0 && arr.get(arr.size() - 1) == map[j][i]) {
						arr.remove(arr.size() - 1);
						arr.add(map[j][i] * 2);
						flag = false;
					} else {
						arr.add(map[j][i]);
						flag = true;
					}
				}

				int idx = 0;
				for (int j = 0; j < N; j++) {
					if (idx < arr.size()) {
						map[j][i] = arr.get(idx++);
					} else
						map[j][i] = 0;
				}
			}
		} // up

		if (S.equals("down")) {
			for (int i = 0; i < N; i++) {
				ArrayList<Integer> arr = new ArrayList();

				for (int j = N - 1; j >= 0; j--) {
					if (map[j][i] == 0)
						continue;
					if (flag && arr.size() > 0 && arr.get(arr.size() - 1) == map[j][i]) {
						arr.remove(arr.size() - 1);
						arr.add(map[j][i] * 2);
						flag = false;
					} else {
						arr.add(map[j][i]);
						flag = true;
					}
				}

				int idx = 0;
				for (int j = N - 1; j >= 0; j--) {
					if (idx < arr.size()) {
						map[j][i] = arr.get(idx++);
					} else
						map[j][i] = 0;
				}
			}
		} // down

	}// solve
}

/*
 * 1 4 right 2 0 2 4 2 0 4 2 2 2 4 8 2 2 4 4
 * 
 * 1 4 left 2 0 2 4 2 0 4 2 2 2 4 8 2 2 4 4
 * 
1 
4 up 
2 0 2 4 
2 0 4 2 
2 2 4 8 
2 2 4 4
1 
4 down 
2 0 2 4 
2 0 4 2 
2 2 4 8 
2 2 4 4
*/
 
