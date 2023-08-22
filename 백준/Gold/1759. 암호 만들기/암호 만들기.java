import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1759. 암호 만들기
public class Main {
	static int L, C;
	static char[] alpha; 	// 전체 알파벳
	static char[] sel; 		// 선택된 알파벳  

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken()); // 비밀번호에 선택된 문자 
		C = Integer.parseInt(st.nextToken()); // 후보 문자
		alpha = new char[C]; 
		sel = new char[L]; 

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0); 
		}
		Arrays.sort(alpha);
		combi(0, 0);
	}
	private static void combi(int cnt, int start) {
		if(cnt == L) {
			StringBuilder sb = new StringBuilder(); 
			int m = 0;
			int j = 0; 
			for(char c : sel) {
				if(c == 'a' || c == 'e' ||c == 'i'|| c == 'o' ||c == 'u') {
					m++; 
				}
				else {
					j++; 
				}
			}
			
			if(m == 0 || j < 2) return; 
			
			for(char c : sel) {
				sb.append(c); 
			}
			System.out.println(sb);	
			return; 
		}
		
		for(int i=start;i<C;i++) {
			sel[cnt] = alpha[i]; 
			combi(cnt+1, i+1);
		}
	}

}
