import java.util.*;
import java.io.*;

public class pro_소수찾기 {
	
	public static void main(String[] args) throws IOException {
		String numbers = "17"; //011
		int result = solution(numbers);
		System.out.println(result);
	}//main
	
    static int answer = 0;
    static Set <Integer> set = new HashSet();
    static boolean visit[];


	static public int solution(String numbers) {
		int size = numbers.length();
		 int[] arr = new int[size];
		 for(int i=0; i<numbers.length(); i++)
		 	arr[i] = numbers.charAt(i) - '0';
		 Arrays.sort(arr);
		// 결과를 저장할 리스트
		List<Character> result = new ArrayList<>();
		visit = new boolean[numbers.length()];

		// nPr에서 r을 계속 늘리면서 순열 알고리즘 수행
		for (int i = 0; i < size; i++) {
			int[] list = new int[i + 1];
			permutation( arr, 0, i + 1, list);
		}

		answer = set.size();
		return answer;
    }//solution
	
	static public void permutation(int [] arr, int n, int r, int [] list) {
		if(n == r) {
			String str ="";
			for(int i=0; i<list.length; i++) {
				str += list[i];
			}//for
			isPrime(Integer.parseInt(str));
			//set.add(Integer.parseInt(str));
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				list[n] = arr[i];
				permutation( arr, n+1, r, list);
				visit[i] = false;
			}
		}
		
	}
	static public void isPrime(int num) {
			if(num <= 1)
				return;
			
			for(int j=2; j<=Math.sqrt(num); j++) {
				if(num % j == 0)
					return;
			}
			
			set.add(num);
	
	}//isPrime
}
