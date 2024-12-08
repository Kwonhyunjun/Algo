class Solution {
    public int[] solution(int n, int m) { 
        int[] answer = {};
        
        int a = (n > m) ? n : m;
        int b = (n > m) ? m : n;
        
        int min = gcd(a, b);
        int max = m*n / min; 
        
        return new int[]{min, max};
    }
    
    static int gcd(int a, int b){
        int r = a%b; 
        if(r == 0) return b;
        return gcd(b, r); 
    }
}