class Solution {
    static int [][] map = new int[11][11];
    static boolean [][][][] visit = new boolean[11][11][11][11];

    static int[] dx = {-1, 0, 1, 0};//U, R, D, L
    static int[] dy = {0, 1, 0, -1};

    public int solution(String dirs) {
        int answer = 0;
        char [] arr = dirs.toCharArray();
        int fx = 5, fy = 5;
        int tx = fx, ty = fy;
        for(int i=0; i<arr.length; i++){
            char cdir = arr[i];
            int dir = 0;
            if(cdir == 'U')
                dir = 0;
            else if(cdir == 'R')
                dir = 1;
            else if(cdir == 'D')
                dir = 2;
            else 
                dir = 3;
                
            tx = fx + dx[dir];
            ty = fy + dy[dir];
            
            if(tx < 0 || ty < 0 || tx > 10 || ty > 10){
                tx = fx;
                tx = fy;
                continue;
            }
            
            if(!visit[fx][fy][tx][ty]){
                visit[fx][fy][tx][ty] = true;
                visit[tx][ty][fx][fy] = true;
                answer+=1;
            } 
            
            fx = tx;
            fy = ty;
        }
        
        return answer;
    }
}
