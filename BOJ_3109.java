import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3109 {
	static char map[][];
	static boolean visit[][];
	static int dx[] = { -1, 0, 1 };
	static int dy[] = { 1, 1, 1 };
	static int R, C;
	static int pipe = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			DFS(i, 0);
		}

		System.out.println(pipe);
	}

	public static boolean DFS(int x, int y) {
		int tx, ty;
		if (y == C - 1) {
			pipe++;
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			tx = x + dx[i];
			ty = y + dy[i];
			if (Range(tx, ty) && map[tx][ty] == '.' && !visit[tx][ty]) {
				visit[tx][ty] = true;
				if(DFS(tx, ty))
					return true;
			}
		}
		return false;
	}

	public static boolean Range(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C)
			return true;
		return false;
	}

}
