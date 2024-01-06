import java.util.*; 

class Solution {
    static StringTokenizer st;
    
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String, String> map = new HashMap<>(); 
        HashMap<String, Integer> perPrice = new HashMap<>(); 
        
        String time, num, type; 
        for(String str : records){
            st = new StringTokenizer(str); 
            time = st.nextToken(); 
            num  = st.nextToken(); 
            type = st.nextToken(); 
            
            if(type.equals("IN")){
                map.put(num, time); 
            }else{
                int totalTime = calc(map.get(num), time); 
                // System.out.println(num +" " + totalTime);
                perPrice.put(num, perPrice.getOrDefault(num, 0)+totalTime); 
                map.remove(num); 
            }
        }
        
        for(String no : map.keySet()){
            // System.out.println(no); 
            int totalTime = calc(map.get(no), "23:59");
            perPrice.put(no, perPrice.getOrDefault(no, 0)+totalTime); 
        }
        List<String> list = new ArrayList<>(); 
        for(String no : perPrice.keySet()){
            // System.out.printf("no : %s -> %d\n", no, perPrice.get(no));
            list.add(no); 
            
            int min = perPrice.get(no);
            int price = 0; 
            
            // fees - 0 : 기본시간/ 1: 기본요금/ 2: 단위시간/ 3: 단위요금
            if(min <= fees[0]){
                price = fees[1]; 
            }else{
                // 기본 시간 처리
                price += fees[1]; 
                min -= fees[0]; 
                // 남은 시간 처리
                int temp = min / fees[2]; 
                temp += min % fees[2] > 0 ? 1 : 0; 
                price += fees[3] * temp;  
            }
            System.out.println(price); 
            perPrice.put(no, price); 
        }
        Collections.sort(list); 
        int size = list.size(); 
        
        // 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로
        int[] answer = new int[size]; 
        for(int i=0; i<size; i++){
            answer[i] = perPrice.get(list.get(i)); 
        }
        
       
        return answer;
    }
    
    // enter : 들어온 시간
    // out : 나온 시간
    // return 주차장에 있었던 분
    static int calc(String enter, String out){
        int time = 0; 
        
        st = new StringTokenizer(enter, ":"); 
        int enterH = Integer.parseInt(st.nextToken());
        int enterM = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(out, ":");
        int outH = Integer.parseInt(st.nextToken());
        int outM = Integer.parseInt(st.nextToken());
        
        if(enterH == outH){
            time = outM - enterM; 
        }else if(enterM == outM){
            time = (outH - enterH) * 60; 
        }else{
            int temp = 0; 
            temp += (60 - enterM); 
            temp += 60 * (outH - (enterH +1)); 
            temp += outM; 
            time = temp; 
        }
        // System.out.println(enterH + " " + enterM+ " "+outH+ " "+outM);
        // System.out.println((outH - (enterH +1))); 
        // System.out.println(time); 
        return time; 
    }
}