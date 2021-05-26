
import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_1952_수영장 {
	static boolean pos[] = new boolean[4];
	static int month[] = new int[12];
	static int one_day;
	static int one_month;
	static int three_month;
	static int one_year;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			one_day = Integer.parseInt(st.nextToken());
			one_month = Integer.parseInt(st.nextToken());
			three_month = Integer.parseInt(st.nextToken());
			one_year = Integer.parseInt(st.nextToken());
			int dp[] = new int[13];
			int month[] = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++)
				month[i] = Integer.parseInt(st.nextToken());
			for (int i = 1; i <= 12; i++)
				dp[i] = Integer.MAX_VALUE;
			// 1일 vs 1달
			dp[0] = 0;
			for (int i = 1; i <= month.length - 1; i++) {
				dp[i] = dp[i-1] + one_day * month[i];
				dp[i] = (dp[i] < dp[i-1] + one_month)?dp[i]:dp[i-1] +  one_month;
				if(i >= 3)
					dp[i] = (dp[i] <dp[i-3] + three_month)?dp[i]:dp[i-3] + three_month;
				if(i >= 12)
					dp[i] = (dp[i] < one_year)?dp[i]:one_year;

			}

			System.out.println("#" + test_case + " " + dp[12]);
		}
	}
}
