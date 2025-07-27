import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		
		set.add(br.readLine());
		
		for(int i=1; i<N; i++) {
			String cur = br.readLine(); 
			
			boolean flag = false;
			for(int j=0; j<cur.length(); j++) {
				if(set.contains(cur)) {
					flag = true;
					break;
				}
				
				sb.append(cur.substring(1)).append(cur.charAt(0));
				cur = sb.toString(); 
				sb.setLength(0);
			}
			
			if(!flag) {
				set.add(cur);
			}
		}

		
		System.out.println(set.size());
	}

}
