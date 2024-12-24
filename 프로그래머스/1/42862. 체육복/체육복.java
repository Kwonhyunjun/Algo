import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] clothes = new int[n+1];
        
        Arrays.fill(clothes, 1);
        clothes[0] = -1;
        for(int l : lost){
            clothes[l]--;
        }
        
        for(int r : reserve){
            clothes[r]++;
        }
        
        System.out.println(Arrays.toString(clothes));
        
        for(int i=1; i<n+1; i++){
            int cur = clothes[i];
            if(cur != 0) continue; 
            
            int prev = (i==1) ? 0 : clothes[i-1];
            int next = (i==n) ? 0 : clothes[i+1];
            
            if(prev < 2 && next < 2) continue;
            
            int borrow = 0; 
            if((prev >= 2 && next >= 2) || (prev >= 2)){
                borrow = i-1;
            }else{
                borrow = i+1;
            }
            
            clothes[i]++;
            clothes[borrow]--;
        }
        
        for(int cloth : clothes){
            if(cloth >= 1) answer++;
        }
        
        return answer;
    }
}