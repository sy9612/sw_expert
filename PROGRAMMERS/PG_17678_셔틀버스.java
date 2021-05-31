package PROGRAMMERS;
import java.io.*;
import java.util.*;
import java.awt.*;

public class PG_17678_셔틀버스 {
	public static class C {
		int crew;
		ArrayList<Point> time = new ArrayList();

		C(int crew, int hour, int minu) {
			this.crew = crew;
			time.add(new Point(hour, minu));
			time.sort(null);
		}

		C(int hour, int minu) {
			time.add(new Point(hour, minu));
			time.sort(null);
		}
	}

	static public void main(String[] args) throws Exception {
		int n = 2;
		int t = 10;
		int m = 1;
		String[] timetable = { "00:01", "00:01", "00:01" };
		solution(n, t, m, timetable);

	}// main

	// n:셔틀 운행 횟수
	// t: 셔틀 운행 간격
	// m: 최대 크루 수
	static public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		int ahour = -1, aminu = -1;
		Point[] shuttle = new Point[n + 1];
		C[] crew = new C[n + 1];
		boolean[] visit = new boolean[timetable.length];
		// 1. 사람들 온 시간 순으로 정렬
		Arrays.sort(timetable);
		// 2. 셔틀 오는 시간 계산
		int hour = 9;
		int minu = 0;
		for (int i = 1; i <= n; i++) {
			shuttle[i] = new Point(hour, minu);
			minu += t;
			if (minu >= 60) {
				hour++;
				minu -= 60;
			}
		}
		// 3. 셔틀 오는 시간에 남는 자 계산
		for (int i = 0; i < timetable.length; i++) {
			String temp = timetable[i];
			String[] arr = temp.split(":");
			hour = Integer.parseInt(arr[0]);
			minu = Integer.parseInt(arr[1]);
			for (int j = 1; j <= n; j++) {
				int time = shuttle[j].x * 60 + shuttle[j].y;// 셔틀시간 계산
				if (time >= hour * 60 + minu && (crew[j] == null || crew[j].crew < m)) {
					if (!visit[i]) {
						if (crew[j] != null) {
							crew[j].crew++;
							crew[j].time.add(new Point(hour, minu));
						} else
							crew[j] = new C(1, hour, minu);

						visit[i] = true;
					}
				}
			}
		}

		// 4. 마지막 차의 자리가 남으면 타기
		// 5. 자리가 안 남으면
		if (crew[n] == null || crew[n].crew < m) {
			ahour = shuttle[n].x;
			aminu = shuttle[n].y;
		} else {
			ArrayList<Point> times = crew[n].time;
			if (m > 1) {
				Point cur = times.get(m - 2);
				Point next = times.get(m - 1);
				if (cur.x * 60 + cur.y == next.x * 60 + next.y) {
					ahour = cur.x;
					aminu = cur.y - 1;
					if (aminu == -1) {
						aminu = 59;
						ahour -= 1;
					}
				} else {
					ahour = cur.x;
					aminu = cur.y;
				}
			}
			else {
				Point cur = times.get(m - 1);
				ahour = cur.x;
				aminu = cur.y - 1;
				if (aminu == -1) {
					aminu = 59;
					ahour -= 1;
				}
			}

		}

		// 결과 출력
		String answer_h = String.valueOf(ahour);
		String answer_m = String.valueOf(aminu);
		if (answer_h.length() != 2)
			answer_h = "0" + answer_h;
		if (answer_m.length() != 2)
			answer_m = "0" + answer_m;
		answer = answer_h + ":" + answer_m;
		System.out.println(answer);
		return answer;
	}// Solution
}
