import java.util.*; 

class Solution {
    
    static int map[][], answer[];
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        
        int N = arr.length;
        map = arr; 
        
        solve(0, 0, N); 
        
        return answer;
    }
    
    static void solve(int r, int c, int len){
        if(len == 1){
            answer[map[r][c]]++; 
            return; 
        }
        
        int num = map[r][c];
        boolean same = true;
        
        for(int i=r; i<r+len; i++){
            for(int j=c; j<c+len; j++){
                if(map[i][j] != num){
                    same = false; 
                    break; 
                }
            }
        }
        
        if(same){
            answer[num]++;
            return;
        }else{
            solve(r, c, len/2);
            solve(r + len/2, c, len/2);
            solve(r, c + len/2, len/2);
            solve(r+ len/2, c + len/2, len/2);
        }
    }
}