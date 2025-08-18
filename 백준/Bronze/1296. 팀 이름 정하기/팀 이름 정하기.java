import java.io.*;
import java.util.*;

public class Main {
	static int[] letterCounts = new int[4];
	static int maxScore = -1;
	static String love = "LOVE";
	static String winningTeam = "";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String yourName = br.readLine();
		int teamCount = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < teamCount; i++) {
			String teamName = br.readLine();
			
			for(int j = 0; j < 4; j++) {
				int count = yourName.length() - yourName.replace(String.valueOf(love.charAt(j)), "").length();
				count += teamName.length() - teamName.replace(String.valueOf(love.charAt(j)), "").length();
				letterCounts[j] = count;
			}
			
			int score = 1;
			for(int j = 0; j < 4; j++) {
				for(int k = j + 1; k < 4; k++) {
					score *= (letterCounts[j] + letterCounts[k]);
				}
			}
			
			if(maxScore == (score % 100) && !winningTeam.equals("")) {
				String[] candidates = new String[2];
				candidates[0] = winningTeam;
				candidates[1] = teamName;
				Arrays.sort(candidates);
				winningTeam = candidates[0];
			}
			
			if(maxScore < (score % 100)) {
				maxScore = score % 100;
				winningTeam = teamName;
			}
		}
		System.out.println(winningTeam);
	}
}
