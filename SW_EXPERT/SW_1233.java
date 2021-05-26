import java.util.Scanner;
import java.io.FileInputStream;

class SW_1233 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int res = 1;
			int N = Integer.parseInt(sc.nextLine());
			int arr[] = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				String[] temp = sc.nextLine().split(" ");
				arr[Integer.parseInt(temp[0])] = temp[1].charAt(0) - '0';
			}
			if (N % 2 == 0) {// 짝수는 안 됨
				res = 0;
			} else {
				for (int i = N; i >= 3; i--) {
					if (i % 2 != 0) {
						if (arr[i - 1] <= 0 || arr[i] <= 0) {
							res = 0;
							break;
						}
						int op = arr[i / 2];
						if (op > 0) {
							res = 0;
							break;
						}

						arr[i / 2] = 1;

					} else {
						continue;
					}
				}
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}