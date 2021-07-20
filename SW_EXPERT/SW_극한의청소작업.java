package SW_EXPERT;
import java.io.*;
import java.util.*;

public class SW_극한의청소작업 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());

			if ((A > 0 && B > 0) || (A < 0 && B < 0)) {
				System.out.println("#" + test_case + " " + Math.abs(Cal(A) - Cal(B)));
			} else {
				System.out.println("#" + test_case + " " + (Cal(A) + Cal(B) - 1));
			}
		}
	}

	static long square(int M, int N) {
		long m = 1;
		for (int i = 0; i < N; i++) {
			m = m * M;
		}
		return m;
	}

	static long Cal(long A) {
		if (A < 0) {
			A *= -1;
		}
		
		long temp = A;
		long sum = 0;
		int N = 0;
		while (temp != 0) {
			temp = temp / 10;
			N++;
		}
		while (N != 0) {
			long x = A / square(10, N - 1);
			A = A % square(10, N - 1);
			if (x >= 4) {
				sum += (x - 1) * square(9, N - 1);
			} else {
				sum += x * square(9, N - 1);
			}
			N--;
		}
		return sum;
	}
}
