import java.util.Scanner;

class SW_9940 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			boolean arr[] = new boolean[N];

			String res = "Yes";

			for (int i = 0; i < N; i++) {
				int temp = sc.nextInt();
				arr[temp - 1] = true;

			}
			for (int i = 0; i < N; i++) {
				if (arr[i] == false) {
					res = "No";
					break;
				}

			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}