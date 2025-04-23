package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*

4 2
20 26 185 80
100 20 25 80
20 20 88 99
15 32 44 50
1 2
2 3

633



4 1
2 1 996 995
2 997 998 999
2 2 1 2
2 2 2 2
1 3

3988

 */

public class Temp {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] sp;
	static int[][] map;
	static int result;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = 0;
		
		
		map = new int[n+1][n+1];
		
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		
		sp = new int[m][2]; // 친구들의 시작좌표를 보관하는 배열
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sp[i] = new int[] {x, y};
			result += map[x][y];
			map[x][y] = 0;
		}
		
		dfs(0, 0, sp[0][0], sp[0][1], result);
		
		System.out.println(result);

	}
	
	public static void dfs(int friendOrder, int move, int x, int y, int captured) throws InterruptedException {
		result = Math.max(result, captured);
		StringBuilder sb = new StringBuilder();
		sb.append(friendOrder);
		sb.append(", ");
		sb.append(move);
		sb.append(", ");
		sb.append(x);
		sb.append(", ");
		sb.append(y);
		sb.append(", ");
		sb.append(captured);
		
		System.out.println(sb);
		
		if(move == 3) {
			System.out.println("move: 3!!!!");
			if(friendOrder+1 < m) {
				System.out.println("friendOrder: " + friendOrder+1);
				dfs(friendOrder+1, 0, sp[friendOrder+1][0], sp[friendOrder+1][1], captured);
			}
		}
		else {
			for (int i = 0; i < dx.length; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				
				if(nextX < n + 1 && nextX > 0 && nextY < n + 1 && nextY > 0) {
//					System.out.println();
//					System.out.println(nextX + ", " + nextY);
//					System.out.println("move: " + move);
//					System.out.println();
					int recover = map[nextX][nextY]; 
					map[nextX][nextY] = 0;
					dfs(friendOrder, move+1, nextX, nextY, captured+recover);
					map[nextX][nextY] = recover;
				}
			}
		}
 	}

}
