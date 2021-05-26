import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//접시의 수 N, 초밥의 가짓수 d
// 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
public class BOJ_15961 {
	static int N, d, k, c;
	static int ans = 0, cnt = 0;
	static int visit[] = new int[3001];
	static ArrayList<Integer> arr = new ArrayList();
	// static HashMap<Integer, Integer> h = new HashMap();
	static Queue<Integer> q = new LinkedList();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < k; i++) {
			q.add(arr.get(i));
			if (visit[arr.get(i)] == 0)
				cnt++;
			visit[arr.get(i)] += 1;
		}
		if (visit[c] == 0)
			    ans = Math.max(ans, cnt+1);
            else
                ans = Math.max(ans, cnt);

		for (int i = 0; i < N-1; i++) {
			if(visit[q.peek()] == 1)
				cnt--;
			visit[q.peek()] -= 1;
			q.poll();
			
			q.add(arr.get((i+k)%N));
			if (visit[arr.get((i+k)%N)] == 0)
				cnt++;
			visit[arr.get((i+k)%N)] += 1;
			if (visit[c] == 0)
			    ans = Math.max(ans, cnt+1);
            else
                ans = Math.max(ans, cnt);
		}

		System.out.println(ans);
	}

}
