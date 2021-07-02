package PROGRAMMERS;
import java.util.*;
import java.io.*;

public class PG_위장 {

	class Solution {
		public int solution(String[][] clothes) {
			int answer = 0;
			HashMap<String, Integer> map = new HashMap();
			for (int i = 0; i < clothes.length; i++) {
				if (map.get(clothes[i][1]) == null) {
					map.put(clothes[i][1], 1);
				} else {
					map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
				}
			}
			int mul = 1;
			for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
				mul *= (entry.getValue() + 1);
			}
			answer += mul;
			answer -= 1;
			return answer;
		}
	}
}
