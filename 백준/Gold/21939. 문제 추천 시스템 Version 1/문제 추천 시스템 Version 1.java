import java.io.*;
import java.util.*; 

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder(); 
		
		TreeMap<Integer, Integer> map1 = new TreeMap<>();
		TreeMap<Integer, TreeMap<Integer, Integer>> map2 = new TreeMap<>(); 
		 
		
		int N = Integer.parseInt(br.readLine()); 
		int num = 0; int difficulty =0; 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			num = Integer.parseInt(st.nextToken());
			difficulty = Integer.parseInt(st.nextToken());
			
			map1.put(num, difficulty); 
			if(!map2.containsKey(difficulty)) {
				map2.put(difficulty, new TreeMap<>()); 	
			}
			
			map2.get(difficulty).put(num, 0); 
		}
		
		int M = Integer.parseInt(br.readLine()); 
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			String com = st.nextToken(); 
			
			switch(com) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				difficulty = Integer.parseInt(st.nextToken());
				map1.put(num, difficulty); 
			
				if(!map2.containsKey(difficulty)) {
					map2.put(difficulty, new TreeMap<>()); 	
				}
				map2.get(difficulty).put(num, 0); 
				break;
			case "solved":
				if(map1.size()==0)break; 
				num = Integer.parseInt(st.nextToken());
				int n = map1.get(num);
				map1.remove(num);
				
				if(map2.get(n).size() > 1) {
					map2.get(n).remove(num);
				}else { 
					map2.remove(n);
				}
				
				break;
			case "recommend": 
				if(map1.size()==0) break; 
				int type = Integer.parseInt(st.nextToken()); 
				
				if(type == 1) { 
					
					sb.append(map2.get(map2.lastKey()).lastKey()).append("\n");  
				}else { 
					
					sb.append(map2.get(map2.firstKey()).firstKey()).append("\n");
				}
				break; 
			}
		}
		
		System.out.println(sb);
		
	}

}