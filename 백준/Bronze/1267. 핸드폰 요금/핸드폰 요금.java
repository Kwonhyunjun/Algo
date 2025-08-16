import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//두 요금을 가자 저장
		int ym = 0;
		int mm = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int M = Integer.parseInt(st.nextToken());
			if((M % 30) >= 0) {
				ym += ((M / 30) + 1) * 10;
			}else {
				ym += (M / 30) * 10;
			}
			if((M % 60) >= 0) {
				mm += ((M / 60) + 1) * 15;
			}else {
				mm += (M / 60) * 15;
			}
		}

		if(ym < mm) {
			System.out.println("Y " + ym);
		}else if(mm < ym) {
			System.out.println("M " + mm);
		}else {
			System.out.println("Y M " + ym);
		}
	}

}