import java.io.*; 
import java.util.*;

public class Main {
	
	static int N, ans;
	static StringBuilder sb; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
	
		hanoi(1, 3, 2, N);
		System.out.println(ans); 
		System.out.println(sb); 
	}
	
	static void hanoi(int start, int target, int another, int cnt) {
		
		// 제일 아래 있는 원판 제외 위에 cnt-1개의 원판을 start와 target이 아닌 장대에 옮긴다.
		if(cnt > 1) hanoi(start, another, target, cnt-1);
		
		// 제일 아래 있는 원판을 target 장대로 옮긴다.
		ans++; 
		sb.append(start).append(" ").append(target).append("\n"); 
		
		// 다른 장대에 있는 원판을 target 원판으로 옮긴다.
		if (cnt > 1) hanoi(another, target, start, cnt-1); 
		
	}

}