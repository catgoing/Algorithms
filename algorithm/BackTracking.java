package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackTracking {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int[m];
		
		backTracking(n, m, 0, a);
		
		System.out.println(sb);
		
	}
	
	public static void backTracking(int n, int m, int c, int[] a) {
		if(c == m) {
			sb.append(Arrays.toString(a).replace("[", "").replace("]", "").replace(",", ""));
			sb.append(" \n");
//			for (int i = 0; i < a.length; i++) {
//				sb.append(a[i]);
//			}
//			sb.substring(0, sb.length() - 1);
//			sb.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
				a[c] = i + 1;
				if(c > 0 && a[c] < a[c-1]) { // a[i]가 a[i-1]보다 작은 경우만 무시하면 된다
					continue;
				}
				backTracking(n, m, c + 1, a);
		}
	}

}
