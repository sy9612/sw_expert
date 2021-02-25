import java.util.*;
import java.io.*;
import java.awt.*;

public class pro_카카오프렌즈컬러링북 {
    static boolean [][] visit;
    static int dx[] = {-1, 0,1, 0};
    static int dy[] = {0,1, 0, -1};

	public static void main(String[] args) throws IOException {
    	int m = 6;
    	int n=4;
    	int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
    	solution(m,n,picture);
    }//main
	
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visit = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] != 0 && !visit[i][j]){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, BFS(i, j, m, n , picture));
                }
            }
        }//for
        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;//몇개
        answer[1] = maxSizeOfOneArea;//가장 큰 영역
        return answer;
    }//solution
    
    public static int BFS(int x, int y, int m, int n, int [][] picture){
        Queue <Point> q = new LinkedList();
        q.add(new Point(x, y));
        visit[x][y] = true;
        int cnt =1;
        while(!q.isEmpty()){
            Point p = q.poll();
            int xx = p.x;
            int yy = p.y;
            
            for(int i=0; i<4; i++) {
            	int tx = xx + dx[i];
            	int ty = yy + dy[i];
            	if(tx <0 || tx >= m || ty < 0 || ty >= n)
            		continue;
            	if(visit[tx][ty] || picture[tx][ty] != picture[x][y])
            		continue;

            	q.add(new Point(tx, ty));
            	visit[tx][ty] = true;
                cnt++;
            }
            
        }
        
        //System.out.println(cnt);
        return cnt;
        
    }//BFS
}