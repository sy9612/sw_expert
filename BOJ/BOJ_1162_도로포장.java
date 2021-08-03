package BOJ;
import java.io.*;
import java.util.*;

public class BOJ_1162_도로포장 {
	static int ans = Integer.MAX_VALUE;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[f][t] = d;
		}

		dfs(K, 0, new boolean [M]);

		System.out.println(ans);
	}// main

	public static void dfs(int cnt, int cost, boolean [] visit) {
		if(cnt == 0){
			if(ans > cost)
				ans = cost;
			return;
		}
		
		
		
		
	}//dfs
}
