import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringBuilder whole = new StringBuilder();
		StringBuilder word = new StringBuilder();
		
		boolean isTag = false;
		for(char cur : str.toCharArray()) {
//			System.out.println("cur :" + cur);
			if(cur == '<') {
				isTag = true;
				if(word.length()>0) {
					whole.append(word.reverse().toString());
					word.setLength(0);
				}
				whole.append(cur);
//				System.out.println(whole);
			}else if(cur == '>') {
				isTag = false;
				whole.append(cur);
//				System.out.println(whole);
			}else if(cur == ' ') {
				if(!isTag) {
					whole.append(word.reverse().toString());
					word.setLength(0);
				}
				whole.append(cur);
//				System.out.println(whole);
			}else {
				if(isTag) {
					whole.append(cur);
				}else {
					word.append(cur);
				}
			}
		}
		
		if(!isTag && word.length() > 0) {
			whole.append(word.reverse().toString());
		}

		System.out.println(whole);
	}

}