import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class SW_2814_최장경로 {
	static int map[][];
	static int N, M, res;
	static List<Integer>[] arr;
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			res = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new LinkedList[N + 1];
			for (int i = 0; i < N + 1; i++)
				arr[i] = new LinkedList<>();

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x].add(y);
				arr[y].add(x);
			}
			visit = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				visit[i] = true;
				Solve(i, 1);
				visit[i] = false;
			}

			System.out.println("#" + test_case + " " + res);
		} // test_case
	}// main

	public static void Solve(int num, int cnt) {
		res = Math.max(res, cnt);
		for (int i = 0; i < arr[num].size(); i++) {
			if (!visit[arr[num].get(i)]) {
				visit[arr[num].get(i)] = true;
				Solve(arr[num].get(i), cnt + 1);
				visit[arr[num].get(i)] = false;
			}
		}
	}// Solve
}
