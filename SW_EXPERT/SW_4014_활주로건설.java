import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_4014_활주로건설 {
	static int N, X;
	static int map[][];
	static int map2[][];

	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			map2 = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					map2[i][j] = map[i][j];
				}
			}

			solve();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[j][i] = map2[i][j];
				}
			}
			solve();
			System.out.println("#" + test_case + " " + res);
		}
	}

	public static void solve() {
		int cur = 0, prev = 0;
		for (int i = 0; i < N; i++) {
			prev = map[i][0];
			int j;
			int all_same = 0;
			boolean flag = true;
			int ccur = 0, cprev = 0;
			for (j = 1; j < N; j++) {
				cur = map[i][j];
				if (Math.abs(prev - cur) > 1) {
					flag = false;
					break;
				}

				if (prev > cur) {
					while (ccur != X) {
						if (j >= N)
							break;
						if (cur != map[i][j])
							break;
						map[i][j] = -1;
						j++;
						ccur++;
					}
					j--;
					if (ccur < X) {
						flag = false;
						break;
					}
				}

				else if (prev < cur) {
					int k = j;
					while (true) {
						if (--k < 0)
							break;
						if (prev != map[i][k])
							break;
						map[i][k] = -1;
						cprev++;
					}

					if (cprev < X) {
						flag = false;
						break;
					}
				} else
					all_same++;
				prev = cur;
				ccur = 0;
				cprev = 0;
			}
			if (flag)
				res++;
			if (all_same == N)
				res++;
		}
	}
}
