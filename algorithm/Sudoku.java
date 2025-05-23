package algorithm;
/*
0 3 5 4 6 9 2 7 8
7 8 2 1 0 5 6 0 9
0 6 0 2 7 8 1 3 5
3 2 1 0 4 6 8 9 7
8 0 4 9 1 3 5 0 6
5 9 6 8 2 0 4 1 3
9 1 7 6 5 2 0 8 0
6 0 3 7 0 1 9 5 2
2 5 8 3 9 4 7 6 0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Sudoku {
	
	static int[][] map;
	static List<int[]> target;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		
		map = new int[9][9];
		target = new ArrayList<>();
		sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					target.add(new int[] {i, j});
				}
			}
		}
		backTracking(0);
		
		System.out.println(sb);
		
	}
	
	public static void backTracking(int targetNo) {
		if(targetNo == target.size()) {
			for (int i = 0; i < map.length; i++) {
				sb.append(Arrays.toString(map[i]).replace("[", "").replace("]", "").replace(",", ""));
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		int x = target.get(targetNo)[0];
		int y = target.get(targetNo)[1];
		for (int i = 0; i < 9; i++) {
			if(isPossible(x, y, i + 1)) {
				map[x][y] = i + 1;
				backTracking(targetNo + 1);
				map[x][y] = 0;
			}
		}
		
	}
	
	public static boolean isPossible(int x, int y, int value) {

		int squareX = (x / 3) * 3;
		int squareY = (y / 3) * 3;
		
		//가로줄 체크
		for (int i = 0; i < 9; i++) {
			if(value == map[x][i]) {
				return false;
			}
		}
		
		//세로줄 체크
		for (int i = 0; i < 9; i++) {
			if(value == map[i][y]) {
				return false;
			}
		}
		
		//3x3 체크
		
		for (int i = squareX; i < squareX + 3; i++) {
			for (int j = squareY; j < squareY + 3; j++) {
				if(value == map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
