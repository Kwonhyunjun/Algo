import java.util.*; 

class Solution {
    
    static List<int[]> list;
    
    public int[][] solution(int n) {
        int[][] answer = {};
    
        list = new ArrayList<>(); 
        solve(n, 1, 3, 2); 
        
        answer = new int[list.size()][2]; 
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i); 
        }
        
        return answer;
    }
    
    static void solve(int cnt, int from, int to, int another){
        if(cnt == 1){
            // System.out.printf("from -> to : %d -> %d\n", from, to);
            list.add(new int[]{from, to}); 
            return; 
        }
        
        solve(cnt-1, from, another, to); 
        
        solve(1, from, to, another);
        
        
        solve(cnt-1, another, to, from);
    }
}