import java.io.IOException;
import java.util.*;

public class BOJ_1697 {
	static int mint = 0;
	static int N, K;
	static int arr[] = new int[100001];
	static boolean visit[] = new boolean[100001];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(N);
		visit[N] = true;
        arr[N] = 1;

		while(!q.isEmpty()) {
			int cur = q.peek();
			q.poll();
			if(cur == K)
				break;
			
			if( cur + 1 <= 100000 && visit[cur + 1] ==  false) {
				q.offer(cur+1);
				visit[cur+1] = true;
				arr[cur+1] = arr[cur] + 1;
			}
			
			if(cur - 1 >= 0 && visit[cur - 1] ==  false  ) {
				q.offer(cur - 1);
				visit[cur - 1] = true;
				arr[cur-1] = arr[cur] + 1;
			}
			
			if( cur * 2 <=  100000 &&visit[cur * 2] ==  false ) {
				q.offer(cur * 2);
				visit[cur * 2] = true;
				arr[cur*2] = arr[cur] + 1;
			}
		}
		
		System.out.println(arr[K] - 1);
	}
}
