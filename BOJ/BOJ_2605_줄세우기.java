import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2605_줄세우기 {
	static int N;
	static int arr[];
	static ArrayList<Integer> temp = new ArrayList();
	static int list[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		list = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=N; i++) {
			list[i] = i;
			for(int j=i; j>i - arr[i]; j--) {
				int temp = list[j-1];
				list[j-1] = list[j];
				list[j] = temp;
			}
		}
		
		for(int i=1; i<list.length; i++)
			System.out.print(list[i] + " ");
	}
}
