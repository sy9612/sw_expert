import java.util.*;
import java.io.*;

public class BOJ_15591_moodtube {
	static int N, Q;
	static ArrayList<USADO> list = new ArrayList();
	static class USADO {
		int p;
		int q;
		int r;

		USADO(int p, int q, int r) {
			this.p = p;
			this.q = q;
			this.r = r;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N - 1; i++) {
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			list.add(new USADO(p,q,r));
		}
		
		for(int i=0;i<Q; i++) {
			
		}
	}

}
