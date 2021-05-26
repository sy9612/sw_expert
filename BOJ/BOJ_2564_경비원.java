import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_2564_경비원 {
	static int N, M, C;
	static int res;
	static int dx, dy, dlen;
	static int total = 0;
	static ArrayList<Point> arr = new ArrayList();

	public static void main(String[] args) throws Exception {
		res = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());

		total = (N + M) * 2;

		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr.add(new Point(x, y));
		}
		st = new StringTokenizer(br.readLine());
		dx = Integer.parseInt(st.nextToken());
		dy = Integer.parseInt(st.nextToken());
		dlen = Len(dx, dy);

		for (int i = 0; i < arr.size(); i++) {
			int x = arr.get(i).x;
			int y = arr.get(i).y;
			int len = Len(x, y);
			int mini = Math.abs(len - dlen);
			res += Math.min(mini, total - mini);
		}

		System.out.println(res);
	}// main

	public static int Len(int x, int y) {
		if (x == 1) {
			return y;
		} else if (x == 2) {
			return N * 2 + M - y;
		} else if (x == 3) {
			return N * 2 + M * 2 - y;

		} else if (x == 4) {
			return N + y;
		}
		return 0;
	}
}
