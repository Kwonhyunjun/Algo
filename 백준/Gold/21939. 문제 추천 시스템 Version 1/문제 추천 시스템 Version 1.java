import java.io.*;
import java.util.*; 

/**
 * TreeMap은 기본적으로 키값으로 정렬되지만, 값에 대한 정렬을 지원하지는 않음
 * 
 */

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder(); 
		
		TreeMap<Integer, Integer> map1 = new TreeMap<>(); 	// key, value = 문제번호 , 난이도
		TreeMap<Integer, TreeMap<Integer, Integer>> map2 = new TreeMap<>(); 	// value, key = 난이도, 문제번호
		 
		
		int N = Integer.parseInt(br.readLine()); //문제의 개수
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
//		System.out.println("  map1: " + map1);
//		System.out.println("  map2: " + map2);
		
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
				int n = map1.get(num); // 난이도
//				System.out.println("난이도 : " + n);
//				System.out.println(map2.get(n).firstKey());
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
				
				if(type == 1) { // 가장 어려운 문제가 여러개라면 문제 번호가 큰 것으로 출력
					
					sb.append(map2.get(map2.lastKey()).lastKey()).append("\n");  
				}else { // 가장 쉬운 문제가 여러 개라면 문제 번호가 작은 것을 출력
					
					sb.append(map2.get(map2.firstKey()).firstKey()).append("\n");
				}
				break; 
			}
//			System.out.println(i);
//			System.out.println("  map1: " + map1);
//			System.out.println("  map1: " + map2);
		}
		
		System.out.println(sb);
		
	}

}