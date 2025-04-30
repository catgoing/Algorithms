package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Operator {
	
	static int max;
	static int min;
	static int N;
	static int[] arr;
	static int[] operations;
	
	public static void main(String[] args) throws IOException {
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		operations = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		backTracking(1, arr[0]);
		
		System.out.println(max);
		System.out.println(min);
		
	}

	
	
	
	public static void backTracking(int index, int result) {
		if(index == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for (int i = 0; i < operations.length; i++) {
			if(operations[i] > 0) {
				operations[i]--;
				
				if(i == 0) {
					backTracking(index + 1, result + arr[index]);
				} else if(i == 1) {
					backTracking(index + 1, result - arr[index]);
				} else if(i == 2) {
					backTracking(index + 1, result * arr[index]);
				} else {
					backTracking(index + 1, result / arr[index]);
				}
				
				operations[i]++;
			}
		}
	}

}
