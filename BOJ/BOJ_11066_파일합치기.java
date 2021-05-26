import java.util.*;
import java.io.*;

public class BOJ_11066_파일합치기 {
	public static int K;
	public static int arr[], dp[][], sum[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());

			arr = new int[K + 1];
			dp = new int[502][502];
			sum = new int[K + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i - 1] + arr[i];
			}

			for (int i = 2; i <= K; i++) {
				for (int j = i - 1; j > 0; j--) {
					dp[j][i] = 999999999;
					for (int s = j; s <= i; s++)
						dp[j][i] = Math.min(dp[j][i], dp[j][s] + dp[s + 1][i]);

					dp[j][i] += sum[i] - sum[j - 1];
				}
			}

			System.out.println(dp[1][K]);
		}
	}// main
}
