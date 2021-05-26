import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_3190_뱀 {
	static ArrayList<Integer> snake_x = new ArrayList();
	static ArrayList<Character> snake_c = new ArrayList();
	static int sec;
	static int N, L, K;
	static int SNAKE = 2;
	static int APPLE = 3;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int map[][];
	static Deque<Point> dq = new ArrayDeque();

	static class Snake {
		int len;
		int d;

		Snake(int len, int d) {
			this.len = len;
			this.d = d;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		// 사과 입력
		K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x - 1][y - 1] = APPLE;
		}

		L = sc.nextInt();
		for (int i = 0; i < L; i++) {
			int x = sc.nextInt();
			char c = sc.next().charAt(0);
			snake_x.add(x);
			snake_c.add(c);
		}

		Move();

	}// main

	public static void Move() {
		Snake s = new Snake(1, 1);
		int idx = 0;
		// 다음 칸에 머리 위치
		dq.add(new Point(0, 0));
		while (true) {
			sec++;
			// 이동
			// for (int j = 0; j < snake_x.get(i); j++) {
			int tx = dq.peekFirst().x + dx[s.d];
			int ty = dq.peekFirst().y + dy[s.d];
			if (tx < 0 || tx >= N || ty < 0 || ty >= N) {
				System.out.println(sec);
				return;
			}
			if (map[tx][ty] == APPLE) {// 사과 있으면 사과 없애고 꼬리 안 움직임
				s.len++;
			} else if (map[tx][ty] == 0) {// 사과 없으면 몸 길이 줄여 꼬리 위치 0
				Point p = dq.pollLast();
				map[p.x][p.y] = 0;
			} else {
				System.out.println(sec);
				return;
			}

			// 뱀 재배치
			dq.addFirst(new Point(tx, ty));
			map[tx][ty] = SNAKE;
			//Print();

			// 방향 전환
			if (idx < L && snake_x.get(idx) == sec) {
				if (snake_c.get(idx) == 'L') {
					s.d = (s.d + 3) % 4;
				} else {
					s.d = (s.d + 1) % 4;
				}
				idx++;
			}
		} // L

	}// Move

	static void Print() {
		System.out.println("# " + sec);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
