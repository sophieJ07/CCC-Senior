import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S1_2013 {
	int start;

	   public S1_2013() throws FileNotFoundException{
	       var file = new File("Data/S1/2013");
	       var in = new Scanner(file);

	       start = in.nextInt();
	   }

	   public void solve(){
	       int year = start+1;
	       while(!isDistinct(year)){
	           year++;
	       }
	       System.out.println(year);
	   }

	   public boolean isDistinct(int num){
	       boolean[] occur = new boolean[10];
	       while(num>0){
	           int d = num % 10;
	           if(occur[d]) return false;
	           occur[d] = true;
	           num /= 10;
	       }
	       return true;
	   }
}
