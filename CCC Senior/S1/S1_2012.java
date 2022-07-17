import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S1_2012 {
	int number;

    public S1_2012() throws FileNotFoundException{
        var file = new File("Data/S1/2012");
        var in = new Scanner(file);
        number = in.nextInt();
    }

    public void solve(){
        System.out.println((number-1)*(number-2)*(number-3)/6);
    }
}
