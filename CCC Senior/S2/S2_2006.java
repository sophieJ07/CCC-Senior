import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class S2_2006 {
	String plaintext;
    String ciphertext;
    String text;
    HashMap <Character, Character> key;

    public S2_2006() throws FileNotFoundException{
        var file = new File("Data/S2/2006");
        var in = new Scanner(file);

        plaintext = in.nextLine();
        ciphertext = in.nextLine();
        text = in.nextLine();

        key = new HashMap<>();
        for(int i = 0; i < plaintext.length(); i++){
            key.put(ciphertext.charAt(i), plaintext.charAt(i));
        }
    }

    public void solve(){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            if(key.containsKey(text.charAt(i))){
                result.append(key.get(text.charAt(i)));
            }else result.append(".");
        }
        System.out.println(result);
    }
}
