import java.util.Arrays;
import java.util.Scanner;

class SW_3289 {
	static int N, M;
	static int parent[];

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();

			parent  = new int[N + 1];
			
			StringBuilder str = new StringBuilder();
			str.append("#").append(test_case).append(" ");
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				int c = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				switch(c) {
				case 0:
					union(a, b);
					break;
				case 1:
					if(find(a) == find(b))
						str.append(1);
					else
						str.append(0);
					break;
				
				}
			}
			System.out.println(str.toString());
		}
		sc.close();
	}

	static public int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static public void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		
		if(nx < ny)
			parent[ny] = nx;
		else
			parent[nx] = ny;
	}

}