import java.util.*; 

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        int num = n;
        int rest = 0;
        List<Integer> list = new ArrayList<>();
        
        // 진수 변환하기
        while(num >= k){
            rest = num % k;
            num /= k;
            list.add(rest);
            // System.out.printf("num : %d , rest: %d\n", num, rest); 
        }
        list.add(num); 
        
        // System.out.println(list);
        
        // 소수 판단하기
        int size = list.size(); 
        String str=""; 
        
        for(int i=size-1; i>=0; i--){
            if(list.get(i) == 0){
                // System.out.printf("idx : %d str : %s\n", i, str); 
                // 소수 체크
                if(check(str)) answer++; 
                str = ""; 
            }else{
                str += list.get(i) + "";    
            }
        }
        
        // System.out.println(str); 
        // 소수 체크
        if(check(str)) answer++; 
        
        return answer;
    }
    
    
    
    static boolean check(String s){
        long num = s.equals("") ? 0 : Long.parseLong(s); 
        System.out.println(num); 
        
        // 0 과 1 은 소수가 아니다
		if(num < 2) {
			return false; 
		}
		
		// 2 는 소수다
		if(num == 2) {
			return true; 
		}
        
        System.out.println(num); 
        System.out.println(Math.sqrt(num)); 
        for(int i=2; i<=(int)Math.sqrt(num); i++){
            if(num % i == 0){
                return false; 
            }
        }
        
        return true; 
    }
}