import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class JO_1863 {
    static int [] p;
    static int [] r;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        p = new int[n+1];
        r = new int[n+1];  
        
        for(int i = 1; i<=n; i++) {
            p[i] = i;
        }
        
        for(int i = 0; i<m; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            union(a,b);
        }
        
        int cnt = 0;
        for(int i = 1; i<=n; i++) {
            if(i == p[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    public static int find(int x) {
        if(x == p[x]) {
            return x;
        }
        p[x] = find(p[x]);
        return p[x];
    }
    
    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(r[px]<r[py]) { 
            p[px] = py;  
        }
        else {
            p[py] = px;
            if(r[px] == r[py]) {
                r[px]++;
            }
        }
    }
 
}