package PROGRAMMERS;
import java.util.*;

public class PG_12936_줄서는방법 {
	static public void main(String[] args) throws Exception {
		int n = 3;
		long k = 5;
		System.out.println(solution(n, k));
	}// main

	static public int[] solution(int n, long k) {
		int[] answer = new int[n];
		ArrayList<Integer> arr = new ArrayList();
		long fac = 1;
		for (int i = 1; i <= n; i++) {
			fac *= i;
			arr.add(i);
		}
		k -= 1;
		int idx = 0;
		
		while (n > 0) {
			fac /= n;
			answer[idx++] = arr.get((int) (k / fac));
			arr.remove((int) (k / fac));
			k %= fac;
			n--;
		}
		return answer;
	}

}
