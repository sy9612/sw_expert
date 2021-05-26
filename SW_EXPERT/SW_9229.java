import java.util.Arrays;
import java.util.Scanner;

class SW_9229 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int res = -1;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int arr[] = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			//Arrays.sort(arr);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == j)
						continue;
					int temp = arr[i] + arr[j];
					if (temp <= M && temp > res) {
						res = temp;
					}
				}
			}

			System.out.println("#" + test_case + " " + res);
		}
	}
}