import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class S2_2003 {
	Scanner in;
    int verseNum;

    public S2_2003() throws FileNotFoundException{
        var file = new File("Data/S2/2003");
        in = new Scanner(file);
        verseNum = Integer.parseInt(in.nextLine());


    }

    public void solve(){
        String l1, l2, l3, l4;
        for(int i = 0; i < verseNum; i++){
            l1 = lastSyllable(in.nextLine().toLowerCase());
            l2 = lastSyllable(in.nextLine().toLowerCase());
            l3 = lastSyllable(in.nextLine().toLowerCase());
            l4 = lastSyllable(in.nextLine().toLowerCase());

            if(l1.equals(l2) && l1.equals(l3) && l1.equals(l4)){
                System.out.println("perfect");
            }else if(l1.equals(l2) && l3.equals(l4)){
                System.out.println("even");
            }else if(l1.equals(l3) && l2.equals(l4)){
                System.out.println("cross");
            }else if(l1.equals(l4) && l2.equals(l3)){
                System.out.println("shell");
            }else System.out.println("free");
        }
    }

    public String lastSyllable(String a){
        int[] lastVowels = new int[5];
        String[] x = a.split(" ");
        a = x[x.length-1];

        lastVowels[0] = a.lastIndexOf('a');
        lastVowels[1] = a.lastIndexOf('e');
        lastVowels[2] = a.lastIndexOf('i');
        lastVowels[3] = a.lastIndexOf('o');
        lastVowels[4] = a.lastIndexOf('u');
        Arrays.sort(lastVowels);

        if(lastVowels[4] == -1){
            return a;
        }
        return (a.substring(lastVowels[4]));
    }


}
