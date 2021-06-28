package BOJ;
import java.io.*;
import java.util.*;

public class BOJ_2668_숫자고르기 {
	static int N;
	static int arr[];
	static boolean [] visited;
	static ArrayList<Integer> answer = new ArrayList();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			DFS(i, i);
			visited[i] = false;
		}

		Collections.sort(answer);
		System.out.println(answer.size());
		for (int i = 0; i < answer.size(); i++)
			System.out.println(answer.get(i));
	}// main

	public static void DFS(int cur, int target) {
		if(!visited[arr[cur]]) {
			visited[arr[cur]] = true;
			DFS(arr[cur], target);
			visited[arr[cur]] = false;

		}
		
		if(arr[cur] == target)
			answer.add(target);
		
	}//DFS
}
