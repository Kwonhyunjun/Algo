import java.io.*;
import java.util.*;

public class Main {
	
	static class Data{
		String name; 
		boolean isDancing;
		
		public Data(String name) {
			this.name = name;
			this.isDancing = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> person = new HashSet<>();
		HashMap<String, Boolean> map = new HashMap<>();
		
		Data[][] meeting = new Data[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<2; j++) {
				String cur = st.nextToken();
				if(!map.containsKey(cur)) {
					boolean isDancing = false;
					if("ChongChong".equals(cur)) isDancing = true; 
					map.put(cur, isDancing); 
				}
				meeting[i][j] = new Data(cur);
			}
			
			
		}
		
		for(int i=0; i<N; i++) {
			if(map.get(meeting[i][0].name) || map.get(meeting[i][1].name)) {
				map.put(meeting[i][0].name, true);
				map.put(meeting[i][1].name, true);
			}
		}

		int answer = 0; 
		for(boolean isDancing : map.values()) {
			if(isDancing) answer++;
		}
		
		System.out.println(answer);
	}

}
