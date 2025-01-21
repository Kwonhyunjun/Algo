import java.io.*;
import java.util.*;

public class Main {
	
	static class Data{
		int num, move; 
		
		public Data(int num, int move) {
			this.num = num;
			this.move = move; 
		}
		
		@Override
		public String toString() {
			return "[num : " + num + " move : " + move + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		Data[] arr = new Data[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = new Data(i+1, Integer.parseInt(st.nextToken()));
		}
		
		boolean[] v = new boolean[N];
		
		int idx = 0;
		int cnt = 0;
		
		while(true) { 
			cnt++;
//			System.out.printf("%d %d %d\n", arr[idx].num, arr[idx].move, cnt);
			sb.append(arr[idx].num).append(" ");
			v[idx] = true;
			if(cnt == N-1) break;
			
			int d = arr[idx].move < 0 ? -1 : 1; 
			int far = Math.abs(arr[idx].move);
			
			while(far !=0) {
				idx += d; 
				if(idx < 0) {
					idx = N-1;
				}else if(idx >= N) {
					idx = 0;
				}
				if(!v[idx]) far--;
			}
			
		}
		
		for(int i=0; i<N; i++) {
			if(!v[i]) {
				sb.append(arr[i].num); 
			}
		}
		
		System.out.println(sb);

	}

}