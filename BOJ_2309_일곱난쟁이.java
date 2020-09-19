import java.io.*;
import java.util.ArrayList;

public class BOJ_2309_일곱난쟁이 {
	static int src[] = new int[9];
	static int arr[] = new int[9];
	static boolean flag = false;
	static int sum = 0;
	static ArrayList<Integer> list = new ArrayList();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			src[i] = i;
		}
		
		makecombination(0, 0, new int[2]);
	}
	
	public static void makecombination(int n, int start, int[] temp) {
		if(flag)
			return;
		
		if(n == 2) {
			int s = 0;
			for(int i=0; i<temp.length; i++) {
				s += arr[temp[i]];
			}
			if((sum - s) == 100 && !flag) {
				flag = true;
				for(int i=0; i<arr.length; i++) {
					if(i == temp[0] || i == temp[1])
						continue;
					list.add(arr[i]);
				}
				list.sort(null);
				for(int i=0; i<list.size(); i++) {
					System.out.println(list.get(i));
				}
			}
			return;
		}
		
		for(int i=start; i<src.length; i++) {
			temp[n] = src[i];
			makecombination(n+1, i+1, temp);
		}
	}
}
