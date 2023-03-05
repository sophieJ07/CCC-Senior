import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class S1_2005 {
	int n;
    String[] numbers;
    HashMap<Character, Character> digits;

    public S1_2005() throws FileNotFoundException{
        var file = new File("Data/S1/2005");
        var in = new Scanner(file);

        n = in.nextInt();
        numbers = new String[n];
        for(int i = 0; i < n; i++){
            numbers[i] = in.next();
        }

        digits = new HashMap<>() {{
            put('A', '2');
            put('B', '2');
            put('C', '2');
            put('D', '3');
            put('E', '3');
            put('F', '3');
            put('G', '4');
            put('H', '4');
            put('I', '4');
            put('J', '5');
            put('K', '5');
            put('L', '5');
            put('M', '6');
            put('N', '6');
            put('O', '6');
            put('P', '7');
            put('Q', '7');
            put('R', '7');
            put('S', '7');
            put('T', '8');
            put('U', '8');
            put('V', '8');
            put('W', '9');
            put('X', '9');
            put('Y', '9');
            put('Z', '9');
        }};

    }

    public void solve(){
        String result;
        for(String line : numbers){
            result = "";
            for(int i = 0; i < line.length() && result.length() < 10; i++){
                if(Character.isDigit(line.charAt(i))) result += line.charAt(i);
                else if(Character.isLetter(line.charAt(i))) result += digits.get(line.charAt(i));
            }
            
            System.out.println(result.substring(0, 3) + "-" + result.substring(3, 6) + "-" + result.substring(6));
        }
    }

}
