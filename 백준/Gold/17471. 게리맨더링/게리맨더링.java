import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N; 
	static int[] peoples; 
	static int[][] maps;  
	static int result = Integer.MAX_VALUE; // 결과(절대값의 최소)
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); 
		peoples = new int[N+1]; 
		
		int[] teams = new int[N+1]; 
		
		// 각 구역별 인원 입력 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			peoples[i] = Integer.parseInt(st.nextToken()); 
		}
		
		// 구역별 연결된 정보 입력 받기 
		maps = new int[N+1][N+1]; 
		int cnt = 0;
		for(int i =1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()); 
			cnt = Integer.parseInt(st.nextToken()); 
			
			int idx; 
			for(int c = 0; c<cnt; c++) {
				idx = Integer.parseInt(st.nextToken()); 
				maps[i][idx] = 1; 
			}
		}
		// Input End
		
		solve(teams, 1); 
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
		

	}

	private static void solve(int[] teams, int cnt) {
		// 모든 지역 배치해보기 
		if(cnt == N+1) {
			// 두 구역으로 정확하게 분리되었나 확인하기
			if(checkbfs(teams, 0) && checkbfs(teams, 1)) {
				result = Math.min(result, doCount(teams)); 
			}
			return; 
		}
		
		teams[cnt] = 0; 
		solve(teams, cnt+1); 
		
		teams[cnt] = 1;
		solve(teams, cnt+1);
		
	}

	private static int doCount(int[] teams) {
		int sum1 = 0; 
		int sum2 = 0; 
		for(int i=1; i<=N; i++) {
			if(teams[i] == 0) {
				sum1 += peoples[i]; 
			}else {
				sum2 += peoples[i]; 
			}
		}
		return Math.abs(sum1 - sum2); 
	}

	private static boolean checkbfs(int[] teams, int type) {
		boolean[] v = new boolean[N+1]; 
		Queue<Integer> q = new LinkedList<Integer>(); 
		
		// 시작하는 정점 큐에 삽입 
		for(int i = 1; i<= N; i++) {
			if(teams[i] == type) {
				q.offer(i); 
				v[i] = true;
				break; 
			}
		}
		// 두 구역으로 분리될 수 없으면 바로 반환
		if(q.isEmpty()) {
			return false; 
		}
		int cur; 
		while(!q.isEmpty()) {
			cur = q.poll(); 
			for(int i=0; i<=N; i++) {
				// 이미 방문한 정점 무시
				if(v[i]) {
					continue; 
				}
				// 같은 구역이 아니면 무시
				if(teams[i] != type) {
					continue; 
				}
				// 연결되어있지 않으면 무시
				if(maps[cur][i] == 0) {
					continue; 
				}
				// 그렇지 않으면 큐에 삽입하고 방문 체크를 한다. 
				q.offer(i); 
				v[i] = true; 
				
			}
		}
		for(int i = 1; i<= N; i++) {
			if(teams[i] != type) {
				continue; 
			}
			if(!v[i]) {
				return false; 
			}
		}
		return true;
	}


}
