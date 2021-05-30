package BOJ;
import java.io.*;
import java.util.*;

public class BOJ_5052_전화번호목록 {

	static public void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			boolean flag = true;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			ArrayList<String> list = new ArrayList();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String temp = st.nextToken();
				list.add(temp);
			}

			Collections.sort(list);

			for (int i = 0; i+1 < N; i++) {
				String cur = list.get(i);
				if (list.get(i + 1).startsWith(cur)) {
					flag = false;
				}

			}

			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}// main
}
