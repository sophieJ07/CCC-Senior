import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S1_2007 {
	File file;
    Scanner in;
    int n;

    public S1_2007() throws FileNotFoundException{
        file = new File ("Data/S1/2007");
        in = new Scanner(file);
        n = in.nextInt();
    }

    public void solve(){
        int year;
        int month;
        int day;

        for(int i = 0; i < n; i++){
            year = in.nextInt();
            month = in.nextInt();
            day = in.nextInt();

            if((year < 1989)||(year == 1989 && month < 2)||(year == 1989 && month == 2 && day <= 27)){
                System.out.println("Yes");
            }else System.out.println("No");
        }
    }
}

