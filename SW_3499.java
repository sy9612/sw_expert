import java.util.Scanner;
import java.io.FileInputStream;


class SW_3499
{
		public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			String arr[] = new String[N / 2 + 1];
			String temp[] = new String[N / 2 + 1];
			String t = null;
			if (N % 2 == 0) {
				for (int i = 0; i < N; i++) {
					if (i < N / 2) {
						arr[i] = sc.next();
					} else
						temp[i - N / 2] = sc.next();
				}
			} else {
				for (int i = 0; i < N; i++) {
					if (i < N / 2 + 1) {
						arr[i] = sc.next();
					} else
						temp[i - N / 2 -1] = sc.next();
				}

			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < N / 2 + 1; i++) {
				if (arr[i] != null)
					System.out.print(arr[i] + " ");
				if (temp[i] != null)
					System.out.print(temp[i] + " ");
			}
			System.out.println();
		}
	
	}
}