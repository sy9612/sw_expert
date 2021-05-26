import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15686 {
	static int map[][];
	static int result = Integer.MAX_VALUE;
	static int N, M;
	static boolean visit[];
	static ArrayList<Point> house = new ArrayList();
	static ArrayList<Point> chicken = new ArrayList();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					house.add(new Point(i, j));
				if (map[i][j] == 2)
					chicken.add(new Point(i, j));
			}
		}
		visit = new boolean[chicken.size() + 1];
		dfs(0, 0);
		System.out.println(result);
	}

	public static void dfs(int idx, int cnt) {
		if (idx > chicken.size())
			return;

		if (cnt == M) {
			int d = 0;
			for (int i = 0; i < house.size(); i++) {
				int temp = Integer.MAX_VALUE;
				int hx = house.get(i).x;
				int hy = house.get(i).y;
				for (int j = 0; j < chicken.size(); j++) {
					if (visit[j] == true) {
						int cx = chicken.get(j).x;
						int cy = chicken.get(j).y;
						if (temp > Math.abs(cx - hx) + Math.abs(cy - hy))
							temp = Math.abs(cx - hx) + Math.abs(cy - hy);
					}
				}
				d += temp;
			}

			if (d < result)
				result = d;

			return;
		}

		visit[idx] = true;
		dfs(idx + 1, cnt + 1);
		visit[idx] = false;
		dfs(idx + 1, cnt);

	}
}
