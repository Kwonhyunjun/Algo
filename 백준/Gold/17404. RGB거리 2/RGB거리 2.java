import java.io.*;
import java.util.*;

public class Main {
	
	static int N, map[][], dp[][][];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[3][N][3];
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<3; k++) {
					dp[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		dp[0][0][0] = map[0][0];
		dp[1][0][1] = map[0][1];
		dp[2][0][2] = map[0][2];
		
		
//		print();
		
		for(int i=1; i<N; i++) { // 집 순서
			for(int j=0; j<3; j++) { // 첫번째 집이 몇번쨰 칠했는지
				for(int k=0; k<3; k++) { // 현재 고려하는 집 순서
					for(int l=0; l<3; l++) { // 이전에 칠했던 집
						if(dp[j][i-1][l] == Integer.MAX_VALUE) continue; 
						if(k == l) continue;
						if(i==N-1 && k == j) continue;
						dp[j][i][k] = Math.min(dp[j][i][k], dp[j][i-1][l] + map[i][k]);
					}
				}
			}
			
//			print();
		}
		
//		print();
		
		int answer = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				answer = Math.min(answer, dp[i][N-1][j]);
			}
		}
		
		System.out.println(answer);
	}
	
	static void print() {
		System.out.println("------------------------print------------------------");
		for(int i=0; i<3; i++) {
			for(int j=0; j<N; j++) {
				System.out.println(Arrays.toString(dp[i][j]));
			}
			
			System.out.println();
		}
	}

}