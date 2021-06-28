package BOJ;
import java.io.*;
import java.util.*;
import java.awt.*;

public class BOJ_2096_내려가기 {
	static int N, max, min = Integer.MAX_VALUE;
	static int[][] dp_max = new int[2][3];
	static int[][] dp_min = new int[2][3];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < 3; j++) {
			dp_max[0][j] = Integer.parseInt(st.nextToken());
			dp_min[0][j] = dp_max[0][j];
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				dp_max[1][j] = Integer.parseInt(st.nextToken());
				dp_min[1][j] = dp_max[1][j];
			}

			dp_max[1][0] += Math.max(dp_max[0][0], dp_max[0][1]);
			dp_max[1][1] += Math.max(dp_max[0][0], Math.max(dp_max[0][1], dp_max[0][2]));
			dp_max[1][2] += Math.max(dp_max[0][1], dp_max[0][2]);

			dp_min[1][0] += Math.min(dp_min[0][0], dp_min[0][1]);
			dp_min[1][1] += Math.min(dp_min[0][0], Math.min(dp_min[0][1], dp_min[0][2]));
			dp_min[1][2] += Math.min(dp_min[0][1], dp_min[0][2]);

			for (int j = 0; j < 3; j++) {
				dp_max[0][j] = dp_max[1][j];
				dp_min[0][j] = dp_min[1][j];
			}
		}

		for (int j = 0; j < 3; j++) {
			if (dp_max[0][j] > max)
				max = dp_max[0][j];
			if (dp_min[0][j] < min)
				min = dp_min[0][j];
		}

		StringBuilder sb = new StringBuilder();
		sb.append(max);
		sb.append(" ");
		sb.append(min);
		System.out.println(sb);

	}// main
}
