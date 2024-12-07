import java.io.*;
import java.util.*;

public class Main {

	static int N, M; 
	static char map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int answer = Integer.MAX_VALUE;
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				
//				System.out.printf("시작지점 : map[%d][%d]\n", i, j);
				
				int blackCnt = 0; // 검정으로 시작
				int whiteCnt = 0; // 흰색으로 시작
				
				for(int k=0; k<8; k++) {
					char blackChar = (k%2==0) ? 'B' : 'W';
					char whiteChar = (k%2==0) ? 'W' : 'B';
					for(int l=0; l<8; l++) {
						char cur = map[i+k][j+l];
						
//						System.out.println(whiteChar);
						
						if(cur != blackChar) {
							blackCnt++; 
						}
						
						if(cur != whiteChar) {
//						System.out.printf("현재 시점 : map[%d][%d] = %c\n", i+k, j+l, map[i+k][j+l]);							
							whiteCnt++; 
						}
						
						blackChar = (blackChar == 'B') ? 'W' : 'B';
						whiteChar = (whiteChar == 'B') ? 'W' : 'B';
					}
				}
				
//				System.out.printf("white : %d / black : %d\n", whiteCnt, blackCnt);
				answer = Math.min(answer, Math.min(blackCnt, whiteCnt)); 
				
			}
		}

		
		System.out.println(answer);
	}

}