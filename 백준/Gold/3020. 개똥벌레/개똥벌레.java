import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[] botCnt = new int[H+1];
		int[] topCnt = new int[H+1];
		
		for(int i=0; i<N; i++) {
			int height = Integer.parseInt(br.readLine()); 
			if(i%2 == 0) {
				// 석순
				botCnt[height]++; 
			}else {
				// 종유석
				topCnt[height]++; 
			}
		}
		
//		System.out.println(Arrays.toString(botCnt));
//		System.out.println(Arrays.toString(topCnt));
		
		int[] botSum = new int[H+1]; 
		int[] topSum = new int[H+1];
		botSum[0] = N/2;
		topSum[0] = 0; 
		for(int i=1; i<H+1; i++) {
			botSum[i] = botSum[i-1] - botCnt[i-1];
			topSum[i] = topSum[i-1] + topCnt[H-i+1];
		}
		
//		System.out.println(Arrays.toString(botSum));
//		System.out.println(Arrays.toString(topSum));
		
		
		int min = Integer.MAX_VALUE;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=1; i<H+1; i++) {
			int broken = botSum[i] + topSum[i]; 
			min = Math.min(min, broken); 
			map.put(broken, map.getOrDefault(broken, 0) + 1);
		}
		
		System.out.println(min + " " + map.get(min));
	}

}