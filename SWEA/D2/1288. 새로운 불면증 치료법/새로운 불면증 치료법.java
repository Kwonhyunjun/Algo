import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int number = Integer.parseInt(br.readLine()); 
			
			int v = 0; 
			int time = 1; 
			while(v != 0b1111111111) {
				int num = number * time; 
				
				// 숫자의 각 자리수를 분리
				String str = String.valueOf(num);
				
				for(int i=0; i< str.length(); i++) {
					int n = str.charAt(i) - '0';
					
					if((v & (1<<n)) != 0) continue; // 만약 이미 체크되어 있다면
					
					v |= (1 << n) ; 
				}
				
				 if(v == 0b1111111111) { // 모든 숫자를 다 봤다면
                    System.out.println("#" + (t+1) + " " + num); // 결과 출력
                    break; // 다음 테스트 케이스로 넘어감
                }
				time++;
			}
		}
		
		System.out.println(sb); 
	}

}