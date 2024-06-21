class Solution {
    
    static boolean[][] v; 
    
    public int solution(String dirs) {
        int answer = 0;
        
        v = new boolean[121][4];
        
        char[] dir = dirs.toCharArray(); 
        
        int curX = 5; 
        int curY = 5; 
        
        for(char c : dir){
            int nx = 0;
            int ny = 0;
            int d = 0; 
            int r = 0; 
            switch(c){
                case 'U' :
                    nx = curX;
                    ny = curY-1; 
                    d = 0;
                    r = 1; 
                    break;
                case 'D' :
                    nx = curX;
                    ny = curY+1; 
                    d = 1;
                    r = 0; 
                    break;
                case 'R' :
                    nx = curX+1;
                    ny = curY; 
                    d = 2;
                    r = 3; 
                    break;
                case 'L' :
                    nx = curX-1;
                    ny = curY;
                    d = 3;
                    r = 2; 
                    break; 
            }
            
            // System.out.printf("방향 %c : x %d -> %d, y %d -> %d \n", c, curX, nx, curY, ny);
            
            // 범위 넘어감
            if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;
            
            int idx = nx * 11 + ny;     
            if(!v[idx][d]){
                v[idx][d] = true;
                v[curX * 11 + curY][r] = true;
                answer++; 
                System.out.printf("마킹!\n"); 
            } 
            curX = nx; 
            curY = ny; 
        }
        
        
        // for(boolean[] arr : v){
        //     for(boolean b : arr){
        //         if(b) answer++; 
        //     }
        // }
        
        
        return answer;
    }
}