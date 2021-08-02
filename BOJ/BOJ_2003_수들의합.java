package BOJ;
import java.io.*;
import java.util.*;

public class BOJ_2003_수들의합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0, end = 0;

		int sum = arr[end];
		while(end < N) {
			if (sum == M) {
				ans++;
				end++;
				if(end >= N)
					break;
				sum += arr[end];

			} else if (sum > M) {
				sum -= arr[start];
				start++;

			} else {//sum < M
				end++;
				if(end >= N)
					break;
				sum += arr[end];
			}
		}

		System.out.println(ans);
	}// main
}
