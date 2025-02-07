import java.io.*;
import java.util.*;

/**

4 4
3 0 1 4

=> 5

4 8
3 1 2 3 4 1 1 2

=> 5

3 5
0 0 0 2 0

=> 0

 */

public class Main {
	
	static int H, W, ground[], maxHeight, answer; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		ground = new int[W]; 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			ground[i] = Integer.parseInt(st.nextToken());
			maxHeight = Math.max(maxHeight, ground[i]);
		}
		
		for(int h=0; h<maxHeight; h++) {
			int curRain = 0;
			boolean flag = false;
//			System.out.println("h : " + h);
			for(int w=0; w<W; w++) {
				if(ground[w] < h+1) { // 없는거
//					System.out.print("X"); 
					curRain += (flag) ? 1 : 0; 
				}else {
//					System.out.print("O");
					if(flag) {
						answer += curRain; 
					}else {
						flag = true;
					}
					curRain = 0;
				}
			}
//			System.out.println(answer);
		}
		
		System.out.println(answer);
	}

}