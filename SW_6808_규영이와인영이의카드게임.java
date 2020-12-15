import java.io.*;
import java.util.*;

public class SW_6808_규영이와인영이의카드게임 {
	static boolean num[];
	static int gu[];
	static int arr[];
	static int win = 0, lose = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			win = 0;
			lose = 0;
			gu = new int[9];
			num = new boolean[19];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gu[i] = Integer.parseInt(st.nextToken());
				num[gu[i]] = true;
			}

			int idx = 0;
			arr = new int[9];
			for (int i = 1; i <= 18; i++) {
				if (!num[i])
					arr[idx++] = i;
			}
			// 순서를 정함
			Solve(new int[9], new boolean[9], 0);

			System.out.println("#" + test_case + " " + win + " " + lose);
		} // test_case
	}// main

	public static void Solve(int[] in, boolean[] visit, int cnt) {
		if (cnt == 9) {
			// 순서 정해지면 계산
			Calc(in);
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visit[i]) {
				in[cnt] = arr[i];
				visit[i] = true;
				Solve(in, visit, cnt + 1);
				visit[i] = false;
			}
		}
	}

	public static void Calc(int[] in) {
		int a = 0, b = 0;// 규영, 인영
		for (int i = 0; i < 9; i++) {
			if (gu[i] > in[i])
				a += gu[i] + in[i];
			else if (gu[i] < in[i])
				b += gu[i] + in[i];
		}

		if (a > b)
			win++;
		else if (a < b)
			lose++;
	}
}
