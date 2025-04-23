package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NofQueen2 {
	
	static int N;
	static int answer;
	static int[] queens;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		queens = new int[N];
		
		backTracking(0);
		
		System.out.println(answer);
		
	}
	
	public static void backTracking(int row) {
		
		if(row == N) {
			answer++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			queens[row] = i;
			
			if(isPossible(row)) {
				backTracking(row + 1);
			}
			
		}
	}
	
	public static boolean isPossible(int row) {
		
		for (int i = 0; i < row; i++) {
			if(queens[i] == queens[row]) {
				return false;
			}
			
			if((row - i) == Math.abs(queens[row] - queens[i])) {
				return false;
			}
		}
		
		return true;
	}

}
