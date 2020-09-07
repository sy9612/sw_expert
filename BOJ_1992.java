import java.util.Scanner;
 
public class BOJ_1992 {
    private static char map[][];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
 
        map = new char[N][N];
 
        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }
        
        solve(0, 0, N);
        sc.close();
    }
 
    private static boolean isSame(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (map[x][y] != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
 
    private static void solve(int x, int y, int n) {
        if (isSame(x, y, n)) {
            System.out.print(map[x][y]);
            return;
        } 
        
        System.out.print("(");
        int s = n / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                solve(x + s * i, y + s * j, s);
            }
        }
        System.out.print(")");
    }
}