package SW_EXPERT;
import java.util.*;
import java.awt.*;
import java.io.*;

public class SW_12052_부서진타일 {
	static int N, M;
	static int dx[] = { 0, 0, 1, 1 };
	static int dy[] = { 0, 1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			String ans = "YES";
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			char map[][] = new char[N][M];
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '#')
						cnt++;

				}
			}

			if (cnt % 4 == 0) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (map[i][j] == '#') {
							for (int k = 0; k < 4; k++) {
								int tx = dx[k] + i;
								int ty = dy[k] + j;
								if (tx < 0 || ty < 0 || tx >= N || ty >= M)
									continue;
								if (map[tx][ty] == '.')
									ans = "NO";
								else
									map[tx][ty] = '.';
							}
						}
					}
				}
			} else
				ans = "NO";

			System.out.println("#" + test_case + " " + ans);
		}
	}// main
}
