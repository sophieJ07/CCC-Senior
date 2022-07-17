import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//CCC '16 S2 - Tandem Bicycle

public class S2_2016 {
	int[] dmojistan;
    int[] pegland;
    int question;
    int n;

    public S2_2016() throws FileNotFoundException{
        var file = new File("Data/S2/2016");
        var in = new Scanner(file);

        question = in.nextInt();
        n = in.nextInt();
        dmojistan = new int[n];
        pegland = new int[n];

        for(int i = 0; i < n; i++){
            dmojistan[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++){
            pegland[i] = in.nextInt();
        }

        Arrays.sort(dmojistan);
        Arrays.sort(pegland);
    }

    public void solve(){
        if(question == 1) min();
        else max();
    }

    public void min(){
        int total = 0;
        for(int i = 0; i < n; i++){
            total += Math.max(dmojistan[i], pegland[i]);
        }
        System.out.println(total);
    }

    public void max(){
        int total = 0;
        for(int i = 0; i < n; i++){
            total += Math.max(dmojistan[i], pegland[n-i-1]);
        }
        System.out.println(total);
    }
}
