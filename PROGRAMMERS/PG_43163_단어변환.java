package PROGRAMMERS;
import java.util.*;
import java.io.*;

public class PG_43163_단어변환 {
	static public void main(String[] args) throws Exception {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}

	static int answer = Integer.MAX_VALUE;

	static public int solution(String begin, String target, String[] words) {
		// 한 번에 한 개의 알파벳만 교체 가능
		// words에 있는 단어로만 변환 가능
		DFS(0, begin, new boolean[words.length], target, words);
		return answer;
	}// solution

	static public void DFS(int cnt, String cur, boolean[] visit, String target, String[] words) {
		if (cur.compareTo(target) == 0) {
			answer = Math.min(answer, cnt);
			return;
		}
		for (int i = 0; i < words.length; i++) {
			if (Check(cur, words[i])) {
				if (!visit[i]) {
					visit[i] = true;
					DFS(cnt + 1, words[i], visit, target, words);
					visit[i] = false;
				}
			}
		}
	}

	static public boolean Check(String a, String b) {
		int cnt = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				cnt++;
		}
		if (cnt == 1)
			return true;
		else
			return false;
	}
}
