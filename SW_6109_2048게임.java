import java.io.*;
import java.util.*;

public class SW_6109_2048게임 {
	static int N;
	String S;
	static int map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			solve(S);

			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}

		} // testcase
	}

	public static void solve(String S) {
		if (S.equals("right")) {
			ArrayList<Integer> arr = new ArrayList();
			for(int i=0; i<N; i++) {
				for(int j=N-1; j >= 0; j--) {
					if(arr.size() > 0 && arr.get(arr.size() - 1) == map[i][j]) {
						arr.remove(arr.size() - 1);
						arr.add(map[i][j] * 2) ;
					}
					else
						arr.add(map[i][j]) ;
				}
				
				int idx = 0;
				for(int j=N-1; j >= 0; j--) {
					while(arr.isEmpty()) {
					map[i][j] = arr.get(idx++);
					}
				}
			}
		}//right

		if (S.equals("left")) {

		}//left

		if (S.equals("up")) {

		}

		if (S.equals("down")) {

		}

	}//solve
}


/*
1
4 right
2 0 2 4
2 0 4 2
2 2 4 8
2 2 4 4

 */


