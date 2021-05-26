import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_1812_수정이의타일자르기 {
	static class Rectangle implements Comparable<Rectangle> {
		int max, min;

		public Rectangle(int width, int height) {
			min = Math.min(height, width);
			max = Math.max(height, width);
		}

		@Override
		public int compareTo(Rectangle o) {
			return o.min - this.min;
		}
	}
	static int N, M, arr[], cnt;
	static PriorityQueue<Rectangle> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			cnt = 1;
			
			Cut();

			System.out.println("#" + test_case + " " + cnt);
		} // for
	}// main

	public static void Cut() {
		// 제일 큰 타일부터
		Arrays.sort(arr);
		q = new PriorityQueue<Rectangle>();
		q.add(new Rectangle(M, M));

		for (int i = N - 1; i >= 0; i--) {
			Calc(1 << arr[i]);
		}

	}

	public static void Calc(int size) {
		Rectangle r = q.poll();
		// 칸에 들어감 ->
		if (size <= r.min) {
			q.add(new Rectangle(r.min - size, size));
			q.add(new Rectangle(r.min, r.max - size));
		}
		// 칸에 안 들어감 -> ++cnt
		else {
			++cnt;
			q.add(r);
			q.add(new Rectangle(M - size, size));
			q.add(new Rectangle(M, M - size));			
		}
	}
}
