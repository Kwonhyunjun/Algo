import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K, arr[]; 
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken()); 
		
		arr = new int[N]; 
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int head = 0; 
		int tail = 0;
		int max = arr[0] % 2 == 0 ? 1 : 0; 
		int cnt = arr[0] % 2; // 홀수의 개수
		
		while(true) {
			if(tail == N-1) break; 
//			System.out.printf("head : %d, tail : %d -> cnt = %d\n", head, tail, cnt); 
//			System.out.println("max : "+ max);
			
			if(cnt <= K) {
				tail++; 
				if(arr[tail] % 2 != 0) {
					cnt++; 
				}
				if(cnt <= K) {
					max = Math.max(max, tail-head+1-cnt); 
				}
			}else {
				// head 증가
				if(arr[head] % 2 != 0) {
					cnt--; 
				}
				head++; 
			}
		}
		
		System.out.println(max); 
	}
}