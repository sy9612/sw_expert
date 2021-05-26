import java.io.*;
import java.util.StringTokenizer;
 
public class BOJ_2961 {
 
    static int[][] taste;
    static boolean[] visit;
    static int n, min;
 
    private static void food(int index, int sour, int bitter) {
        if (index == n) {
            if (min > Math.abs(sour - bitter) && bitter != 0) {
                min = Math.abs(sour - bitter);
            }
            return;
        }
 
        visit[index] = true;
        food(index + 1, sour * taste[0][index], bitter + taste[1][index]);
        visit[index] = false;
        food(index + 1, sour, bitter);
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        taste = new int[2][n];
        visit = new boolean[n];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            taste[0][i] = Integer.parseInt(st.nextToken());
            taste[1][i] = Integer.parseInt(st.nextToken());
        }
        food(0, 1, 0);
        System.out.println(min);
    }
}
