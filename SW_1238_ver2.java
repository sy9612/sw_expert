import java.util.*;

class SW_1238_ver2 {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++)////////////
		{
			int max = 0;
			int N = sc.nextInt();
			int start = sc.nextInt();
			boolean arr[][] = new boolean[101][101];
			boolean visit[] = new boolean[101];
			Queue<Integer> q = new LinkedList();

			for (int i = 0; i < N / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				arr[from][to] = true;
			}

			q.offer(start);
			visit[start] = true;
			while (!q.isEmpty()) {
				max = 0;
				int size = q.size();
				for (int j = 0; j < size; j++) {
					int cur = q.peek();
					q.poll();
					if(max < cur)
						max = cur;
					for (int i = 1; i <= 100; i++) {
						if (arr[cur][i] == true && visit[i] == false) {
							q.offer(i);
							visit[i] = true;
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + max);
		}
	}
}