import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S2_2005 {
	Scanner in;
    int c;
    int r;

    public S2_2005() throws FileNotFoundException{
        var file = new File("Data/S2/2005");
        in = new Scanner(file);

        c = in.nextInt();
        r = in.nextInt();
    }

    public void solve (){
        int x = 0;
        int y = 0;

        int a = in.nextInt();
        int b = in.nextInt();

        while(a != 0 && b != 0){
            x += a;
            y += b;

            if(x < 0) x = 0;
            else if (x > c) x = c;
            if(y < 0) y = 0;
            else if (y > r) y = r;

            System.out.println(x + " " + y);

            a = in.nextInt();
            b = in.nextInt();
        }
    }
}
