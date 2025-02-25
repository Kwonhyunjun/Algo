import java.io.*;
import java.util.*;

public class Main {
	
	static int C, P, map[];
	static List<int[]>[] blocks;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		map = new int[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		blocks = new ArrayList[8];
		for(int i=1; i<8; i++) {
			blocks[i] = new ArrayList<>();
		}
		
//		blocks[1] = List.of(new int[]{0, 0, 0, 0}, new int[]{0});
//		blocks[2] = List.of(new int[]{0, 0});
//		blocks[3] = List.of(new int[]{0, 0, 1}, new int[]{1, 0});
//		blocks[4] = List.of(new int[]{1, 0, 0}, new int[]{0, 1});
//		blocks[5] = List.of(new int[]{0, 0, 0}, new int[]{0, 1}, new int[]{1, 0, 1}, new int[]{1, 0});
//		blocks[6] = List.of(new int[]{0, 0, 0}, new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{2, 0});
//		blocks[7] = List.of(new int[]{0, 0, 0}, new int[]{0, 2}, new int[]{1, 1, 0}, new int[]{0, 0});

		blocks[1].add(new int[] {0, 0, 0, 0});
		blocks[1].add(new int[] {0});
		
		blocks[2].add(new int[] {0, 0});
		
		blocks[3].add(new int[] {0, 0, 1});
		blocks[3].add(new int[] {1, 0});
		
		blocks[4].add(new int[] {1, 0, 0});
		blocks[4].add(new int[] {0, 1});
		
		blocks[5].add(new int[] {0, 0, 0});
		blocks[5].add(new int[] {0, 1});
		blocks[5].add(new int[] {1, 0, 1});
		blocks[5].add(new int[] {1, 0});
		
		blocks[6].add(new int[] {0, 0, 0});
		blocks[6].add(new int[] {0, 0});
		blocks[6].add(new int[] {0, 1, 1});
		blocks[6].add(new int[] {2, 0});
		
		blocks[7].add(new int[] {0, 0, 0});
		blocks[7].add(new int[] {0, 2});
		blocks[7].add(new int[] {1, 1, 0});
		blocks[7].add(new int[] {0, 0});
		
		int answer = 0;
		for(int[] shape : blocks[P]) {
			for(int i=0; i<=C-shape.length; i++) {
				boolean flag = true;
				int flat = map[i] - shape[0]; 
				for(int j=1; j<shape.length; j++) {
					if(flat != map[i+j] - shape[j]) {
						flag = false;
						break;
					}
				}
				if(flag) answer++; 
			}
		}
		
		System.out.println(answer);
		
		
	}

}