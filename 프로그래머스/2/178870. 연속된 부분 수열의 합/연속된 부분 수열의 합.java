import java.util.*; 

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int len = sequence.length; 
        int[] sum = new int[len]; 
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>(); 
        
        int min_len = Integer.MAX_VALUE;
        
        sum[0] = sequence[0];
        map.put(sum[0], new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return -(o1 - o2); 
            }
        }));
        map.get(sum[0]).add(0);
        map.put(0, new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return -(o1 - o2); 
            }
        }));
        map.get(0).add(-1);
        
        if(sum[0] == k){
            return new int[]{0 ,0}; 
        }
        
        for(int i=1; i<len; i++){
            if(sequence[i] == k){
                return new int[]{i ,i};
            }
            // 누적합 만들기
            sum[i] = sum[i-1] + sequence[i]; 
            
            // HashMap에 인덱스 넣기
            map.put(sum[i], new PriorityQueue<>(new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    return -(o1 - o2); 
                }
            }));
            map.get(sum[i]).add(i);
            
            // System.out.println(Arrays.toString(sum));
            
            // 시작 지점 찾기
            if(map.get(sum[i] -k) != null){
                int start = map.get(sum[i] -k).peek(); // 시작지점
                // System.out.printf("%d %d\n", start+1, i);
                if(min_len > (i - start)){
                    min_len = i - start; 
                    answer[0] = start+1;
                    answer[1] = i;
                }
            }
        }
        
        return answer;
    }
}