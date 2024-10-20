import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Numarare {
	static final int MOD = 1000000007;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new File("numarare.in"));
			PrintWriter writer = new PrintWriter(new File("numarare.out"))) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			List<Integer>[] graph1 = new ArrayList[N + 1];
			List<Integer>[] graph2 = new ArrayList[N + 1];

			for (int i = 1; i <= N; i++) {
				graph1[i] = new ArrayList<>();
				graph2[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				graph1[x].add(y);
			}

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				graph2[x].add(y);
			}

			writer.println(0);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
