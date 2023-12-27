import java.util.*; 
import java.io.*; 

public class Main {
	
	static int N, M, arr[]; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 

		arr = new int[N]; 
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr); 
		
		int f = 0; 
		int b = 0; 
		long min = Long.MAX_VALUE; 
		
		while(true) {
			if(f == N-1 || b == N ) break;
//			System.out.printf("f(%d), b(%d)\n", f, b);
			
			
			if((arr[b]-arr[f]) < M){
//				System.out.printf("1.f(%d) - b(%d) = %d\n", f, b, arr[b]-arr[f]);
				b++; 
			}else { // M보다 같거나 큰 경우
//				System.out.printf("2.f(%d) - b(%d) = %d\n", f, b, arr[b]-arr[f]);
				min = Math.min(min, (arr[b]-arr[f]));
				f++;
			}
		}
		
		System.out.println(min); 
	}

}