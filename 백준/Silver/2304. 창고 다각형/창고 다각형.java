import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<int[]> pilars = new ArrayList<>();
		int idx =0;
		int maxHeight = 0;
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			pilars.add(new int[] {L, H});
			if(maxHeight < H) {
				idx = L;
				maxHeight = H;
			}
		}
		
//		System.out.println(idx + " " + maxHeight);
		
		Collections.sort(pilars, (o1, o2) -> o1[0] - o2[0]);
		
//		for(int[] cur : pilars) {
//			System.out.println(Arrays.toString(cur));
//		}
		
		int start = pilars.get(0)[0];
		int end = pilars.get(pilars.size()-1)[0];
		
//		System.out.println(start + " " + end);
		int[] heights = new int[pilars.get(pilars.size()-1)[0]+1];
		
		// 왼쪽 -> 오른쪽
		int curPos = start;
		int curHeight = pilars.get(0)[1];
		for(int i=0; i<pilars.size() ; i++) {
			int[] curPilar = pilars.get(i);
//			System.out.println(curPilar[0] + " " +curPilar[1]);
			
			for(int j=curPos; j<=curPilar[0]; j++) {
				heights[j] = curHeight; 
			}
			
			curHeight = Math.max(curHeight, curPilar[1]);
			curPos = curPilar[0];
			if(curPilar[0] == idx) break;
		}
		
//		System.out.println(Arrays.toString(heights));
		
		curPos = end;
		curHeight = pilars.get(pilars.size()-1)[1];
		for(int i=pilars.size()-1; i>=0 ; i--) {
			int[] curPilar = pilars.get(i);
//			System.out.println(curPilar[0] + " " +curPilar[1]);
			
			for(int j=curPos; j>=curPilar[0]; j--) {
				heights[j] = curHeight; 
			}
			
			curHeight = Math.max(curHeight, curPilar[1]);
			curPos = curPilar[0];
			if(curPilar[0] == idx) break;
		}
		
//		System.out.println(Arrays.toString(heights));
		
		heights[idx] = maxHeight;
		
		int answer =0;
		for(int i=start; i<=end; i++) {
			answer += heights[i];
		}
		
		System.out.println(answer);
	}

}