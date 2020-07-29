import java.util.Scanner;

public class SW_2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int arr[][] = new int[N][N];
			int arr2[][] = new int[N][N];
			int res = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int m = 0; m <= N - M; m++) {
				for (int n = 0; n <= N - M; n++) {
					for (int i = m; m + M - 1 < N && i < m + M; i++) {
						for (int j = n; n + M - 1 < N && j < n + M; j++) {
							arr2[m][n] += arr[i][j];
						}
					}
				}
			}


			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr2[i][j] > res) {
						res = arr2[i][j];
					}
				}
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}
