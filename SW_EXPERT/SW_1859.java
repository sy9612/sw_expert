import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SW_1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			long res = 0;
			int N = sc.nextInt();
			int arr[] = new int[N];
			// int arr2[] = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int max = arr[N - 1];
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] > max)
					max = arr[i];
				else {
					res += max - arr[i];
				}
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}
