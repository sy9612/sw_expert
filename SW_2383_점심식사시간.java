import java.awt.Point;
import java.io.*;
import java.util.*;

public class SW_2383_점심식사시간 {
	static int min = Integer.MAX_VALUE;
	static ArrayList<Point> person = new ArrayList();// 계단2로 갈 사람들
	static boolean person_check[];
	static int stairs1[] = new int[10];
	static int stairs2[] = new int[10];
	static Point stair1 = new Point();
	static Point stair2 = new Point();
	static int res = 0;
	static int map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 1) {
						if (stair1 == null) {
							stair1.x = i;
							stair1.y = j;
						} else {
							stair2.x = i;
							stair2.y = j;
						}
					} else if (map[i][j] == 1) {
						person.add(new Point(i, j));
					}
				}
			}

			person_check = new boolean[person.size()];
			Solve(0);

			System.out.println("#" + test_case + " " + res);
		} // for
	}// main

	public static void Solve(int cnt) {
		if (cnt == person.size()) {
			Calc();
			return;
		}

		for(int i=0; i<person.size(); i++) {
			person_check[i] = true;
			Solve(cnt+1);
			person_check[i] = false;
		}
	}

	public static void Calc() {
		// 거리 계산
		for (int i = 0; i < person_check.length; i++) {
			if (person_check[i]) {
				stairs1[i] = Math.abs(person.get(i).x - stair1.x) + Math.abs(person.get(i).y - stair1.y) + 1;
			} else {
				stairs2[i] = Math.abs(person.get(i).x - stair2.x) + Math.abs(person.get(i).y - stair2.y) + 1;
			}
		}
		Arrays.sort(stairs1);
		Arrays.sort(stairs2);
		
		int idx = 0;
		int val = stairs1[0];
		for(int i=0; i<stairs1.length - 1; i++) {
			if(stairs1[i] == stairs1[i+1]) {
				idx++;
			}
			else {
				val += map[stair1.x][stair1.y];
			}
		}
	}//Calc
}
