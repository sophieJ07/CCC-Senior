import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
//CCC '14 S3

public class S3_2014 {
    int testNum;
    ArrayList<Stack<Integer>> orders;
    ArrayList<ArrayList<Integer>> targets;

    public S3_2014(){
        Scanner in = new Scanner(System.in);
        testNum = in.nextInt();
        orders= new ArrayList<>();
        targets = new ArrayList<>();

        Stack<Integer> o;
        ArrayList<Integer> t;
        int testLength;

        for(int i = 0; i < testNum; i++){
            o = new Stack<>();
            t = new ArrayList<>();
            testLength = in.nextInt();
            for(int j = 0; j < testLength; j++){
                o.push(in.nextInt());
                t.add(testLength-j);
            }
            orders.add(o);
            targets.add(t);
        }

        

    }

    public void solve(){
        Stack<Integer> branch;
        ArrayList<Integer> t;
        Stack<Integer> o;
        boolean completed = true; 

        for(int i = 0; i < testNum; i++){
        	completed = true; 
            branch = new Stack<>();
            t = targets.get(i);
            o = orders.get(i);

            while(!t.isEmpty()){
            	if (!branch.isEmpty() && t.get(t.size()-1) == branch.peek()){
                    branch.pop();
                    t.remove(t.size()-1);
                    continue; 
            	}
            	
            	if(!o.isEmpty() && t.get(t.size()-1) != o.peek()){
                    branch.push(o.peek());
                    o.pop();
                    continue; 
                }
               
                if (!o.isEmpty() && t.get(t.size()-1) == o.peek()) {
                	o.pop();
                	t.remove(t.size()-1);
                	continue; 
                }
                
                completed = false; 
                break;
        
            }
            
            if(completed) System.out.println("Y");
            else System.out.println("N");
        }

    }
}
