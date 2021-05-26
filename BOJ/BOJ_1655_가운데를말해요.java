import java.io.*;
import java.util.*;

public class BOJ_1655_가운데를말해요 {
	static int N;
	static int arr[];
	static PriorityQueue<Integer> min = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
	static PriorityQueue<Integer> max = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(max.size() == min.size())
				max.add(temp);
			else
				min.add(temp);
			
			if(!max.isEmpty() && !min.isEmpty()) {
				if(max.peek() > min.peek()) {
					int a = max.poll();
					int b = min.poll();
					max.add(b);
					min.add(a);
				}
				
			}
			
			System.out.println(max.peek());
		}

	}
}
