import java.util.*;
import java.io.FileInputStream;

class SW_1238 {
	public static int bfs(int start) {
		int cnt = 1;
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> tq = new LinkedList<>();
		boolean visit[] = new boolean[101];
		max = 0;
		tmax =0;
		
		q.add(start);
		tq.add(cnt);
		while (!q.isEmpty()) {
			int cur = q.peek();
			int tcur = tq.peek();
			q.poll();
			if(tmax == tcur) {
				tmax = tq.peek();
				if(max < cur)
					max = cur;
			}
			if(tmax < tcur) {
				tmax = tq.peek();
				max = cur;
			}
			tq.poll();
			
			if (visit[cur] == false) {
				visit[cur] = true;
				cnt = tcur + 1;
				while (!list[cur].isEmpty()) {
					
					int next = list[cur].getFirst();
					list[cur].remove();
					if (visit[next] == false) {
						q.add(next);
						tq.add(cnt);
					}
				}
			}
		}
		return max;
	}

	static int max = 0;
	static int tmax =0;

	static LinkedList<Integer>[] list;

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int T = 10;/////////////////

		for (int test_case = 1; test_case <= T; test_case++)////////////
		{
			int N = sc.nextInt();
			int start = sc.nextInt();

			list = new LinkedList[101];
			for (int i = 0; i < 101; i++) list[i] = new LinkedList<>();
			
			for (int i = 1; i <= N / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				list[from].add(to);
				
			}

			System.out.println("#" + test_case + " " + bfs(start));
		}
	}
}