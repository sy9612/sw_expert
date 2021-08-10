package BOJ;
import java.awt.*;
import java.io.*;
import java.util.*;

public class BOJ_1647_도시분할계획 {
	static int N, M;

	static class Node implements Comparable<Node>{
		int A;
		int B;
		int C;
		
		Node(int A, int B,int C){
			this.A = A;
			this.B = B;
			this.C = C;
		}

		@Override
		public int compareTo(Node o) {
			return this.C - o.C;
		}
	}

	static ArrayList<Node> list = new ArrayList();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list.add(new Node(A, B, C));
		}

		list.sort(null);
		
		Solve();

		System.out.println();
	}// main

	public static void Solve() {

	}// Solve
}
