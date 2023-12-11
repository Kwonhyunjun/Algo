
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Data[] m; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine()); 
		
		m = new Data[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			int sT = Integer.parseInt(st.nextToken());
			int eT = Integer.parseInt(st.nextToken());
			m[i] = new Data(sT, eT); 
		}
		
		// 그리디 사전 작업(정렬)
		Arrays.sort(m, new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				// TODO Auto-generated method stub
				if(o1.end == o2.end) return o1.start - o2.start;
				return o1.end - o2.end;
			}
		});
		
		
		
		int cur = m[0].end; 
		int cnt = 1; 
		
		// 출력
		for(int i=1; i<N; i++) {
			if(m[i].start < cur) continue; // 다음 회의가 시작시간이 지났으면 회의 불가
//			System.out.println(m[i]);
			cnt++; 
			cur = m[i].end;
		}
		
		System.out.println(cnt);
		
	}
	
}

class Data{
	int start; 
	int end; 
	
	public Data(int start, int end) {
		this.start = start;
		this.end = end; 
	}

	@Override
	public String toString() {
		return "Data [start=" + start + ", end=" + end + "]";
	}
	
	

}
