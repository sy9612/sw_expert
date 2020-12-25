import java.util.*;
import java.io.*;

public class BOJ_16967_배열복원하기 {
	static int H, W, X, Y;
	static int A[][], B[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		A = new int[H][W];
		B = new int[H + X][W + Y];

		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int i = 0, j = 0, k = 0, l = 0;
		for (i = 0; i < H; i++) {
			for (j = 0; j < W; j++) {
				if(i<X && j < W)
					A[i][j] = B[i][j];
				else if(i < H && j < Y)
					A[i][j] = B[i][j];
				else if(i >= X && j >= Y)
					A[i][j] = B[i][j] - A[i-X][j-Y];
			}
		}

		for (i = 0; i < H; i++) {
			for (j = 0; j < W; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
}
