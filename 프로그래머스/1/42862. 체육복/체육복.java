import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve); 
        
       	List<Integer> list = new ArrayList<Integer>();
       	
       	for(int num : lost) {
       		list.add(num); 
       	}
       	
       	for(int i=0; i<reserve.length; i++) {
       		int num = reserve[i];
       		if(list.contains(num)) {
       			int idx = list.indexOf(num);
       			list.remove(idx);
       			reserve[i] = -1; 
       		}
       	}
//       	System.out.println(Arrays.toString(reserve));
//       	System.out.println(lost);
       	
       	for(int num : reserve) {
       		if(num == -1) continue; 
       		int prev = num-1; 
       		int next = num+1; 
       		
       		if(list.contains(prev)) {
       			int idx = list.indexOf(prev);
       			list.remove(idx);
       			continue; 
       		}
       		if(list.contains(next)) {
       			int idx = list.indexOf(next);
       			list.remove(idx);
       			continue; 
       		}
       	}
       	
       	answer = n - list.size(); 
        
       
        return answer;
    }
}