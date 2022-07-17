import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//CCC '21 S2 - Modern Art

public class S2_2021 {
	int n, m, x;
	boolean row[];
	boolean column[];
	
	public S2_2021() throws FileNotFoundException {
		var file = new File("Data/S2/2021");
		var in = new Scanner(file);
		
	    n =in.nextInt();
	    m =in.nextInt();
	    x = in.nextInt();

	    row = new boolean[n+1];
	    column = new boolean[m+1];
	    
	    for(int i=0;i<x;i++){
	      String d = in.next();
	      int k = in.nextInt();
	      if(d.equals("R")){
	        row[k] = !row[k];
	      }else{
	        column[k]=!column[k];
	      }   
	    }
	}
	
	public void solve(String[] args) {

	    int r = 0;
	    for(int i=0;i<row.length;i++){
	      if(row[i]) r++;
	    }

	    int c = 0;
	    for(int i=0;i<column.length;i++){
	      if(column[i]) c++;
	    }

	    int total = r*m + c*n;
	    total -= 2*r*c;

	    System.out.println(total);
	    
	  }
}
