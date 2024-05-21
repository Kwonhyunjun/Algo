import java.io.*; 
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); 
		
		HashSet<Integer> set = new HashSet<>(); 
		
		int N = Integer.parseInt(br.readLine());
		
//		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20); 
//		HashSet<Integer> newSet = new HashSet<>(list);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken(); 
//			sb.append(str).append("\n"); 
			
			int a; 
			switch(str) {
				case "add" :
					a = Integer.parseInt(st.nextToken());
					if(!set.contains(a)) {
						set.add(a); 
					}
					break; 
				case "remove" :
					a = Integer.parseInt(st.nextToken());
					if(set.contains(a)) {
						set.remove(a);
					}
					break;
				case "check" :
					a = Integer.parseInt(st.nextToken());
					if(set.contains(a)) {
						sb.append(1).append(" \n"); 
					}else {
						sb.append(0).append(" \n"); 
					}
					break;
				case "toggle" :
					a = Integer.parseInt(st.nextToken());
					if(set.contains(a)) {
						set.remove(a);
					}else {
						set.add(a); 
					}
					break;
				case "all" :
					set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)); 
					break;
				case "empty" :
					set.clear();
					break;
			}
		}
		
		System.out.println(sb); 
		
	}

}