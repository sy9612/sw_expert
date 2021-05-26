import java.awt.*;
import java.io.*;
import java.util.*;

public class BOJ_14499_주사위굴리기 {
	static int N, M, x, y, K;
	static int map[][];
	static int arr[] = new int[7];

	static class Dice {
		int bottom;
		int top;
		int front;
		int back;
		int right;
		int left;

		Dice(int bottom, int top, int front, int back, int right, int left) {
			this.bottom = bottom;
			this.top = top;
			this.front = front;
			this.back = back;
			this.right = right;
			this.left = left;
		}

	}

	static int dx[] = { 0, 0, 0, -1, 1 };
	static int dy[] = { 0, 1, -1, 0, 0 };
	static Dice dice = new Dice(0, 0, 0, 0, 0, 0);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int temp = Integer.parseInt(st.nextToken());
			Solve(temp);
		}
	}// main

	public static void Solve(int d) {

		if (x + dx[d] < 0 || x + dx[d] >= N || y + dy[d] < 0 || y + dy[d] >= M)
			return;

		x += dx[d];
		y += dy[d];

		int bottom = dice.bottom;
		int top = dice.top;
		int front = dice.front;
		int back = dice.back;
		int right = dice.right;
		int left = dice.left;

		switch (d) {
		case 1:
			dice.bottom = right;
			dice.top = left;
			dice.left = bottom;
			dice.right = top;
			break;
		case 2:
			dice.bottom = left;
			dice.top = right;
			dice.left = top;
			dice.right = bottom;
			break;
		case 3:
			dice.bottom = back;
			dice.top = front;
			dice.front = bottom;
			dice.back = top;
			break;
		case 4:
			dice.bottom = front;
			dice.top = back;
			dice.front = top;
			dice.back = bottom;
			break;
		}

		if (map[x][y] == 0) {
			map[x][y] = dice.bottom;
		} else {
			dice.bottom = map[x][y];
			map[x][y] = 0;
		}

		System.out.println(dice.top);

	}// Solve

}
