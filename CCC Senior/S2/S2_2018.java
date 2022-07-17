import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//CCC '18 S2 - Sunflowers

public class S2_2018 {
	int n;
	int min;
	int[][] grid;
	
	public S2_2018() throws FileNotFoundException {
		var file = new File("Data/S2/2018");
		var in = new Scanner(file);
		n = in.nextInt();
		grid = new int[n][n];
		min = Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				grid[i][j] = in.nextInt();
				if(grid[i][j] < min) {
					min = grid[i][j];
				}
			}
		}
		in.close();
		
	}
	
	public void solve() {
		
		if(min == grid[0][0]) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(grid[i][j]+ " ");
				}
				System.out.println("");
			}
		}else if(min == grid[0][n-1]) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(grid[j][n-1-i]+ " ");
				}
				System.out.println("");
			}
		}else if(min==grid[n-1][0]) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(grid[n-1-j][i]+ " ");
				}
				System.out.println("");
			}
		}else {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(grid[n-1-i][n-1-j]+ " ");
				}
				System.out.println("");
			}
		}

	}

}
