import java.util.*; 

class Solution {
    // report -> 이용자id, 신고한id
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 이용자id 와 본인을 신고한 플레이어를 저장하는 리스트
        HashMap<String, HashSet<String>> map = new HashMap<>(); 
        HashMap<String, Integer> idx = new HashMap<>(); 
        
        // 이용자와 신고 플레이어 리스트 초기화
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i], new HashSet<>()); 
            idx.put(id_list[i], i); // 인덱스 초기화
        }
        
        for(String str : report){
            StringTokenizer st = new StringTokenizer(str); 
            String er = st.nextToken(); // 신고한 사람
            String ee = st.nextToken(); // 신고 당한 사람
            
            map.get(ee).add(er);
        }
        
        // for(String n : map.keySet()){
        //     System.out.println(n + " " + map.get(n)); 
        // }
        
        // 신고 개수 세기
        for(String name : map.keySet()){
            // System.out.println(name +" "+map.get(name).size()); 
            if(map.get(name).size() >= k){
                // 결과 메일 날리기
                for(String s : map.get(name)){
                    int index = idx.get(s);
                    // System.out.println(index); 
                    answer[index]++; 
                }
            }
        }
        
        // System.out.println(Arrays.toString(answer)); 
        return answer;
    }
}