import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int answer = 0;
		
		for(int i=0; i<str.length(); i++) {
			char cur = str.charAt(i);
			
			switch(cur) {
				case 'c' :
					if(i+1 < str.length() && (str.charAt(i+1) == '=' || str.charAt(i+1) == '-')) {
						i++;
					}
					answer++;
					break;
				case 'd' :
					if(i+1 < str.length() && str.charAt(i+1) == '-') {
						i++;
					}else if(i+2 < str.length() && str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') {
						i += 2; 
					}
					answer++;
					break;
				case 'l' :
					if(i+1 < str.length() && str.charAt(i+1) == 'j') {
						i++;
					}
					answer++;
					break;
				case 'n' :
					if(i+1 < str.length() && str.charAt(i+1) == 'j') {
						i++;
					}
					answer++;
					break;
				case 's' :
					if(i+1 < str.length() && str.charAt(i+1) == '=') {
						i++;
					}
					answer++;
					break;
				case 'z' :
					if(i+1 < str.length() && str.charAt(i+1) == '=') {
						i++;
					}
					answer++;
					break;
				default :
					answer++;
					break;
					
			}
		}
		
	
		System.out.println(answer);

	}

}