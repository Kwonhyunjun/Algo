import java.io.*; 
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		int[] switches = new int[N+1]; 
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			switches[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int M = Integer.parseInt(br.readLine()); 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {  // 남학생
				for(int j=num; j<=N ; j+=num) {
					switches[j] = (switches[j] == 1)? 0 : 1;
				}
			}else {
				int l = num; 
				int r = num; 
				while(true) {
					if(l-1 <= 0 || r+1 >= N+1) break; 
					if(switches[l-1] != switches[r+1]) break;

					l -= 1;
					r += 1; 
				}
//				System.out.println(l +" "+r); 
				
				for(int j=l; j<=r; j++) {
//					System.out.println(j);
					switches[j] = (switches[j] == 1)? 0 : 1;
				} 
			}
			
//			System.out.println(Arrays.toString(switches));
		}
		StringBuilder sb = new StringBuilder(); 
		for(int i=1; i<=N; i++) {
			sb.append(switches[i]).append(" ");
			if(i > 10 && i % 20 == 0) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}

}