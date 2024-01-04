import java.io.*; 
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		String S = st.nextToken();
		String E = st.nextToken();
		String Q = st.nextToken();
		// 개총 시작 시간
		st = new StringTokenizer(S, ":"); 
		int start = Integer.parseInt(st.nextToken() + st.nextToken()); 
//		System.out.println(start);
		// 개총 끝낸 시간
		st = new StringTokenizer(E, ":"); 
		int end = Integer.parseInt(st.nextToken() + st.nextToken()); 
		// 개총 스트리밍
		st = new StringTokenizer(Q, ":"); 
		int quit = Integer.parseInt(st.nextToken() + st.nextToken()); 
		
		HashSet<String> set = new HashSet<>();
		
		String input = ""; 
		int ans = 0; 
		
		while((input = br.readLine()) != null){
//			System.out.println(input);
			st = new StringTokenizer(input);
			
			String time = st.nextToken(); 
			String name = st.nextToken(); 
			
			st = new StringTokenizer(time, ":");
			int cur = Integer.parseInt(st.nextToken() + st.nextToken());
			
			if(cur <= start) {
				set.add(name); 
			}else if(cur >= end && cur <= quit) {
				if(set.contains(name)) {
					ans++; 
					set.remove(name); 
				}
			}
		}
		
		System.out.println(ans);
		
	}

}