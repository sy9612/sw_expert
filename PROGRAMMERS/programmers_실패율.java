import java.util.ArrayList;

public class programmers_실패율 {
	public static class Node implements Comparable<Node>{
		int stage;
		double fail;
		public Node() {}
		public Node(int stage, double fail) {
			this.stage = stage;
			this.fail = fail;
		}
		@Override
		public int compareTo(Node other) {
			if(this.fail < other.fail)
				return 1;
			else if(this.fail == other.fail) {
				if(this.stage > other.stage)
					return 1;
			}
			return -1;
		}
	}
	public static int[] solution(int N, int[] stages) {
		ArrayList<Node> list = new ArrayList();
		int[] answer = new int[N];
		double [] cplayer = new double[N+2];
		double [] fplayer = new double[N+2];

		for(int i=0; i<stages.length;i++) {
			for(int j=1; j<=stages[i]; j++) {
				if(j == stages[i])
					fplayer[j]++;
				if(j <= stages[i])
					cplayer[j]++;
			}
		}
		
		for(int i=1; i<=N;i++) {
			Node node;
			if(cplayer[i] == 0) {
				node = new Node(i, 0);
			}
			else
				node = new Node(i, (double)(fplayer[i]/cplayer[i]));
			list.add(node);
		}
		
		list.sort(null);
		
		for(int i=0; i<list.size();i++) {
			answer[i] = list.get(i).stage;
		}
		return answer;
	}

	public static void main(String[] args) {
		int N = 4;
		int[] stages = {2, 2, 2, 2, 2, 3};
		int [] result = solution(N, stages);
		System.out.println(result);
	}

}
