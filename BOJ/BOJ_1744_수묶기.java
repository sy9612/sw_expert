package BOJ;
import java.io.*;
import java.util.*;

public class BOJ_1744_수묶기 {
	static int N, res = 0;
	static ArrayList<Integer> arr1 = new ArrayList();
	static ArrayList<Integer> arr2 = new ArrayList();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			if (temp > 1)
				arr1.add(temp);
			else if (temp <= 0)
				arr2.add(temp);
			else
				res += temp;
		}

		Collections.sort(arr1);
		Collections.reverse(arr1);
		Collections.sort(arr2);

		for (int i = 0; i < arr1.size(); i+=2) {
			if (i + 1 < arr1.size()) {
				res += arr1.get(i) * arr1.get(i + 1);
 			} else {
				res += arr1.get(i);
			}
		}

		for (int i = 0; i < arr2.size(); i+=2) {
			if (i + 1 < arr2.size()) {
				if (arr2.get(i) * arr2.get(i + 1) > 0) {
					res += arr2.get(i) * arr2.get(i + 1);
				}
			} else {
				res += arr2.get(i);
			}
		}

		System.out.println(res);
	}// main
}
