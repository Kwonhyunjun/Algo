import java.io.*; 
import java.util.*; 

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); 
		
		HashMap<String, String> map = new HashMap<>(); 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			String site = st.nextToken();
			String pwd = st.nextToken(); 
			
			map.put(site, pwd); 
		}
		
		for(int i=0; i<M; i++) {
			String cur = br.readLine(); 
			String curpwd = map.get(cur);
			sb.append(curpwd).append("\n");
		}
		
		System.out.println(sb); 
		
	}
}