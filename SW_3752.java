import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Vector;


class Solution
{
public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			Vector<Integer> v = new Vector();
			int sum = 0;
			int cur = 0;
			int N = sc.nextInt();
			int arr[] = new int[N];
			int cnt1 = 0;
			int cnt2 = 1;
			int cnt3 = 0;
			boolean temp[] = new boolean[10001];
			temp[0] = true;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();

				for (int j = 0; cnt1 != cnt2; j++) {

					if (temp[j]) {
						if (temp[arr[i] + j] == false)
							cnt3++;

						v.add(arr[i] + j);
						cnt1++;

					}

				}
				for (int k = 0; k < v.size(); k++) {
					temp[v.get(k)] = true;
				}
				v.clear();
				cnt2 += cnt3;
				cnt1 = 0;
				cnt3 = 0;

			}

			System.out.println("#" + test_case + " " + cnt2);
		}
	}
}