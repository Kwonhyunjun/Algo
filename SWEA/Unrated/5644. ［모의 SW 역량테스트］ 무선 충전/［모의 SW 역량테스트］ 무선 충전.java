import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static int M, A; 
	static int[][] moveA, moveB;
	static List<BC> bcList; 
	static int[] dr = {0,-1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	static int ans; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 이동 시간
			A = Integer.parseInt(st.nextToken()); // BC 개수
			ans = 0; 
			moveA = new int[M+1][2]; 
			moveB = new int[M+1][2];
			moveA[0][0] = 1; 
			moveA[0][1] = 1; 
			moveB[0][0] = 10; 
			moveB[0][1] = 10; 
			
			st = new StringTokenizer(br.readLine()); 
			for(int i=1; i<=M; i++) {
				int d = Integer.parseInt(st.nextToken());
				moveA[i][0] = moveA[i-1][0] + dr[d]; 
				moveA[i][1] = moveA[i-1][1] + dc[d]; 
			}
			st = new StringTokenizer(br.readLine()); 
			for(int i=1; i<=M; i++) {
				int d = Integer.parseInt(st.nextToken());
				moveB[i][0] = moveB[i-1][0] + dr[d]; 
				moveB[i][1] = moveB[i-1][1] + dc[d]; 
			}
			
			bcList = new ArrayList<Solution.BC>(); 
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int amount = Integer.parseInt(st.nextToken());
				
				bcList.add(new BC(c, r, range, amount)); 
			}
//			 Input End
//			int idx =0; 
//			for(int[] p : moveA) {
//				System.out.println(idx+Arrays.toString(p) + " ");
//				idx++;
//			}
//			System.out.println();
//			idx =0; 
//			for(int[] p : moveB) {
//				System.out.println(idx+Arrays.toString(p) + " ");
//				idx++;
//			}
			for(int i=0; i<=M; i++) { // 시간 별로 움직임
				// 사용자마다 연결된 비콘
//				System.out.println("Time: "+i);
				List<BC> conA = new ArrayList<Solution.BC>(); 
				List<BC> conB = new ArrayList<Solution.BC>(); 
				
				for(int j=0; j<A; j++) {
					BC cur = bcList.get(j);
					// A 
					int d = Math.abs(moveA[i][0] - cur.r) + Math.abs(moveA[i][1] - cur.c); 
					if(d <= cur.range) {
						conA.add(cur);
					}
					// B 
					d = Math.abs(moveB[i][0] - cur.r) + Math.abs(moveB[i][1] - cur.c); 
					if(d <= cur.range) {
						conB.add(cur);
					}
				}
				
				int curCharge = 0;
				
				if(conA.size() == 0) {
					for(int k=0; k<conB.size(); k++) {
						BC bc = conB.get(k);
						if(curCharge < bc.amount) {
							curCharge = bc.amount; 
//							System.out.println(i+": B "+bc.amount);
						}
					}
				}else if(conB.size() == 0) {
					for(int k=0; k<conA.size(); k++) {
						BC bc = conA.get(k);
						if(curCharge < bc.amount) {
							curCharge = bc.amount; 
//							System.out.println(i+": A "+bc.amount);
						}
					}
				}else {
					for(int k=0; k<conA.size(); k++) {
						for(int l=0; l<conB.size(); l++) {
							int temp = 0; 
							BC a = conA.get(k);
							BC b = conB.get(l);
							
							if(a == b) {
								temp = a.amount;
							}else {
								temp += a.amount;
								temp += b.amount; 
							}
							
							if(curCharge < temp) {
								curCharge = temp; 
//								System.out.println(i+": AB "+temp);
							}
						}
					}
				}
				
				ans += curCharge;
				
			}
		
			System.out.printf("#%d %d\n", tc, ans);
			
		}
		
	}
	
	static class BC{
		int r; 
		int c;
		int range; 
		int amount;
		
		public BC(int r, int c, int range, int amount) {
			super();
			this.r = r;
			this.c = c;
			this.range = range;
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "BC [r=" + r + ", c=" + c + ", range=" + range + ", amount=" + amount + "]";
		} 
		
	}
}