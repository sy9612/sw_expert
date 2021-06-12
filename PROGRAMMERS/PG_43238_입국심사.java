package PROGRAMMERS;
import java.util.*;

public class PG_43238_입국심사 {
	static public void main(String[] args) throws Exception {
		int n = 1000000000;
		int[] times = { 1000000000 };
		System.out.println(solution(n, times));

	}// main

	static public long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		ArrayList<Long> arr = new ArrayList();
		Arrays.sort(times);

		long min = 0;
		long max = (long)n * 1000000000;
		long mid, sum;

		while (min <= max) {
			mid = (min + max) / 2;
			sum = 0;
			for (int i = 0; i < times.length; i++) {
				sum += mid / times[i];
			}

			if (sum >= n) {
				max = mid - 1;
				answer = Math.min(answer, mid);
			} else {
				min = mid + 1;
			}
		}

		return answer;
	}
}
