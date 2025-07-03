import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        
        while (true) {
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) break;

            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                names[i] = sc.nextLine();
            }

            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < 2 * n - 1; i++) {
                String[] parts = sc.nextLine().split(" ");
                int a = Integer.parseInt(parts[0]);
                values.add(a);
            }

            Collections.sort(values);
            for (int i = 0; i < values.size(); i += 2) {
                if (i == values.size() - 1 || !values.get(i).equals(values.get(i + 1))) {
                    result.add(names[values.get(i) - 1]);
                    break;
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println((i + 1) + " " + result.get(i));
        }
    }
}