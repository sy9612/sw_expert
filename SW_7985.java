import java.util.*;
import java.io.FileInputStream;
 
class Solution {
     
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int K = sc.nextInt();
            int N = (int) Math.pow(2, K);
            int arr[] = new int[N + 1];
            int H = K;
            int cnt = 0;
 
            //StringBuilder sb = new StringBuilder();
            //sb.append("#").append(" ").append(test_case).append(" ");
 
            System.out.print("#" + test_case + " ");
            for (int i = 1; i <= N -1; i++) {
                arr[i] = sc.nextInt();
            }
 
            Queue<Integer> q = new LinkedList<>();
            q.offer(N / 2);//시작 루트
 
            while (cnt != N-1) {
                 
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int cur = q.peek();
                    cnt++;
                    q.poll();
                    //sb.append(arr[cur]).append(" ");
                    System.out.print(arr[cur] + " ");
                    int left = cur - (int) Math.pow(2, H-2);//왼쪽 자식
                    int right = 2 * cur - left;//오른쪽 자식
                    q.offer(left);
                    q.offer(right);
                }
                System.out.println();
                H--;
            }
            //System.out.print(sb);
             
        }
    }
}