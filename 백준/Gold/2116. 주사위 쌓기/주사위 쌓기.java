import java.io.*;
import java.util.*; 

/*
 * 맞대고 있는 면이 같아야 한다.
 */

public class Main {
	
	static int N, dices[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		dices = new int[N][6]; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(dices[i]));
//		}
		
		int answer = 0; 
		int last = 0; 
		
//		A, F (0, 5)
//		B, D (1, 3)
//		E, C (2, 4)
		
		
		for(int i=0; i<6; i++) { 
			// 첫번째 주사위
			int max = 0; 
			last = dices[0][i]; 
			max += maxValue(0, i);
//			System.out.println("첫주사위 윗면 " + last);
			
			// 다음 주사위
			for(int k=1; k<N; k++) {
				// 같은 숫자 찾기 
				int idx = 0; 
				
				for(int j=0; j<6; j++) {
					if(dices[k][j] == last) {
						idx = j; 
//						System.out.println(j);
						break; 
					}
				}
				
				switch(idx) {
					case 0 : 
						last = dices[k][5]; 
						max += maxValue(k, idx); 
						break;
					case 1 : 
						last = dices[k][3]; 
						max += maxValue(k, idx); 
						break;
					case 2 : 
						last = dices[k][4]; 
						max += maxValue(k, idx); 
						break;
					case 3 : 
						last = dices[k][1]; 
						max += maxValue(k, idx); 
						break;
					case 4 : 
						last = dices[k][2]; 
						max += maxValue(k, idx); 
						break;
					case 5 : 
						last = dices[k][0]; 
						max += maxValue(k, idx); 
						break;
					
				}
				
//				System.out.printf("   %d(%d) -> %d\n", last, idx,  max);
				
			}
//			System.out.printf("  %d -> %d\n", dices[0][i], max);
			answer = Math.max(answer, max); 
		}
		
		System.out.println(answer); 
	}
	
	static int maxValue(int cnt, int i) {
		int max = 0;
		
		if(i == 0 || i == 5) {
			for(int j=0; j<6; j++) {
				if(j == 0 || j == 5) continue;
				max = Math.max(max, dices[cnt][j]); 
			}
			
		}else if(i == 1 || i == 3) {
			for(int j=0; j<6; j++) {
				if(j == 1 || j == 3) continue;
				max = Math.max(max, dices[cnt][j]); 
			}
			
		}else {
			for(int j=0; j<6; j++) {
				if(j == 2 || j == 4) continue;
				max = Math.max(max, dices[cnt][j]); 
			}
		}
		return max; 
	}

}