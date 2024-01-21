import java.util.*; 

// DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램

class Solution {
    public int solution(int cacheSize, String[] cities) {
//         int answer = 0;
        
//         List<String> list = new LinkedList<>(); 
        
//         // 처음 캐시가 없을 때
//         for(int i=0; i<cacheSize; i++){
//             String city = cities[i]; 
//             city = city.toUpperCase(); 
//             answer += 5; 
//             System.out.printf("초기 +5 = %d\n", answer); 
//             list.add(city); 
//         }
        
//         // if(cacheSize != 0){
//         //     cacheSize -= 1;
//         // }
        
//         for(int i=cacheSize; i<cities.length; i++){
//             System.out.println(i); 
//             String city = cities[i]; 
//             city = city.toUpperCase(); 
            
//             if(cacheSize == 0){
//                 answer += 5; 
//                 System.out.printf("+5 = %d\n", answer); 
//             }else{
//                 if(list.contains(city)){
//                 answer += 1;
//                 System.out.printf("+1 = %d\n", answer); 
//                 // 순서 변경 필요
//                 for(int k = 0 ; k < list.size(); k++){
//                     if(list.get(k) == city){
//                         list.remove(k);
//                         list.add(city); 
//                         break; 
//                     }
//                 }
                
//             }else{
//                 answer += 5; 
//                 System.out.printf("+5 = %d\n", answer); 
//                 list.remove(0);
//                 list.add(city); 
//             }   
//             }
//         }
        
        
//         return answer;
        int answer = 0;
        
        if(cacheSize == 0){
            return 5 * cities.length; 
        }
        
        List<String> list = new LinkedList<>(); 
        
        for(int i=0; i<cities.length; i++) {
        	
        	String cur = cities[i];
        	cur = cur.toUpperCase(); 
        	
        	if(list.size() == 0) {
        		answer += 5;
        		list.add(cur); 
        	}else {
        		if(list.contains(cur)) {
        			answer += 1; 
        			list.remove(cur);
        		}else {
        			answer += 5 ; 
        		}
        		
        		list.add(cur);
        		
        		if(list.size() > cacheSize) {
        			list.remove(0); 
        		}
        		
        	}
        	
        	
        }
        
        
        return answer;
    }
}