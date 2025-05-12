import java.io.*;
import java.util.*;

public class Main {
	
	static int L, N, K, charges[];
			
//	static int L, N, K;
//	static HashSet<Integer> charges; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken()); // 학교까지의 거리
		N = Integer.parseInt(st.nextToken()); // 킥보드 충전소 개수
		K = Integer.parseInt(st.nextToken()); // 최대 충전소 방문 횟수
		
		charges = new int[N];
//		charges = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
//			charges.add(Integer.parseInt(st.nextToken()));
			charges[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 1; 
		int right = L; 
		
		int answer = L; 
		
		while(left <= right) {
			int mid = (right + left) / 2; 
			
			if(isPossible(mid)) {
				answer = Math.min(answer, mid);
				right = mid-1;
			}else {
				left = mid+1; 
			}
			
		}
		
		System.out.println(answer);
		
	}
	
	static boolean isPossible(int battery) {
	    int curPos = 0;
	    int curBattery = battery;
	    int idx = 0;
	    int cnt = 0; 

	    while (curPos < L) {
	        // 최대 갈 수 있는 거리
	        int maxDist = curPos + curBattery;

//	        System.out.printf("현재 위치: %d, 현재 배터리: %d, 갈 수 있는 최대 거리: %d, 다음 충전소: %d\n", 
//	            curPos, curBattery, maxDist, (idx < N ? charges[idx] : -1));

	        // 현재 위치에서 바로 목표 지점까지 도달 가능하면 true 반환
	        if (maxDist >= L) {
	            return true;
	        }

	        // 갈 수 있는 가장 먼 충전소 탐색
	        int lastIdx = -1;
	        while (idx < N && charges[idx] <= maxDist) {
	            lastIdx = idx;
	            idx++;
	        }

	        // 충전소를 방문하지 못하면 false 반환
	        if (lastIdx == -1) {
	            return false;
	        }

	        // 가장 먼 충전소로 이동
	        curPos = charges[lastIdx];
	        curBattery = battery;
	        cnt++;

//	        System.out.printf("충전 위치: %d, 충전 횟수: %d\n", curPos, cnt);

	        // 최대 충전 횟수를 초과하면 false 반환
	        if (cnt > K) {
	            return false;
	        }
	    }

	    return false; // 모든 충전소를 방문했음에도 목표 지점에 도달하지 못한 경우
	}

}