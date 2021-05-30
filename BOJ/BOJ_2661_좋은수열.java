package BOJ;
import java.io.*;
import java.util.*;

public class BOJ_2661_좋은수열 {
	static int N, res = 0, cnt = 0;
	static int arr[];
	static boolean flags = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		arr[0] = 1;
		arr[1] = 2;
		// 앞에 숫자랑 안 겹치게
		// 겹치면 다음
		for (int i = 2; i < N; i++) {// 몇번째
			arr[i] = 1;
			flags = false;
			cnt = 0;
			Solve(i, 1);
			if (flags)
				i -= cnt;

		}

		for (int i = 0; i < N; i++)
			System.out.print(arr[i]);

	}// main

	public static boolean Solve(int cur, int i) {
		if (!Hello(cur)) {
			if (i < 3) {
				arr[cur]++;
				Solve(cur, arr[cur]);
			} else {
				arr[cur - 1]++;
				flags = true;
				for (int j = cur; j < N; j++) {
					if (arr[j] == 0)
						break;
					arr[j] = 0;
					cnt++;
				}

				Solve(cur - 1, arr[cur - 1]);
			}

		}
		return true;

	}// Solve

	public static boolean Hello(int cur) {
		for (int i = 1; i <= (cur + 1) / 2; i++) {
			int j;
			boolean flag = false;
			for (j = 0; j < i; j++) {
				if (arr[cur - j] == arr[cur - i - j]) {
					continue;
				} else {
					flag = true;
				}
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}
}
