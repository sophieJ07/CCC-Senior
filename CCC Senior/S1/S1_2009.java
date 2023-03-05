import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S1_2009 {
	int start;
    int end;

    public S1_2009() throws FileNotFoundException{
        var file = new File("Data/S1/2009");
        var in = new Scanner(file);
        start = in.nextInt();
        end = in.nextInt();
    }

    public void solve(){
        int result = 0;
        int current = 1;
        while(Math.pow(current, 6) <= end) {
            if(Math.pow(current, 6) >= start)
                result++;
            current++;
        }
        System.out.println(result);
    }
}

