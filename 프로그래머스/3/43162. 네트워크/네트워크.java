import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
       int answer = 0;
	        
	    boolean[] v = new boolean[n]; 
	        
	    for(int i=0; i<n; i++) {
	        if(v[i]) continue; 
	    	answer++; 
	        	
	    	Queue<Integer> q = new ArrayDeque<>(); 
	    		
    		q.offer(i);
	   		v[i] = true; 
	    		
    		while(!q.isEmpty()) {
	    		int cur = q.poll(); 
	    			
	    		for(int j=0; j<n; j++) {
	    			// 연결 여부 
					if(computers[cur][j] == 0) continue; 
    				// 방문 여부 
                    if(v[j]) continue; 
	    				
	    			q.offer(j);
	    			v[j] = true;
	    		}
	    	}
	    		
	    }    
	        return answer;
    }
}