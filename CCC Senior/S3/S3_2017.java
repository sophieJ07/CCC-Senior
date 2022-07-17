import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

//CCC '17 S3 - Nailed It!

public class S3_2017 {
	int[] fenceLengths;
    ArrayList<Integer> woodHeights;
    int n;

    public S3_2017() throws FileNotFoundException {
        var file = new File("Data/S3/2017");
        var in = new Scanner(file);

        fenceLengths = new int[4001];
        woodHeights = new ArrayList<>();
        n = in.nextInt();
        for(int i = 0; i < n; i++){
            woodHeights.add(in.nextInt());
        }

    }

    public void solve(){
        for(int i = 2; i < fenceLengths.length; i++){
            int length = 0;
            for(int j = 0; j < woodHeights.size(); j++){
                if(woodHeights.contains(i-woodHeights.get(j))) length++;
            }
            length/=2;

            fenceLengths[i] = length;
        }

        int max = 0;
        int maxFences = 0;
        for(int i = 0; i < fenceLengths.length; i++){
            if(fenceLengths[i] > max){
                max = fenceLengths[i];
                maxFences = 1;
            }else if(fenceLengths[i] == max) maxFences++;
        }
        System.out.println(max + " " + maxFences);

    }

}
