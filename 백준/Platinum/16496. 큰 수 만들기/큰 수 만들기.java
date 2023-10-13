import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;



class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		String answer = "";
		int N = Integer.parseInt(br.readLine());
		String[] nums = new String[N]; 

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = st.nextToken();
		}
		
		Arrays.sort(nums, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return -( (o1+o2).compareTo(o2+o1) );
			}
			
		});
        
        for(String a : nums) {
        	answer += a;
        }
        
        if(answer.charAt(0) == '0') {
        	answer = "0"; 
        }
        
        System.out.println(answer);
	}
	
}