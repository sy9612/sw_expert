package SW_EXPERT;
import java.io.*;
import java.util.*;

public class SW_오목판정 {
	static int dx[] = { 0, 1, 1, 1 };
	static int dy[] = { 1, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String ans = "NO";
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char map[][] = new char[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'o') {
						
						for (int k = 0; k < 4; k++) {
							int tx = i + dx[k];
							int ty = j + dy[k];

							if (tx < 0 || ty < 0 || tx >= N || ty >= N)
								continue;
							int cnt = 1;
							while (map[tx][ty] == 'o') {
								cnt++;
								tx += dx[k];
								ty += dy[k];

								if (tx < 0 || ty < 0 || tx >= N || ty >= N)
									break;
								
								if (cnt > 5)
									break;
							}

							if (cnt == 5)
								ans = "YES";
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + ans);

		} // test_case
	}// main
}
