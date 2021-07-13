package BOJ;
import java.io.*;
import java.util.*;

public class BOJ_12904_A와B {
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		String S = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String T = st.nextToken();

		DFS(S, T);

		if (flag)
			System.out.println(1);
		else
			System.out.println(0);

	}// main

	public static void DFS(String cur, String tobe) {
		if (cur.length() == tobe.length()) {
			if (cur.compareTo(tobe) == 0) {
				flag = true;
			}
			return;
		}

		StringBuffer sb = new StringBuffer();
		String temp;
		sb.append(tobe);
		if (sb.charAt(tobe.length() - 1) == 'A') {
			temp = sb.deleteCharAt(tobe.length() - 1).toString();
			DFS(cur, temp);
		} else {
			sb.deleteCharAt(tobe.length() - 1);
			sb.reverse();
			DFS(cur, sb.toString());
		}

	}// DFS
}
