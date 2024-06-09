class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        while(true){
            
            int index = myString.indexOf(pat); 
            // System.out.println(index); 
            
            if(index == -1) break;
            
            answer++; 
            myString = myString.substring(index+1); 
            // System.out.println(myString); 
        }
        
        // System.out.println("na".indexOf(pat)); 
        
        return answer;
    }
}