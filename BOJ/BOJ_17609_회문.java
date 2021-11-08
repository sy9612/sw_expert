import java.io.*;
import java.util.*;

public class BOJ_17609_회문 {
	static int answer = 2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			int p1 = 0, p2 = str.length() - 1;

			Solve(false, p1, p2, str);

			System.out.println(answer);
		} // test_case

	}// main

	public static void Solve(boolean flag, int p1, int p2, String str) {
		if (p1 > p2) {
			if (!flag)
				answer = 0;
			else
				answer = 1;
		}
		
		if (str.charAt(p1) != str.charAt(p2)) {
			if (!flag) {
				Solve(true, p1++, p2, str);
				Solve(true, p1, p2--, str);
			} else {
				return;
			}
		} else {
			Solve(flag, p1++, p2--, str);
		}
		

	}// Solve
}
