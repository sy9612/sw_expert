import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
	static int N;
	static boolean map[][] = new boolean [100][100];
	static Point arr[];
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		for(int k=0; k<N; k++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int i=a; i<a+10; i++) {
				for(int j=b; j<b+10; j++) {
					map[i][j] = true;
				}
			}
			
		}
		
		////색종이 넓이 구하기
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j])
					ans++;
			}
		}
		System.out.println(ans);
	}
}
