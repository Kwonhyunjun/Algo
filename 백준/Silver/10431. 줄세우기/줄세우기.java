import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			List<Integer> list = new ArrayList<>();
			
			list.add(Integer.parseInt(st.nextToken()));
			
			int answer = 0;
			
			for(int i=0; i<19; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				int idx = list.size()-1;
				
				while(true) {
					int prev = idx;
					
					if(prev < 0) {
						break;
					}
					
					if(list.get(prev) < num) break;
					
					idx--;
					answer++;
				}
				
				list.add(idx+1, num);
			}
			
			sb.append(N + " " + answer).append("\n");
		}
		
		System.out.println(sb);

	}

}
