import java.util.*; 

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, int[]> map = new HashMap<>(); 
        
        for(int i=0; i<want.length; i++){
            map.put(want[i], new int[]{number[i], number[i]}); 
        }
        
        // 초기 세팅
        for(int i=0; i<10; i++){
            if(map.containsKey(discount[i])){
                // int cnt = (map.get(discount[i])[1] -1) <= 0 ? 0 : map.get(discount[i])[1] -1; 
                int cnt = map.get(discount[i])[1] -1; 
                map.put(discount[i], new int[]{map.get(discount[i])[0], cnt}); 
            }
        }
        
//         int sum = 0;
//         for(int[] n : map.values()){
//             sum += n[1]; 
//         }
        
//         if(sum == 0){
//             answer++; 
//         }
            boolean flag = true; 
            for(int[] n : map.values()){
                if(n[1] > 0){
                    flag = false; 
                    break; 
                }
            }

            if(flag){
                answer++; 
            }
        
        for(int i = 1; i <= discount.length - 10; i++){
            // System.out.println(i+"일차");
            // 앞날 제거
            String prev = discount[i-1]; 
            
            if(map.containsKey(prev)){
                int cnt = (map.get(prev)[1]+1 >= map.get(prev)[0]) ? map.get(prev)[0] : map.get(prev)[1]+1; 
                map.put(prev, new int[]{map.get(prev)[0], cnt}); 
                // System.out.println("전날: "+ prev + " :"+Arrays.toString(map.get(prev)));
            }
            
            // 뒷날 제거
            String after = discount[i+9]; 
            if(map.containsKey(after)){
                // int cnt = (map.get(after)[1] -1) <= 0 ? 0 : map.get(after)[1] -1; 
                int cnt = map.get(after)[1] -1; 
                map.put(after, new int[]{map.get(after)[0], cnt}); 
                // System.out.println("이후: "+ after + " :"+Arrays.toString(map.get(after)));
            }
            
            flag = true; 
            for(int[] n : map.values()){
                if(n[1] > 0){
                    flag = false; 
                    break; 
                }
            }

            // System.out.println(i+"일차 "+sum+"개");
            if(flag){
                answer++; 
            }
        }
        
        return answer;
    }
}