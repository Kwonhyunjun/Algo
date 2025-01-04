import java.io.*;
import java.util.*;

public class Main {

	static long N;
	static HashMap<Character, Long> map; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Long.parseLong(br.readLine());
		map = new HashMap<>(); 
		
		long total = 0;
		long max = -1; 
		long min = 1000001;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++) {
			long num = Long.parseLong(st.nextToken());
			map.put((char)( 'A'+i ), num);
			total += num;
			max = Math.max(max, num); 
			min = Math.min(min, num);
		}
		
		Long answer = 0L;
		
		if(N == 1) {
			answer = total - max;  
		}else {
			long totalCnt = (N * N) * 5; 
			
			long threeMin = calcThreeMin();
			long twoMin = calcTwoMin();
			
			
			long threeCnt = 4; 
			long twoCnt = 4+(N-2)*8; 
			long oneCnt = totalCnt - (threeCnt*3 + twoCnt*2);
			
//			System.out.printf("threeMin : %d , twoMin : %d, (%d, %d, %d)\n", threeMin, twoMin, threeCnt, twoCnt, oneCnt);
			
			answer = (threeCnt*threeMin) + (twoCnt*twoMin) + (oneCnt*min); 
			
		}
		
		System.out.println(answer);
		
	}
	
	static long calcThreeMin() {
		long res = Long.MAX_VALUE;
				
		// 3면의 최소값
		List<char[]> three = List.of(
				new char[] {'A', 'D', 'B'},
				new char[] {'A', 'B', 'C'},
				new char[] {'A', 'C', 'E'},
				new char[] {'A', 'E', 'D'},
				new char[] {'F', 'D', 'B'},
				new char[] {'F', 'B', 'C'},
				new char[] {'F', 'C', 'E'},
				new char[] {'F', 'E', 'D'}
		);
		
		for(char[] ch : three) {
			long sum = 0;
			for(char c : ch){
				sum += map.get(c);
			}
			res = Math.min(res, sum);
		}
		
		return res; 
	}
	
	static long calcTwoMin() {
		long res = Long.MAX_VALUE;
				
		// 2면의 최소값
		List<char[]> two = List.of(
				new char[] {'E', 'A'},
				new char[] {'A', 'B'},
				new char[] {'B', 'F'},
				new char[] {'F', 'E'},
				
				new char[] {'E', 'D'},
				new char[] {'A', 'D'},
				new char[] {'B', 'D'},
				new char[] {'F', 'D'},
				
				new char[] {'E', 'C'},
				new char[] {'A', 'C'},
				new char[] {'B', 'C'},
				new char[] {'F', 'C'}
		);
		
		for(char[] ch : two) {
			long sum = 0;
			for(char c : ch){
				sum += map.get(c);
			}
			res = Math.min(res, sum);
		}
		
		return res; 
	}

}