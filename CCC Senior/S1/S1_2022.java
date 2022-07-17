import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//CCC '22 S1 - Good Fours and Good Fives

public class S1_2022 {
    int num;
    public S1_2022() throws FileNotFoundException{
        var file = new File("Data/S1/2022");
        var in = new Scanner(file);
        num = in.nextInt();
    }

    public void solve(){
        int ans = 0;
        int max = num/5 + 1;
        for(int i=0;i<max;i++){
            int x = num - (i*5);
            if(x>=0 && x%4 == 0) ans++;
        }
        System.out.println(ans);
    }
 
}
