import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//무한루프
		while(true) {
			String S = br.readLine();
			StringBuilder sb = new StringBuilder(S);

			String Sreverse = sb.reverse().toString();
			
			if(S.equals("0")) break;
			
			//두 문자열을 비교
			if(S.equals(Sreverse)) {
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		}
	}

}