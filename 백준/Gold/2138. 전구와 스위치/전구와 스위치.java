import java.io.*;
import java.util.*;

public class Main {
	
	static int N, answer; 
	static char[] cur, toBe, changeFirst; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		cur = br.readLine().toCharArray();
		changeFirst = Arrays.copyOf(cur, cur.length);
		changeFirst[0] = (changeFirst[0] == '0') ? '1' : '0';
		changeFirst[1] = (changeFirst[1] == '0') ? '1' : '0';
		toBe = br.readLine().toCharArray();
		
//		System.out.println(Arrays.toString(cur));
//		System.out.println(Arrays.toString(changeFirst));
		
		int cnt = 0;
		int changeFirstCnt = 1;
		
		for(int i=1; i<cur.length; i++) {
			
			if(cur[i-1] != toBe[i-1]) {
				cur[i-1] = (cur[i-1] == '0') ? '1' : '0';
				cur[i] = (cur[i] == '0') ? '1' : '0';
				
				if(i+1 < cur.length) {
					cur[i+1] = (cur[i+1] == '0') ? '1' : '0';
				}
				
				cnt++;
			}
			
			if(changeFirst[i-1] != toBe[i-1]) {
				changeFirst[i-1] = (changeFirst[i-1] == '0') ? '1' : '0';
				changeFirst[i] = (changeFirst[i] == '0') ? '1' : '0';
				
				if(i+1 < changeFirst.length) {
					changeFirst[i+1] = (changeFirst[i+1] == '0') ? '1' : '0';
				}
				
				changeFirstCnt++;
			}
			
		}
		
//		System.out.println(Arrays.toString(cur));
//		System.out.println(Arrays.toString(changeFirst));
//		System.out.println(cnt + " " +changeFirstCnt);
		
		answer = Integer.MAX_VALUE;
		if(isSame(toBe, cur)) {
			answer = Math.min(answer, cnt);
		}
		
		if(isSame(toBe, changeFirst)) {
			answer = Math.min(answer, changeFirstCnt);
		}

		if(answer == Integer.MAX_VALUE) answer = -1;
		
		System.out.println(answer);
	}
	
	public static boolean isSame(char[]a, char[]b){
        for(int i=0;i<a.length;i++){
            if(b[i] != a[i]){
                return false;
            }
        }
 
        return true;
    }

}