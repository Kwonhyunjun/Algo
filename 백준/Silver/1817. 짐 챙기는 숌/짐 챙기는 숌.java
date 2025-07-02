import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		if(N == 0) {
			System.out.println(0);
		}else {
			
			int[] book = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				book[i] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 1; // 첫 박스 사용
			int curW = book[0];

			for(int i=1; i<N; i++) {
			    if(curW + book[i] > W) {
			        answer++;
			        curW = book[i];
			    } else {
			        curW += book[i];
			    }
			}
			System.out.println(answer);
		
		}
	}

}