import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
	public static StringTokenizer st;
	public static void main(String args[])throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i,j;
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		Stack<Integer> s = new Stack<>();
		Stack<Integer> idx = new Stack<>();

		
        st = new StringTokenizer(br.readLine());

        s.push(0);
        idx.push(0);
        for (i = 1; i <= N; i++) {
        	boolean flag = true;
            int num = Integer.parseInt(st.nextToken());
            if(s.peek() <= num) {
            	while(!s.empty()) {
            		if(num < s.peek()) {
            			flag = false;
                    	System.out.print(idx.peek() + " ");
            			break;
            		}
            		s.pop();
            		idx.pop();
            	}
            	if(flag) {
                	System.out.print("0 ");
        		}
            	
            	s.push(num);
            	idx.push(i);
            }
            else {
            	System.out.print(idx.peek() + " ");
            	s.push(num);
            	idx.push(i);

            }
        }
		
        br.close();
		bw.flush();
		bw.close();
	}
}
