import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
	static int N, K;
	static int W[];
	static int V[];
	static int D[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N];
		V = new int[N];
		D = new int[K + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = K; j >= W[i]; j--) {
				if (D[j] < D[j - W[i]] + V[i])
					D[j] = D[j - W[i]] + V[i];

			}
		}

		System.out.println(D[K]);
	}
}
