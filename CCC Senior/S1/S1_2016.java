import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

//CCC '16 S1 - Ragaman

public class S1_2016 {
	String org;
    String anagram;

    public S1_2016() throws FileNotFoundException {
        var file = new File("Data/S1/2016");
        var in = new Scanner(file);

        org = in.next();
        anagram = in.next();
    }

    public void solve() {

        if (org.length() != anagram.length()) {
            System.out.println("N");
        } else{
            boolean isAnagram = true;
            int[] orgLetters = new int[26];
            int[] anagramLetters = new int[26];
            for(int i = 0; i < org.length(); i++){
                orgLetters[org.charAt(i) - 'a']++;
                if(anagram.charAt(i) != '*'){
                    anagramLetters[anagram.charAt(i)-'a']++;
                }
            }
            for(int i = 0; i < 26; i++){
                if(anagramLetters[i] > orgLetters[i]){
                    isAnagram = false;
                    break;
                }
            }
            if(isAnagram) System.out.println("A");
            else System.out.println("N");
        }
    }
}
