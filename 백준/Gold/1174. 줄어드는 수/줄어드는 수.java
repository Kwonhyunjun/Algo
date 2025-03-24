import java.io.*;
import java.util.*;

public class Main {
	
	static int N; 
	static int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	static List<Long> decreaseNum = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dfs(0, 0);
		
		Collections.sort(decreaseNum);
		
//		System.out.println(decreaseNum.size()); 
		if(decreaseNum.size() >= N) {
			System.out.println(decreaseNum.get(N-1));
		}else {
			System.out.println(-1);
		}
		
		

	}
	
	static void dfs(int idx, long cur) {
		if(idx == 10) {
//			System.out.println(cur);
			if(!decreaseNum.contains(cur)) {
				decreaseNum.add(cur);
			}
			return;
		}
		
		dfs(idx+1, cur);
		dfs(idx+1, cur * 10 + nums[idx]);
	}

}