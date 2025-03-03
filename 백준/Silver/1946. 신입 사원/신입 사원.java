import java.io.*;
import java.util.*;
public class Main {

	static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			List<int[]> scores = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				scores.add(new int[] {a, b});
			}
			
			Collections.sort(scores, (o1, o2) -> o1[0] - o2[0]);
			
			int pass = 1; 
			int minScore = scores.get(0)[1];
			
			for(int i=1; i<N; i++) {
				int[] cur = scores.get(i);

				if(cur[1] > minScore) {
					continue;
				}
				
//				System.out.println(cur[0] + " " + cur[1]);
				minScore = Math.min(minScore, cur[1]);
				pass++;
			}
			
			System.out.println(pass);
		}

	}

}