import java.util.*; 

class Solution {
    
    static int len, max;
    static String input; 
    static HashSet<Integer> set;  
    
    public int solution(String numbers) {
        int answer = 0;
        len = numbers.length();
        max = Integer.MIN_VALUE; 
        set = new HashSet<>(); 
        input = numbers;
        
        for(int i=1; i<=len; i++){
            nums = new int[i]; 
            v = new boolean[len];
            solve(0, i);
        }
        
        boolean[] prime = new boolean[max+1];
        prime[0] = false; prime[1] = false;
        
        for(int i=2; i<=Math.sqrt(max); i++){
            if(prime[i]) continue; 
            
            for(int j=i*i; j<prime.length; j=j+i){
                prime[j] = true;
            }
        }
        
        set.remove(0);
        set.remove(1);
        for(int a : set){
            if(!prime[a]) answer++; 
        }
        
        return answer;
    }
    
    static int[] nums;
    static boolean[] v;
    static void solve(int cnt, int digit){
        if(cnt >= digit){
            String str = ""; 
            for(int num : nums){
                str += input.charAt(num); 
            }
            // System.out.println(str);
            int a = Integer.parseInt(str); 
            set.add(a);
            max = Math.max(max, a); 
            return;
        }
        
        for(int i=0; i<len; i++){
            if(v[i]) continue; 
            
            v[i] = true; 
            nums[cnt] = i;
            solve(cnt+1, digit); 
            v[i] = false;
        }
    }
}