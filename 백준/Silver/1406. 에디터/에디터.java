import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 

		LinkedList<Character> list = new LinkedList<Character>(); 
		ListIterator<Character> cursor = list.listIterator();

		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			cursor.add(str.charAt(i));
		}
		
		int cnt = Integer.parseInt(br.readLine());
		
		for(int i=0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			switch(st.nextToken()) {
			case "L": 
				if(cursor.hasPrevious()) {
					cursor.previous(); 
				}
				break; 
			case "D":
				if(cursor.hasNext()) {
					cursor.next();
				}
				break; 
			case "B":
				if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
				break; 
			case "P":
				char c = st.nextToken().charAt(0);
				cursor.add(c);
				break;
			}
		}
		
		 StringBuilder sb = new StringBuilder();
		 list.forEach(sb::append);
	     System.out.println(sb.toString());
			
		
	}

}

