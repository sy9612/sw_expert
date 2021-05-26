import java.io.*;
import java.util.*;
import java.awt.*;

public class SW_3349_최소값으로이동하기 {
	static int W, H, N, res, min;
	static ArrayList<Point> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			list = new ArrayList();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Point(x, y));
			}

			res = 0;

			int curx = list.get(0).x;
			int cury = list.get(0).y;
			int destx, desty, h, w;
			for (int i = 1; i < list.size(); i++) {
				destx = list.get(i).x;
				desty = list.get(i).y;

				h = destx - curx;
				w = desty - cury;

				if (h * w < 0)
					res += Math.abs(h) + Math.abs(w);
				else {
					res += Math.min(Math.abs(h), Math.abs(w));
					res += Math.abs(h) > Math.abs(w) ? Math.abs(h) - Math.abs(w):Math.abs(w) - Math.abs(h); 
				}

				curx = destx;
				cury = desty;
			}

			System.out.println("#" + test_case + " " + res);

		} // test_case
	}// main

}
