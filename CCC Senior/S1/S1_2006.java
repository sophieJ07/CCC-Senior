import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S1_2006 {
	String mother;
    String father;
    int babyNum;
    String[] babies;

    public S1_2006() throws FileNotFoundException{
        var file = new File("Data/S1/2006");
        var in = new Scanner(file);

        mother = in.next();
        father = in.next();
        babyNum = in.nextInt();

        babies = new String[babyNum];
        for(int i = 0; i < babyNum; i++){
            babies[i] = in.next();
        }
    }

    public void solve(){
        char[] key = new char[5];

        char m1, m2, f1, f2;
        for(int i = 0; i < 10; i+=2){
            m1 = mother.charAt(i);
            m2 = mother.charAt(i+1);
            f1 = father.charAt(i);
            f2 = father.charAt(i+1);

            if(Character.isLowerCase(m1) && Character.isLowerCase(m2) && Character.isLowerCase(f1) && Character.isLowerCase(f2)){
                key[i/2] = 'R';
            }else if ((Character.isLowerCase(m1) || Character.isLowerCase(m2)) && (Character.isLowerCase(f1) || Character.isLowerCase(f2))){
                key[i/2] = 'B';
            }else key[i/2] = 'D';
        }

        for(String b : babies){
            boolean possible = true;
            for(int i = 0; i < 5; i++){
                if((key[i] == 'R' && Character.isUpperCase(b.charAt(i))) || (key[i] == 'D' && Character.isLowerCase(b.charAt(i)))){
                    possible = false;
                    break;
                }
            }

            if(possible) System.out.println("Possible baby.");
            else System.out.println("Not their baby!");
        }
    }
}
