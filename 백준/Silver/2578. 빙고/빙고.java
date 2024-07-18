import java.io.*;
import java.util.*; 

public class Main {
	
	static int map[][]; 
	static boolean[][] isSelected; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		map = new int[5][5]; 
		isSelected = new boolean[3][5];
		HashMap<Integer, int[]> hm = new HashMap<>(); 
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				hm.put(map[i][j], new int[] {i, j});
			}
		}
		
		int n = 0; 
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=5; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				int[] idx = hm.get(num); 
				map[idx[0]][idx[1]] = -1;
				n++; 
				check();
				int cnt = 0;
				for(int l=0; l<3; l++) {
					for(int k=0; k<5; k++) {
						if(isSelected[l][k]) cnt ++; 
					}
				}
				
				if(cnt >= 3) {
					System.out.println(n); 
					return; 
				}
			}
		}

	}
	
	static void check() {
		for(int i=0; i<5; i++) {
			
			// 가로
			boolean flag = true; 
			if(!isSelected[0][i]) {
				for(int j=0; j<5; j++) {
					if(map[i][j] != -1) {
						flag = false; 
						break; 
					}
				}
				
				if(flag) {
					isSelected[0][i] = true; 
				}
			}
			
			// 세로
			flag = true; 
			if(!isSelected[1][i]) {
				for(int j=0; j<5; j++) {
					if(map[j][i] != -1) {
						flag = false; 
						break; 
					}
				}
				
				if(flag) {
					isSelected[1][i] = true; 
				}
			}
		}

		
		// 대각선
		boolean flag = true; 
		int r = 0;
		int c = 0;
		for(int i=0; i<5; i++) {
			if(map[r++][c++] != -1) {
				flag = false;
				break; 
			}
		}
		
		if(flag) isSelected[2][1] = true; 
		
		// 대각선
		flag = true; 
		r = 4;
		c = 0;
		for(int i=0; i<5; i++) {
			if(map[r--][c++] != -1) {
				flag = false;
				break; 
			}
		}
		
		if(flag) isSelected[2][2] = true; 
	}

}