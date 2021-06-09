import java.util.*;

public class PG_42627_디스크컨트롤러 {
	static public void main(String[] args) throws Exception {
		int[][] jobs = { { 0, 10 }, { 2, 3 }, { 9,3 } };
		//{ 0, 3 }, { 4, 3 }, { 10,3 }
		System.out.println(solution(jobs));

	}// main

	static public int solution(int[][] jobs) {// 요청 시점,소요시간
		int answer = 0;
		int cur = -1, time = 0;
		boolean visit[] = new boolean[jobs.length];

		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] t1, int[] t2) {
				if (t1[0] == t2[0])
					return t1[1] - t2[1];
				else
					return t1[0] - t2[0];
			}
		});
		
		while (!Check(visit)) {
			cur = -1;
			for (int i = 0; i < jobs.length; i++) {
				if (!visit[i]) {
					if (time >= jobs[i][0]) {
						if (cur == -1) {
							cur = i;
						} else {
							if (jobs[cur][1] > jobs[i][1]) {
								cur = i;
							}
						}
					}

				}
			}

			if (cur == -1) {
				for (int i = 0; i < jobs.length; i++) {
					if (!visit[i]) {
						cur = i;
						time = jobs[cur][0];
						break;
					}
				}
			}

			time += jobs[cur][1];
			answer += time - jobs[cur][0];
			visit[cur] = true;
		}
		answer /= jobs.length;
		return answer;
	}

	static public boolean Check(boolean[] visit) {
		for (int i = 0; i < visit.length; i++) {
			if (!visit[i])
				return false;
		}
		return true;
	}// Check

}
