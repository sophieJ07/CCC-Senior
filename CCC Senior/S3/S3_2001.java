import java.util.ArrayList;
import java.util.Scanner;

//CCC '01 S3 - Strategic Bombing

public class S3_2001 {
    Node_path[] points;
    ArrayList<char[]> paths;

    public S3_2001(){
        Scanner in = new Scanner(System.in);
        String p = in.next();
        points = new Node_path[26];
        paths = new ArrayList<>();
        char a, b;
        while(!p.equals("**")){
            a = p.charAt(0);
            b = p.charAt(1);

            char[] path = {a, b};
            paths.add(path);

            if(points[a-'A'] == null) points[a-'A'] = new Node_path(a);
            if(points[b-'A'] == null) points[b-'A'] = new Node_path(b);

            points[a-'A'].neighbours[b-'A'] = points[b-'A'];
            points[b-'A'].neighbours[a-'A'] = points[a-'A'];

            p = in.next();
        }

    }

    public void solve(){
        char[] path;
        int count = 0;

        for(int i = 0; i < paths.size(); i++){
            path = paths.get(i);
            points[path[0] - 'A'].neighbours[path[1] - 'A'] = null;
            points[path[1] - 'A'].neighbours[path[0] - 'A'] = null;

            if(!canLink(points[0], points[1])) {
            	System.out.println(path[0] + "" + path[1]);
            	count++;
            }
            for(int j = 0; j < 26; j++){
                if(points[j] != null) points[j].visited = false;
            }

            points[path[0] - 'A'].neighbours[path[1] - 'A'] = points[path[1] - 'A'];
            points[path[1] - 'A'].neighbours[path[0] - 'A'] = points[path[0] - 'A'];
        }

        System.out.println("There are " + count + " disconnecting roads.");
    }

    public boolean canLink(Node_path start, Node_path end){
        start.visited = true;

        for(Node_path n : start.neighbours){
            if(n != null && !n.visited && (n == end || canLink(n, end))){
                return true;
            }
        }

        return false;
    }

}


class Node_path{
    char c;
    Node_path[] neighbours;
    boolean visited;

    public Node_path(char character){
        c = character;
        neighbours = new Node_path[26];
        visited = false;
    }

    public String toString(){
        StringBuilder ret = new StringBuilder();
        ret.append(c).append(":");
        for(int i = 0; i < 26; i++){
            if(neighbours[i] != null) ret.append(neighbours[i].c);
        }
        return ret.toString();
    }
}
