import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {
	static int bingo[][] = new int[5][5];
	static int chair[][] = new int[5][5];
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {// 빙고 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {// 사회자가 부른 수 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				chair[i][j] = Integer.parseInt(st.nextToken());
				ans++;
				Erase(chair[i][j]);
				if(Check()) {
					System.out.println(ans);
					return;
				}
			}
		}
	}

	public static void Erase(int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(bingo[i][j] == num)
					bingo[i][j] = 0;
			}
		}
	}

	public static boolean Check() {
		int line = 0;
		int cnt = 0;
		//가로 확인
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			for (int j = 0; j < 5; j++) {
				if(bingo[i][j] == 0)
					cnt++;
			}
			if(cnt == 5)
				line++;
		}
		//세로 확인
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			for (int j = 0; j < 5; j++) {
				if(bingo[j][i] == 0)
					cnt++;
			}
			if(cnt == 5)
				line++;
		}
		//대각선 확인
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if(bingo[i][i] == 0)
				cnt++;
		}
		if(cnt == 5)
			line++;
		
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if(bingo[i][4-i] == 0)
				cnt++;
		}
		if(cnt == 5)
			line++;
		/////////////////////////////
		if(line >= 3) {
			return true;
		}
		return false;
	}
}
