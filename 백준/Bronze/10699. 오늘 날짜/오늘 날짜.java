import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	static int N, M; 
	static char[][] map; 
	static boolean[][][] v; 
	static int ans; 
	
	public static void main(String[] args) throws Exception {
		String pattern = "yyy-MM-dd";

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		Date now = new Date();

		String nowString = sdf.format(now);

		System.out.println(nowString); // 2012.10.09 17:07
	}
}