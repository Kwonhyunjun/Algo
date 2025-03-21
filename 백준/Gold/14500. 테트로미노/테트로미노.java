import java.io.*;
import java.util.*; 

public class Main {

	static int N, M, map[][];
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int curMax = solve(i, j);
				
				answer = Math.max(answer, curMax);
			}
		}
		
		System.out.println(answer);
	}
	
	static int[][][] type1 = {
				{{1,0}, {0,1}, {1,1}}
			};
	static int[][][] type2 = {
				{{1,0}, {2,0}, {3,0}}, 
				{{0,1}, {0,2}, {0,3}}
			};
	static int[][][] type3 = {
			{{1,0}, {2,0}, {2,1}},
			{{1,0}, {0,1}, {0,2}},
			{{0,1}, {1,1}, {2,1}},
			{{0,1}, {0,2}, {-1,2}},
			
			{{1,0}, {2,0}, {2,-1}},
			{{1,0}, {1,1}, {1,2}},
			{{0,1}, {1,0}, {2,0}},
			{{0,1}, {0,2}, {1,2}}
		};
	
	static int[][][] type4 = {
			{{1,0}, {1,1}, {2,1}},
			{{0,1}, {-1,1}, {-1,2}},
			{{1,0}, {1,-1}, {2,-1}},
			{{0,1}, {1,1}, {1,2}}
	};
	
	static int[][][] type5 = {
			{{0,1}, {0,2}, {1,1}},
			{{1,0}, {1,1}, {2,0}},
			{{1,-1}, {1,0}, {1,1}},
			{{1,-1}, {1,0}, {2,0}}
	};
	
	static List<int[][][]> types = List.of(type1, type2, type3, type4, type5);
	
	static int solve(int r, int c) {
		int curPos = map[r][c];
		int res = 0;
		
		int curShape;
		for(int[][][] type : types) { // 테트로미노 정하기
			for(int[][] shape : type) { // 테트로미노 회전, 대칭
				boolean flag = true;
				curShape = curPos;
				
				for(int[] nxt : shape) {
					int nr = r + nxt[0];
					int nc = c + nxt[1];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
						flag = false;
						break;
					}
					
					curShape += map[nr][nc];
				}
				
				if(flag) res = Math.max(res,curShape);
			}
		}
		
		return res; 
	}
}