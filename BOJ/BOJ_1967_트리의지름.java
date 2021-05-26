import java.awt.*;
import java.io.*;
import java.util.*;

public class BOJ_1967_트리의지름 {
	static ArrayList<Point> arr[];
	static boolean visit[];
	static int N, res = 0, max = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[p].add(new Point(c, w));
			arr[c].add(new Point(p, w));
		}
		visit = new boolean[N + 1];
		visit[1] = true;
		DFS(1, 0);
		res = 0;
		visit = new boolean[N + 1];
		visit[max] = true;
		DFS(max, 0);

		System.out.println(res);
	}// main

	static void DFS(int cur, int sum) {
		for (int i = 0; i < arr[cur].size(); i++) {
			if (res < sum) {
				max = cur;
				res = sum;
			}
			int p = arr[cur].get(i).x;
			int w = arr[cur].get(i).y;
			if (!visit[p]) {
				visit[p] = true;
				DFS(p, sum + w);
			}
		}

	}// DFS
}
