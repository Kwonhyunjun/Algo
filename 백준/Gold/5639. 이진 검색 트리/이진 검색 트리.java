import java.io.*;
import java.util.*;
	
public class Main {

	static List<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in); 
		
		while(true) {
			int num = sc.nextInt();
			list.add(num);
			if(!sc.hasNext()) break;
		}
		
		solve(0, list.size()-1);

		System.out.println(sb.toString());
	}
	
	static void solve(int start, int end) {
	    // start가 end를 넘어가면 이 서브트리에 노드가 없는 것이므로 바로 리턴
	    if (start > end) return;

	    int root = list.get(start);
	    int idx = start + 1;
	    // 왼쪽 서브트리 구간 찾기 (<= end)
	    while (idx <= end && list.get(idx) < root) {
	        idx++;
	    }
	    // 이제 idx 는 왼쪽 서브트리 끝(idx-1) 다음 또는 end+1

	    // 왼쪽, 오른쪽 서브트리 재귀
	    solve(start + 1, idx - 1);
	    solve(idx, end);

	    // 후위 순회 출력
	    sb.append(root).append('\n');
	}

}