import java.io.*;
import java.util.*; 

public class Main {

	static int N, arr[]; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine()); 
		arr = new int[N]; 
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		HashSet<Integer> set = new HashSet<Integer>(); 
		
		int head = 0; 
//		int tail = 0; 
		long ans = 0; 
//		set.add(arr[head]);
		
//		while(true) {
////			System.out.printf("head : %d, tail : %d, ans : %d\n", head, tail, ans); 
//			tail++; // 한 칸 늘림
//			if(tail == N) break; 
//			
//			if(set.contains(arr[tail])) { // 중복된 값을 만나면
//				ans += (tail - head); // 이전에 해당 값을 만났을 때까지 연속된 모든 경우 구함
//				
//				while(true) { // 중복되지 않을 만큼 head 당기기
//					if(arr[++head] == arr[tail]) break; 
//					set.remove(arr[tail]);
//				}
//			}else {
//				set.add(arr[tail]); 
//			}
//			
//		}
//		
		for(int tail=0; tail<N; tail++) {
//			System.out.printf("head : %d, tail : %d, ans : %d\n", head+1, tail+1, ans);
			if(set.contains(arr[tail])) { // 중복된 값을 만나면
				
				while(true) { // 중복되지 않을 만큼 head 당기기
					ans += (tail - head); // 이전에 해당 값을 만났을 때까지 연속된 모든 경우 구함
					if(arr[tail] != arr[head]) {
						set.remove(arr[head]);						
					}
					head++;  
					if(arr[head-1] == arr[tail]) break; 
				}
			
			}else {
				set.add(arr[tail]); 
			}
		}
		
		for(int i=head; i<N; i++) {
			ans += N- i ; 
//			System.out.println(N-i); 
		}

		System.out.println(ans); 
	}

}