import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			switch(command) {
			case "push" : 
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				break;
			case "pop" :
				if(!stack.isEmpty()) {
					System.out.println(stack.pop());
				}else {
					System.out.println(-1);
				}
				break;
			case "size" : 
				System.out.println(stack.size());
				break;
			case "empty" : 
				if(!stack.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(1);
				}
				break;
			case "top" : 
				if(!stack.isEmpty()) {
					System.out.println(stack.peek());
				}else {
					System.out.println(-1);
				}
				break;
			}
		}
	}

}