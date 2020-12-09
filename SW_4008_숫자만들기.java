import java.io.*;
import java.util.*;

public class SW_4008_숫자만들기 {
	static int N, max = 0, min = 0;
	static int[] ops_cnt;
	static int[] ops;
	static ArrayList<Integer> nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			nums = new ArrayList();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			ops = new int[N - 1];
			ops_cnt = new int[4];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				ops_cnt[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				nums.add(temp);
			}

			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			Solve(0);
			System.out.println("#" + test_case + " " + (max - min));
		} // test_case
	}// main

	static public void Solve(int cnt) {
		if (cnt == N-1) {
			Calc();
			return;
		}

		for (int i = 0; i < 4; i++) {
			if(ops_cnt[i] == 0)
				continue;
			
			ops[cnt] = i;
			ops_cnt[i]--;
			Solve(cnt+1);
			ops_cnt[i]++;
		}
	}
	
	static public void Calc() {
		int idx = 0, val = nums.get(idx++);
		for (int i = 0; i < N - 1; i++) {
			int op = ops[i];
			switch (op) {
			case 0:
				val += nums.get(idx++);
				break;
			case 1:
				val -= nums.get(idx++);
				break;
			case 2:
				val *= nums.get(idx++);
				break;
			case 3:
				val /= nums.get(idx++);
				break;
			}
		}

		min = min < val ? min : val;
		max = max > val ? max : val;
	}
}
