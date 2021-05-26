import java.util.*;
import java.io.*;

public class BOJ_1637_날카로운눈 {
	static int N;
	static int[] A, B, C;
	static int num = 0, cnt = 0, min = 0, max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());

			min = Math.min(A[i], min);
			max = Math.max(C[i], max);
		}

		max++;
		BinarySearch();

	}// Main]

	public static void BinarySearch() {
		long left = min;
		long right = max;

		while (left < right) {
			long mid = (left + right) / 2;

			long sum = getSum(mid);
			if (sum % 2 == 0)
				left = mid + 1;
			else
				right = mid;
		}
		
		if (left == max)
			System.out.println("NOTHING");
		else {
			long num = getSum(left) - getSum(left - 1);
			System.out.println(left + " " + num);
		}
	}// BinarySearch

	public static long getSum(long mid) {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			if (mid >= A[i])
				sum += (Math.min(mid, C[i]) - A[i]) / B[i] + 1;
		}
		return sum;
	}

}
