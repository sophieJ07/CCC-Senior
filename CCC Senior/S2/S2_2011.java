import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S2_2011 {
	int n;
    String[] student;
    String[] answers;

    public S2_2011() throws FileNotFoundException{
        var file = new File("Data/S2/2011");
        var in = new Scanner(file);

        n = in.nextInt();
        student = new String[n];
        answers = new String[n];

        for(int i = 0; i < n; i++){
            student[i] = in.next();
        }
        for(int i = 0; i < n; i++){
            answers[i] = in.next();
        }
    }

    public void solve(){
        int score = 0;
        for(int i = 0; i < n; i++){
            if(student[i].equals(answers[i])){
                score++;
            }
        }
        System.out.println(score);
    }
}
