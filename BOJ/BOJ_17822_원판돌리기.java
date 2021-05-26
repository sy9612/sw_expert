import java.awt.*;
import java.io.*;
import java.util.*;

public class BOJ_17822_원판돌리기 {
	static int N, M, T, res;
	static int map[][];
	static Queue<Point> list = new LinkedList();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			Rotate(x, d, k);
			res = Erase();
		}

		System.out.println(res);
	}// main

	public static void Rotate(int x, int d, int k) {
		int i = 0, j = 0, temp = 0;
		for (i = 1; i <= N; i++) {
			if (i % x == 0) {
				if (d == 0) {// 시계
					for (int h = 0; h < k; h++) {
						temp = map[i][M];
						for (j = M; j > 1; j--) {
							map[i][j] = map[i][j - 1];
						}
						map[i][1] = temp;
					}
				} else {// 반시계
					for (int h = 0; h < k; h++) {
						temp = map[i][1];
						for (j = 2; j <= M; j++) {
							map[i][j - 1] = map[i][j];
						}
						map[i][M] = temp;
					}
				}
			}
		}
	}

	public static int Erase() {
		int cnt = 0, sum = 0;
		float average = 0;
		boolean rflag = false;
		// 인접한 수 있으면 같은 수를 모두 지우기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				boolean flag = false;
				if (map[i][j] != 0) {
					if (j - 1 >= 1 && map[i][j] == map[i][j - 1]) {
						list.add(new Point(i,j-1));
						flag = true;
					}
					if (j + 1 <= M && map[i][j] == map[i][j + 1]) {
						list.add(new Point(i,j+1));
						flag = true;
					}
					if (i - 1 >= 1 && map[i][j] == map[i - 1][j]) {
						list.add(new Point(i-1, j));
						flag = true;
					}
					if (i + 1 <= N && map[i][j] == map[i + 1][j]) {
						list.add(new Point(i+1,j));
						flag = true;
					}
					if (j == 1 && map[i][j] == map[i][M]) {
						list.add(new Point(i,M));
						flag = true;
					}
					if (j == M && map[i][j] == map[i][1]) {
						list.add(new Point(i,1));
						flag = true;
					}
					if(flag) {
						list.add(new Point(i,j));
						rflag = true;
					}
				}
			}
		}

		while(!list.isEmpty()) {
			Point p = list.poll();
			map[p.x][p.y] = 0;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] != 0) {
					sum += map[i][j];
					cnt++;
				}
			}
		}

		if (!rflag) {
			average = (float)sum / cnt;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (map[i][j] != 0) {
						if (map[i][j] > average) {
							map[i][j] -= 1;
							sum -= 1;
						} else if (map[i][j] < average) {
							map[i][j] += 1;
							sum += 1;
						}
					}
				}
			}
		}

		
		return sum;
		// 없는 경우 원판에 적힌 수의 평균을 구하고 평균보다 큰 수 1빼기 작은수 1더하기
	}// Erase
}
