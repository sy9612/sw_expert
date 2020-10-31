import java.io.*;
import java.util.*;

public class BOJ_8958_OX퀴즈 {
	static ArrayList<Character> list = new ArrayList();
	static int arr[];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int res = 0;
			char cur = ' ';
			char prev = ' ';
			String str = sc.next();
			prev = str.charAt(0);
			arr = new int[str.length()];
			if(prev == 'O') {
				arr[0] = 1;
				res += arr[0];
			}
			
			for (int i = 1; i < str.length(); i++) {
				cur = str.charAt(i);
				if(cur == 'O') {
					if(prev == cur) {
						arr[i] = arr[i-1] + 1;
						res += arr[i];
					}
					else {
						arr[i] = 1;
						res += arr[i];
					}
				}
				prev = cur;
			}
			System.out.println(res);
		}
	}
}
