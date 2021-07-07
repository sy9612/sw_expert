package BOJ;
import java.io.*;
import java.util.*;

public class BOJ_19942_다이어트 {
	static int N;

	public static void main(String[] args) throws Exception {
		int min = 0;
		ArrayList<Integer> answer = new ArrayList();
		int[] arr = new int[4];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][5];

		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < 4; j++) {
			arr[j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (answer.size() == 0)
			System.out.println(-1);
		else {
			System.out.println(min);
			for (int i = 0; i < answer.size(); i++) {
				System.out.print(answer.get(i));
			}
			System.out.println();
		}
	}// main
}
