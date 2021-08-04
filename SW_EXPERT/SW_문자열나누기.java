package SW_EXPERT;
import java.io.*;
import java.util.*;

public class SW_문자열나누기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			solve(0, str, "", new Stack());

		} // test_case
	}// main

	public static void solve(int cnt, String words, String temp, Stack<String> stack) {
		for (int i = cnt; i < words.length(); i++) {
			temp += words.charAt(i);
			
			
			if (stack.contains(temp)) {//이미 있는 단어일
				//앞에 붙이
				String temp2 = stack.peek();
				temp2 += temp;
				if(stack.contains(temp2)) {
					
				}
				else {
					
					solve(i, words, temp2, stack);
				}
					
				//뒤에꺼 가져다가 붙이기
				
			}
			

		}
	}

}
