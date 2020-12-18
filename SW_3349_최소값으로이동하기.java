import java.io.*;
import java.util.*;
import java.awt.*;

public class SW_3349_최소값으로이동하기 {
	static int W, H, N, res;
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
				list.add(new Point(x,y));
			}
			
			res = Integer.MIN_VALUE;
					
			Solve();

			System.out.println("#" + test_case + " " + res);
		} // test_case

	}// main
	
	static void Solve() {
		
	}
}
