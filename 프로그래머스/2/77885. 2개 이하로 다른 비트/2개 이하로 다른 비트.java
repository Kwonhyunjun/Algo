class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length; 
        
        long[] answer = new long[len];
        
        for(int i=0; i<len; i++){
            long cur = numbers[i]; 
            
            
            
            if(cur % 2 == 0){
                answer[i] = cur+1; 
                
            }else{
                String bi = "0" + Long.toBinaryString(cur); 
                // System.out.println(bi); 
                StringBuilder sb = new StringBuilder(bi);
                
                int idx = bi.lastIndexOf("0");
                sb.setCharAt(idx, '1'); 
                sb.setCharAt(idx+1, '0'); 
                
                answer[i] = Long.parseLong(sb.toString(), 2); 
            }
            
            
        }
        
        return answer;
    }
}