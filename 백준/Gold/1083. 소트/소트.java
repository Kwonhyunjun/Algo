import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0; 
		int cnt = Integer.parseInt(br.readLine());
		
		while(idx < N && cnt > 0) {
			int cur = arr[idx];
			
//			System.out.println("cur : " + cur + " cnt : "+cnt);
			
			int max = -1;
			int maxIdx = 0; 
			for(int j=1; j<=cnt; j++) {
				int next = idx + j;
				if(next >= N) break;
				
				if(arr[next] > max) {
					max = arr[next];
					maxIdx = next;
				}
			}
			
//			System.out.println("maxIdx : " + maxIdx + " max : " + max);
//			System.out.println("change : " + idx + " " + maxIdx);
			
			if(max < cur) {
				idx++;
				continue;
			}
			
			while(idx < maxIdx) {
//				System.out.println("change : " + idx + " " + maxIdx);
				int temp = arr[maxIdx];
				arr[maxIdx] = arr[maxIdx-1];
				arr[maxIdx-1] = temp;
				
				cnt--;
				maxIdx--;
			}
//			System.out.println(Arrays.toString(arr));
			
			idx++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int elem : arr) {
			sb.append(elem).append(" "); 
		}
		
		System.out.println(sb);
				
	}

}