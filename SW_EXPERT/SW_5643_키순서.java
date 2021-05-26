import java.awt.Point;
import java.io.*;
import java.util.*;

public class SW_5643_키순서 {
	static int N, M;
	static int res;
	static ArrayList<Integer>[] small;
	static ArrayList<Integer>[] big;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());

			small = new ArrayList[N + 1];
			big = new ArrayList[N + 1];

			for (int i = 1; i <= N; i++) {
				small[i] = new ArrayList<>();
				big[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				big[x].add(y);
				small[y].add(x);
			}
			Queue<Integer> q = new LinkedList();
			for (int k = 1; k <= N; k++) {
				////////////////big///////////////
				int cnt = 0;
				boolean visit[] = new boolean[N + 1];
				q.add(k);
				visit[k] = true;

				while (!q.isEmpty()) {
					int cur = q.poll();
					for (int i = 0; i < big[cur].size(); i++) {
						if (!visit[big[cur].get(i)]) {
							q.add(big[cur].get(i));
							visit[big[cur].get(i)] = true;
							cnt++;
						}
					}
				}

				//////////////// small/////////////////
				q = new LinkedList();
				q.add(k);
				visit[k] = true;

				while (!q.isEmpty()) {
					int cur = q.poll();
					for (int i = 0; i < small[cur].size(); i++) {
						if (!visit[small[cur].get(i)]) {
							q.add(small[cur].get(i));
							visit[small[cur].get(i)] = true;
							cnt++;
						}
					}
				}

				////////////////// result//////////////////////
				if (cnt == N - 1)
					res++;
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}// main
}
