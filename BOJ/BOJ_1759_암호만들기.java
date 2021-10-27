import java.io.*;
import java.util.*;

public class BOJ_1759_암호만들기 {
	static int L, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		char[] alphabet = new char[C];
		for (int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alphabet);
		Solve(0, 0, new boolean[C], alphabet);

		System.out.println();
	}// main

	public static void Solve(int idx, int cnt, boolean[] visit, char[] alphabet) {
		if (cnt == L) {
			int mo = 0, za = 0;
			String str = "";
			for (int i = 0; i < C; i++) {
				if (visit[i]) {
					str += alphabet[i];
					if(alphabet[i] == 'a' || alphabet[i] == 'e' || alphabet[i] == 'i' || alphabet[i] == 'o' || alphabet[i] == 'u')
						mo ++;
					else
						za ++;
				}
			}
			if(mo >= 1 && za >= 2) {
				System.out.println(str);
			}
			return;
		}

		for (int j = idx; j < C; j++) {
			if (!visit[j]) {
				visit[j] = true;
				Solve(j + 1, cnt + 1, visit, alphabet);
				visit[j] = false;
			}

		}

	}// Solve
}

