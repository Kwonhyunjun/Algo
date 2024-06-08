class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        pat = pat.replaceAll("A", "C");
        // System.out.println(pat);
        pat = pat.replaceAll("B", "A");
        // System.out.println(pat);
        pat = pat.replaceAll("C", "B");
        // System.out.println(pat);
        
        
        if(myString.contains(pat)) answer++; 
        
        return answer;
    }
}