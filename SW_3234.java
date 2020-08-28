import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//오른쪽 위에 올라가 있는 무게의 총합이 
//왼쪽에 올라가 있는 무게의 총합보다 더 커져서는 안 됨
public class SW_3234 {
	static int N;
	static int ans;
	static int sum;
	static int[] pow, fac, w;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		preProcess();
		for (int test_case = 1; test_case <= T; test_case++) {
			ans = 0;
			sum = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			w = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				w[i] = Integer.parseInt(st.nextToken());
				sum += w[i];
			}
			makePermutation(N, new boolean[N], 0, 0, sum);
			System.out.println("#" + test_case + " " + ans);
		}
	}

	public static void makePermutation(int n, boolean []visit, int left, int right, int remain) {
		if(right > left)
			return;
		if(left > right + remain) {
			ans += pow[n] * fac[n];
			return;
		}
		if(n == 0) {
			ans++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				makePermutation(n-1, visit, left+w[i], right, remain -w[i]); //왼쪽에 넣는 경우
				makePermutation(n-1, visit, left, right+w[i], remain -w[i]); //오른쪽에 넣는 경우
				visit[i] = false;
			}
			
			
		}
	}

	static void preProcess() {
		pow = new int[10];
		fac = new int[10];

		pow[0] = fac[0] = 1;
		for (int i = 1; i < pow.length; i++) {
			pow[i] = pow[i - 1] * 2;
			fac[i] = fac[i - 1] * i;
		}
	}
}
