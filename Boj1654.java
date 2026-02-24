import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		long[] cables = new long[K];

		long max = 0;
		for (int i = 0; i < K; i++) {
			cables[i] = Long.parseLong(br.readLine().trim());
			if (cables[i] > max) {
				max = cables[i];
			}
		}

		long lo = 1;
		long hi = max;
		long answer = 0;

		while (lo <= hi) {
			long mid = lo + (hi - lo) / 2;
			long count = 0;

			for (int i = 0; i < K; i++) {
				count += cables[i] / mid;
			}

			if (count >= N) {
				answer = mid;
				lo = mid + 1;
			}
			else {
				hi = mid - 1;
			}
		}

		System.out.println(answer);
	}
}
