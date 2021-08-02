package BOJ;
import java.util.*;
import java.io.*;

public class BOJ_2470_두용액 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long ans = Long.MAX_VALUE;
		int N = Integer.parseInt(st.nextToken());
		long arr[] = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int start = 0, end = N - 1;
		long ans1 = 0, ans2 = 0;
		while (start < end) {
			long sum = arr[start] + arr[end];
			if (ans > Math.abs(sum)) {
				ans = Math.abs(sum);
				ans1 = arr[start];
				ans2 = arr[end];
			}

			if (sum > 0) {
				end--;
			} else {
				start++;
			}
		}

		System.out.println(ans1 + " " + ans2);
	}// main
}
