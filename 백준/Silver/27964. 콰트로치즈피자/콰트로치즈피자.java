import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			String cur = st.nextToken(); 
			
			if(cur.length() < 6) continue;
			
			if("Cheese".equals(cur.substring(cur.length() - 6, cur.length()))) {
//				System.out.println(cur.substring(cur.length() - 6, cur.length()));
				map.put(cur, map.getOrDefault(cur, 0)+1);
			}
		}
		
		System.out.println(map.size() >= 4 ? "yummy" : "sad");

	}

}