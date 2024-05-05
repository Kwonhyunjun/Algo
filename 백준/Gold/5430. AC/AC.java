import java.io.*;
import java.util.*; 

public class Main {

	static int T, N, arr[]; 
	static char[] command;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		T = Integer.parseInt(br.readLine()); 
		
		next:for(int t=0; t<T; t++) {
			command = br.readLine().toCharArray(); 
		
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N]; 
			
			String array = br.readLine(); 
			
			
			st = new StringTokenizer(((array.substring(1, array.length()-1))), ",");
			
			
			for(int i=0;i <N; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); 
			}
			
			
			int head = 0; 
			int tail = N-1;
			int size = N; 
			String cur = "head"; 
			
			for(char c : command) {
				if(c == 'R') { // 뒤집기 
					
					if(cur.equals("head")) {
						cur = "tail"; 
					}else {
						cur = "head";
					}
					
				}else { // 삭제하기
					if(size <= 0) {
						System.out.println("error");
						continue next;
					}
					
					if(cur.equals("head")) {
						arr[head] = -1; 
						head++; 
						size--; 
					}else {
						arr[tail] = -1; 
						tail--; 
						size--;
					}
					
				}
			}
			
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("[");
			
			int idx = (cur.equals("head"))? head : tail;
			
			while(idx >= 0 && idx < N && arr[idx] != -1 ) {
				sb.append(arr[idx]).append(",");
				
				if(cur.equals("head")) {
					idx++; 
				}else {
					idx--; 
				}
			}
			
			String ans = ""; 
			if(size != 0) {
				ans  = sb.substring(0, sb.length()-1);
			}else {
				ans  = sb.substring(0, sb.length());
			}
			
			
			
			System.out.println(ans+"]");
			
			
		}

	}

}