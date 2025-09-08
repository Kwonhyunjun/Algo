import java.io.*; 

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			char[] result = br.readLine().toCharArray();
			
			
			int score = 0;
			int cur = 0;
			
			for(char c : result) {
				if(c == 'O') {
					cur++;
				}else {
					cur = 0;
				}
				score += cur;
			}
			
//			if(cur > 0) score += cur;
			
			sb.append(score).append("\n");
		}
		
		System.out.println(sb);

	}

}
