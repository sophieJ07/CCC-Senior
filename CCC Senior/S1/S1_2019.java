import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//CCC '19 S1 - Flipper

public class S1_2019 {
    int[][] org = {{1,2},{3,4}};
    String l;

    public S1_2019() throws FileNotFoundException{
    	var file = new File("Data/S1/2019");
        Scanner in = new Scanner(file);
        l = in.next();
    }

    public void solve(){
        int h = 0;
        int v = 0;

        for(int i=0;i<l.length();i++){
            if(l.charAt(i)=='H') h++;
            else v++;
        }

        if(h%2 == 1){
            int[][] m = new int[2][2];
            m[0][0] = org[0][1];
            m[0][1] = org[0][0];
            m[1][0] = org[1][1];
            m[1][1] = org[1][0];
            org = m;
        }
        if(v%2 == 1){
            int[][] n = new int[2][2];
            n[0][0] = org[1][0];
            n[0][1] = org[1][1];
            n[1][0] = org[0][0];
            n[1][1] = org[0][1];
            org = n;
        }

        for(int i=0; i<2;i++){
            for(int j=0;j<2;j++){
                System.out.print(org[i][j]+ " ");
            }
            System.out.println();
        }
    }

}
