import java.util.*;
import java.io.*; 


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st; 
		
		
		int T = Integer.parseInt(br.readLine()); 
		for(int t =0; t<T; t++) {
			HashMap<String, Integer> map = new HashMap<>(); 
			int N = Integer.parseInt(br.readLine());
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()); 
				
				String name = st.nextToken(); 
				String type = st.nextToken();
				
				map.put(type, map.getOrDefault(type, 0) + 1);		
			}
			
			int ans = 0; 
			int mul = 1; 
			
			for(int number : map.values()) {
				mul *= number + 1;
			}
			sb.append(mul-1).append("\n"); 
		}
		
		System.out.println(sb);
	}

}