import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class S2_2004
{
    Scanner in;
    int[] score;
    int[] rank;
    int[] worstRank;
    int yodellerNum;
    int roundNum;

    
    public S2_2004() throws FileNotFoundException{
    	var file = new File("Data/S2/2004");
        in = new Scanner(file);
        
        yodellerNum = in.nextInt();
        roundNum = in.nextInt();
        score = new int [yodellerNum];
    	rank = new int [yodellerNum];
    	worstRank = new int [yodellerNum];
        
    }
   
    public void solve() {

    	for (int i = 0 ; i < yodellerNum ; i++){
    		score [i] = 0;
    		worstRank [i] = 1;
    	}

    	for (int i = 0 ; i < roundNum ; i++){
    		for (int j = 0 ; j < yodellerNum ; j++) {
    			score [j] += in.nextInt();
    		}
    		
    		for (int j = 0 ; j < yodellerNum ; j++){
    			int r = 1;
    			for (int k = 0 ; k < yodellerNum ; k++) {
    			    if (score [k] > score [j]) r++;
    			}
    			if (r > worstRank [j]) worstRank [j] = r;
    			rank [j] = r;
    		}
  	
    	}
    	
    	for (int i = 0 ; i < yodellerNum ; i++) {
    		if (rank [i] == 1) {
    			System.out.println ("Yodeller " + (i + 1) + " is the TopYodeller: score " + score [i] + ", worse rank " + worstRank [i]);
    		}
    	}
    }
}

