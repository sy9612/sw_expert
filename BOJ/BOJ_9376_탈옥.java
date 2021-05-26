import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_9376_탈옥 {
	static int h,w;
	static int map[][];
	static Point[] prisoner;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt( st.nextToken());
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt( st.nextToken());
			w = Integer.parseInt( st.nextToken());
			map = new int[h][w];
			prisoner = new Point[2];
			int idx = 0;
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt( st.nextToken());
					if(map[i][j] == '$') {
						prisoner[idx++] = new Point(i, j);
					}
				}
			}
			System.out.println();
		}
		
		
	}
}
