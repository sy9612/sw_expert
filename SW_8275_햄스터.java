import java.io.*;
import java.util.*;

public class SW_8275_햄스터 {
	static public class Record {
		int l;
		int r;
		int s;

		Record(int l, int r, int s) {
			this.l = l;
			this.r = r;
			this.s = s;
		}
	}

	static int N, X, M, res;
	static ArrayList<Record> arr ;
	static int result[];
	static int answer[];
	static int sum[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			res = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = new int[N + 1];
			answer = new int[N + 1];
			sum = new int[N + 1];
			arr = new ArrayList();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				arr.add(new Record(l, r, s));
			}
			res = -1;
			Solve(1);

			System.out.print("#" + test_case + " ");
			if (res == -1)
				System.out.println(res);
			else {
				for (int i = 1; i <= N; i++)
					System.out.print(answer[i] + " ");
				System.out.println();
			}
		} // test_case
	}// main

	public static void Solve(int cnt) {
		if (cnt == N + 1) {
			// 조건 만족하는지 확인
			for (int i = 0; i < arr.size(); i++) {
				Record r = arr.get(i);
				if (sum[r.r] - sum[r.l - 1] != r.s)
					return;
			}

			// 양이 같으면 사전순으로 먼저인지
			if (sum[N] == res) {
				for (int i = 1; i <= N; i++) {
					if (result[i] > answer[i]) {
						return;
					}
				}
				answer = result.clone();
			}
			
			// 만족한다면 이전보다 양이 많은지
			if (sum[N] > res) {
				answer = result.clone();
				res = sum[N];
			}

			return;
		}

		for (int j = 0; j <= X; j++) {
			result[cnt] = j;
			sum[cnt] = sum[cnt - 1] + j;
			Solve(cnt + 1);
		}
	}

}
