import java.util.Scanner;
import java.util.Stack;

public class SW_1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			Stack<Character> stack = new Stack<>();
			int res = 1;
			int N = sc.nextInt();
			 //w char[N];
			String bits = sc.next();
			char arr[] = bits.toCharArray();
			for(int i=0; i<N; i++) {
				if(arr[i] == '(' || arr[i] == '{' || arr[i] == '<' || arr[i] == '[') {
					stack.push(arr[i]);
				}
				switch(arr[i]) {
				case ')':
					if(stack.peek() == '(')
						stack.pop();
					else
						res = 0;
					break;
				case '}':
					if(stack.peek() == '{')
						stack.pop();
					else
						res = 0;
					break;
				case '>':
					if(stack.peek() == '<')
						stack.pop();
					else
						res = 0;
					break;
				case ']':
					if(stack.peek() == '[')
						stack.pop();
					else
						res = 0;
					break;
				
				}
				
			
			
			}
			
			if(!stack.isEmpty()) {
				res = 0;
			}
			
			System.out.println("#" + test_case + " "+ res);
		}
	}
}
