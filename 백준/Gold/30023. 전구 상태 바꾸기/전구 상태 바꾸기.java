import java.io.*;
import java.util.*;

public class Main {

	static int N, cnt; 
	static char[] arr; 
	static final int MAX = 900000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = br.readLine().toCharArray(); 
		
		// 통일한 기준색 정하기
		int firstLight = lightsOn(N, arr); 
		
//		System.out.println("change");
		change(arr, 0);
//		System.out.println(Arrays.toString(arr));
		int secondLight = lightsOn(N, arr) + 1;
		
//		System.out.println("change");
		change(arr, 0);
//		System.out.println(Arrays.toString(arr));
		int thirdLight = lightsOn(N, arr) + 2;
		
		int minLight = Math.min(firstLight, Math.min(secondLight, thirdLight));
		
//		System.out.println("min : " + minLight);
		
		int answer = (minLight == MAX) ? -1 : minLight; 
		
		System.out.println(answer);

	}
	
	static int lightsOn(int n, char[] arr) {
		char[] copy = Arrays.copyOf(arr, n);
		int cnt = 0 ;
		
		for(int i=1; i<N-2; i++) {
			while(copy[0] != copy[i]) {
//				System.out.println(Arrays.toString(copy));
				change(copy, i);
				cnt++; 
			}
		}
		
		for(int i=1; i<N; i++) {
			if(copy[0] != copy[i]) {
				cnt = MAX;
				break;
			}
		}
		
		return cnt; 
	}
	
	static void change(char[] copy, int start) {
		for(int i=0; i<3; i++) {
			int idx = start + i;
//			System.out.println(idx);
			switch(copy[idx]) {
				case 'R' :
					copy[idx] = 'G'; 
					break;
				case 'G' :
					copy[idx] = 'B'; 
					break; 
				case 'B' :
					copy[idx] = 'R'; 
					break; 
			}
		}
	}

}