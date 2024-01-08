import java.util.*;
import java.io.*; 

/**
 * 
 */

public class Main {

	static int T, N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine()); 
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine()); 
			
			TreeMap<Integer, Integer> tmap = new TreeMap<>(); 
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()); 
				
				String command = st.nextToken(); 
				int num = Integer.parseInt(st.nextToken()); 
				
				if("I".equals(command)) {
					// 삽입
					tmap.put(num, tmap.getOrDefault(num, 0)+1); 
					
				}else {
					if(tmap.size() == 0) continue;
					// 삭제
//					int key = 0; 
//					
//					if(num == 1) { // 최대값
//						key = tmap.lastKey(); 
//						
//						if(tmap.get(key) > 0) {
//							tmap.put(key, tmap.getOrDefault(key, 0)-1);
//						}else {
//							tmap.remove(key);														
//						}
//					}else { // 최솟값
//						key = tmap.firstKey(); 
//						
//						if(tmap.get(key) > 1) {
//							tmap.put(key, tmap.getOrDefault(key, 0)-1);
//						}else {
//							tmap.remove(key);														
//						}
//					}
					
					if(tmap.size() == 0) continue;
					
					int tgt = ( num==1  ? tmap.lastKey() : tmap.firstKey()); 
					
					int cnt = tmap.put(tgt, tmap.get(tgt)-1);
					if(cnt == 1) tmap.remove(tgt); 
				}
//				System.out.println(i + " " +tmap);
			}
			if(tmap.size() == 0) {
				System.out.println("EMPTY"); 
			}else {				
				System.out.println(tmap.lastKey() + " " + tmap.firstKey()); 
			}
//			System.out.println(tmap);
		}

	}

}