import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//CCC '20 S2 - Escape Room

public class S2_2020 {
	static int[][] grid;
	static HashMap<Integer, ArrayList<int[]>> nums;
	static int n;
	static int m;
	static String result = "no";
	
	public S2_2020() throws FileNotFoundException{
		var file = new File("Data/S2/2020");
		Scanner in = new Scanner(file);
		m = in.nextInt();
		n = in.nextInt();
		
		nums = new HashMap<>();
		grid = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0; j<n;j++) {
				grid[i][j] = in.nextInt();
				
				ArrayList<int[]> p;
				int[] pair = {i,j};
				if(nums.containsKey(grid[i][j])) {
					p=nums.get(grid[i][j]);
					p.add(pair);
					nums.put(grid[i][j], p);
				}else {
					p = new ArrayList<>();
					p.add(pair);
					nums.put(grid[i][j], p);
				}
			}
		}
		
	}
	
	public static void solve() {
		jumps(m-1, n-1, 0);
		System.out.println(result);
	}
	
	public static void jumps(int i, int j, int jumps) {
		if(jumps > n*m) return; 
		if(i == 0 && j==0) {
			result = "yes";
			return;
		}
		
		int product = (i+1)*(j+1);
		for(int[] x: nums.get(product)) {
			jumps(x[0], x[1], jumps+1);
		}
		
	}

}
