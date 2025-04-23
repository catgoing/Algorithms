package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NofQueen {

	public static int[] arr;
	public static int N;
	public static int count = 0;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
 
		backTracking(0); // 0번 row부터 실행
		System.out.println(count);
 
	}
 
	public static void backTracking(int row) {
		
		if (row == N) {
			count++;
			return;
		}
 
		for (int i = 0; i < N; i++) { //row마다 col을 0부터 증가시켜가며 실행
			arr[row] = i; //array index = row, i = col | 최초 시작 좌표 0,0
			if (isPossible(row)) {
				// 현재 row에 queen을 놓은 경우 다음 row로 진행
				backTracking(row + 1); // 1, 0
			}
			
		}
 
	}
 
	public static boolean isPossible(int row) {
		for (int i = 0; i < row; i++) {
			if (arr[row] == arr[i]) { //0번부터 현재 row 전까지 row에 있는 queen의 열을 비교
				return false;
			} 
			
			else if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) { //대각선 상에 queen이 있는 경우
				return false;
			}
		}
		
		return true;
	}
}