import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SW_4012 {
	static int N;
	static int map[][];
	static int ans;
	static int src[];
	static ArrayList<Integer> answers;
	static int dish = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			map = new int[N+1][N+1];
			src = new int[N];
			answers = new ArrayList();

			for (int i = 0; i < N; i++) {
				src[i] = i + 1;
			}
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			makeCombination(N / 2, 0, new int[N / 2]);
			for (int i = 0; i < answers.size() / 2; i++)
				ans = Math.min(ans, Math.abs(answers.get(i) - answers.get(answers.size() - 1 - i)));

			System.out.println("#" + test_case + " " + ans);
		}

	}

	public static int combination(int n, int r) {
		if (r == 0 || r == n)
			return 1;
		else
			return combination(n - 1, r - 1) + combination(n - 1, r);
	}

	public static void makeCombination(int n, int start, int[] temp) {

		if (n == 0) {
			dish = 0;
			sumCombination(2, 0, new int[2], temp);
			answers.add(dish);
			return;
		}

		for (int i = start; i < src.length; i++) {
			temp[n - 1] = src[i];
			makeCombination(n - 1, i + 1, temp);
		}

	}

	public static void sumCombination(int n, int start, int[] temp, int[] result) {
		if (n == 0) {
			dish += map[temp[0]][temp[1]];
			dish += map[temp[1]][temp[0]];
			return;
		}

		for (int i = start; i < result.length; i++) {
			temp[n - 1] = result[i];
			sumCombination(n - 1, i + 1, temp, result);
		}
	}
}
