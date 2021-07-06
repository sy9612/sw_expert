package BOJ;
import java.io.*;
import java.util.*;

public class BOJ_17298_오큰수 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Stack<Integer> s = new Stack();
		int[] answer = new int[N];
		Arrays.fill(answer, -1);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			answer[i] = temp;
		}

		s.add(0);
		for (int i = 1; i < N; i++) {
			if (answer[i] > answer[s.peek()]) {
				while (!s.isEmpty() && answer[i] > answer[s.peek()])
					answer[s.pop()] = answer[i];
			}
			s.add(i);
		}

		while (!s.isEmpty()) {
			answer[s.pop()] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}// main
}
