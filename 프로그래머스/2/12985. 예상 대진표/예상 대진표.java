class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int first = 0; int second = 0; 
        
        if(a > b){
            first = b-1; 
            second = a-1; 
        }else{
            first = a-1; 
            second = b-1;
        }
        
        
        while(true){
            if(first == second -1 && (first /2 == second/2)){
                answer++; 
                break;
            }
            
            first = first / 2;
            second = second / 2;
            answer++; 
        }

        return answer;
    }
}