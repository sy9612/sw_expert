import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SW_1225 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
	
		boolean flag;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			flag = true;
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				int N = sc.nextInt();
				q.add(N);
			}
			
			while (flag) {
				for (int i = 1; i <= 5; i++) {
					int temp = q.peek() - i;
					
					if (temp <= 0) {
						temp = 0;
						flag = false;
						q.poll();
						q.offer(temp);
						break;
					}
					q.poll();
					q.offer(temp);
				}
			}

			System.out.print("#" + T + " ");
			while(!q.isEmpty()) {
				System.out.print(q.peek() + " ");
				q.poll();
			}
			System.out.println();
		}
	}
}