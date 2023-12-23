import java.io.*; 
import java.util.*; 

class Solution {
    static StringTokenizer st;
    static List<Integer> list = new ArrayList<>(); 
    public int[] solution(String today, String[] terms, String[] privacies) {
        // terms : 유효기간을 담은 1차원 문자열 배열 
        // privacies : 수집된 개인 정보 배열
        int[] answer = {}; // 파기해야 할 개인정보의 번호(오름차순)
        
        // privacies 순회 -> 유효기간 파기 날짜 확인
        int num = 1; 
        for(String str : privacies){
            st = new StringTokenizer(str); 
            
            String start = st.nextToken();
            String type = st.nextToken(); 
            
            int dur = -1; 
            for(String str2 : terms){
                st = new StringTokenizer(str2); 
                
                String type2 = st.nextToken();
                if(type2.equals(type)){
                    dur = Integer.parseInt(st.nextToken()); 
                }else{
                    st.nextToken(); 
                }
            }
            
            // 파기 날짜 계산
            int[] end = endDate(start, dur);
            System.out.println(start); 
            System.out.println(dur); 
            System.out.println(Arrays.toString(end)); 
                            
            // 유효기간 파기 날짜와 오늘 날짜 비교해서 answer에 넣기
            if(check(today, end)){
                list.add(num);
            }
                               
            num++;
        } // privacies - loop 
        
                    
        System.out.println(check(today, new int[] {2022, 05, 20}));
        System.out.println(check(today, new int[] {2020, 01, 01}));
        
        // System.out.println(list);
        answer = new int[list.size()]; 
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);   
        }
        return answer;
    }
    
    // 파기 날짜 계산 
    static int[] endDate(String start, int dur){
        st = new StringTokenizer(start, ".");
        int yy = Integer.parseInt(st.nextToken());
        int mm = Integer.parseInt(st.nextToken());
        int dd = Integer.parseInt(st.nextToken());
        
        int temp = mm + dur; 
        
        while(temp > 12){
            yy++; 
            temp -= 12;
        }
        
        mm = temp; 
        // if(temp > 12){
        //     yy++;
        //     mm = temp - 12; 
        // }else{
        //     mm = temp; 
        // }
        
        int[] result = {yy, mm, dd}; 
        return result; 
    } // endDate(); 
    
    // 날짜 비교
    static boolean check(String today, int[] end){
        st = new StringTokenizer(today, ".");
        int curY = Integer.parseInt(st.nextToken());
        int curM = Integer.parseInt(st.nextToken());
        int curD = Integer.parseInt(st.nextToken());
        
        if(curY == end[0]){
            // mm 체크 
             if(curM == end[1]){
                 // dd 체크
                 return curD >= end[2]; 
                 // if(curD == end[2]){
                 //     return true;
                 // }else if(curD < end[2]){
                 //     return false;
                 // }else{
                 //     return true; 
                 // }
             }else if(curM < end[1]){
                 return false; 
             }else{
                 return true; 
             }
        }else if(curY < end[0]){
            return false; // 보존
        }else{ // 2022 > 2021 
            return true; // 파기  
        }
    } // check()
}