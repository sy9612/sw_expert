import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_2115 {
	static int N, M, C;
	static int map[][];
	static int ans = 0;
	static int worker1;
	static int worker2;
	static int temp1;
	static int temp2;
	static ArrayList<Integer> arr1;
	static ArrayList<Integer> arr2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			ans = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			worker1 = 0;
			worker2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					Choose1(i, j);
				}
			}

			System.out.println("#" + test_case + " " + ans);
		}
	}

	public static void Choose1(int x, int y) {
		arr1 = new ArrayList();
		int i;
		for (i = 0; i < M; i++) {
			arr1.add(map[x][y + i]);
		}

		Choose2(x, y);
	}

	public static void Choose2(int x, int y) {
		

		for (int i = x; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				if (i == x && j <= (y + M - 1))
					continue;
				arr2 = new ArrayList();
				for (int k = 0; i < M; i++) {
					arr2.add(map[x][y + k]);
				}
				Calc();
			}
		}

		
	}

	public static void Calc() {
		arr1.sort(null);
		arr2.sort(null);
		int temp = 0;
		int mtemp = 0;
		int mmtemp = 0;
		for(int i=0; i<arr1.size(); i++) {
			for(int j=i; j<arr1.size(); j++) {
				temp += arr1.get(j);
				if(temp > C)
					break;
				mtemp += arr1.get(j) * arr1.get(j);
			}
			Math.max(mmtemp, mtemp);
				
		}

	}
}
