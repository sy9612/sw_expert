

import java.util.*;
import java.io.*;

public class PG_67258_보석쇼핑 {
	static public void main(String[] args) throws Exception {
		String[] gems = { "AA", "AB", "AC", "AA", "AC" };
		int[] arr = solution(gems);
		System.out.print(arr[0]);
		System.out.print(", ");
		System.out.print(arr[1]);
		System.out.println();

	}// main

	static public int[] solution(String[] gems) {
		int[] answer = new int[2];
		int start = 0, end = -1;
		int a_start = 0, a_end = 0;
		int size = Integer.MAX_VALUE;
		HashSet<String> set = new HashSet();
		HashMap<String, Integer> map = new HashMap();
		for (int i = 0; i < gems.length; i++)
			set.add(gems[i]);

		while (start < gems.length) {
			if (map.size() == set.size()) {
				if (size > end - start + 1) {
					size = end - start + 1;
					a_start = start;
					a_end = end;

				}
				int val = map.get(gems[start]);
				if (val == 1)
					map.remove(gems[start]);
				else
					map.put(gems[start], val - 1);
				start++;
			} else {
				if (end + 1 < gems.length) {
					end++;
					if (map.containsKey(gems[end])) {
						int val = map.get(gems[end]);
						map.put(gems[end], val + 1);
					}
					else {
						map.put(gems[end], 1);
					}
				} else
					break;
			}
		}

		answer[0] = a_start + 1;
		answer[1] = a_end + 1;
		return answer;
	}

	static public boolean Check(String[] gems, int start, int end, int size) {
		HashSet<String> ans = new HashSet();
		for (int i = start; i <= end; i++)
			ans.add(gems[i]);
		if (ans.size() == size)
			return true;
		else
			return false;
	}
}
