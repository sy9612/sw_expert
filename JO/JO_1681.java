import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1681 {
	static int N;
	static int map[][];
	static boolean visit[];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(1, 0, 0);
		
		System.out.println(ans);
	}
	
	public static void DFS(int cur, int cost, int cnt) {
		if(cost > ans)
			return;
		if(cnt > N)
			return;
		if(cur == 1 && cost != 0 && cnt == N) {
			ans = Math.min(ans, cost);
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!visit[i] && map[cur][i] != 0) {
				visit[i]=true;
				DFS(i, cost + map[cur][i], cnt + 1);
				visit[i] = false;
			}
		}
	}
}
