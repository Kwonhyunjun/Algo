import java.io.*;
import java.util.*;

class Solution {
    
    static int n, computers[][];
    static boolean[] v;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        this.computers = computers; 
        v = new boolean[n];
        for(int i=0; i<n; i++){
            if(v[i]) continue;
            answer++;
            // System.out.println("start : " + i);
            solve(i);
            // System.out.println(Arrays.toString(v));
        }
        
        return answer;
    }
    
    static void solve(int s){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        v[s] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=0; i<n; i++){
                int nxt = computers[cur][i];
                if(nxt == 0) continue;
                if(cur == i) continue;
                if(v[i]) continue;
                
                v[i] = true;
                q.offer(i);
            }
        }
    }
}