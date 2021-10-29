import java.io.*;
import java.util.*;

public class BOJ_14888_연산자끼워넣기 {
	static int N = 0;
	static int nums[];
	static ArrayList<Integer> arr = new ArrayList();
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp != 0) {
				for (int j = 0; j < temp; j++) {
					arr.add(i); 
				}
			}
		}

		Solve(0, 0, new boolean[N-1], new int[N-1]);

		System.out.println(max);
		System.out.println(min);

	}// main

	public static void Solve(int cnt, int idx, boolean visit[], int[] operator) {
		if (cnt == N-1) {
			int answer = nums[0];
			for(int i=0; i<operator.length; i++) {
				if(operator[i] == 0) {
					answer += nums[i+1];
				}else if(operator[i] == 1) {
					answer -= nums[i+1];
				}else if(operator[i] == 2) {
					answer *= nums[i+1];
				}else if(operator[i] == 3) {
					answer /= nums[i+1];
				}
			}
			
			min = Math.min(answer, min);
			max = Math.max(answer, max);
			return;
		}

		for (int i = 0; i < N-1; i++) {
			if (!visit[i]) {
				visit[i] = true;
				operator[cnt] = arr.get(i);
				Solve(cnt+1, idx, visit, operator);
				visit[i] = false;
			}
		}

	}// Solve
}
