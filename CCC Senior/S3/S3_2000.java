import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

//CCC '00 S3 - Surfing

public class S3_2000 {
    int pageNum;
    Scanner in;
    ArrayList<URLNode> list;
    HashMap<String, Integer> dic;

    public S3_2000() throws FileNotFoundException {
        list = new ArrayList<>();
        dic = new HashMap<>();
        in = new Scanner(System.in);

        pageNum = Integer.parseInt(in.nextLine());
        String u;
        URLNode node;
        for(int i = 0; i < pageNum; i++){
            u = in.nextLine();
            node = createNode(u);
            findLinks(node);

        }

    }

    public void solve(){
        for(URLNode node : list){
            for(URLNode child: node.links){
                System.out.println("Link from " + node.url + " to " + child.url);
            }
        }

        String line = in.nextLine();
        String line2 = in.nextLine();
        while(true){

            if(canSurf(list.get(dic.get(line)), list.get(dic.get(line2)))){
                System.out.println("Can surf from " + line + " to " + line2);
            }else System.out.println("Can't surf from " + line + " to " + line2);
            reset();

            line = in.nextLine();
            if (line.equals("The End")) break;
            line2 = in.nextLine();
        }
    }

    public void reset(){
    	for(int i = 0; i < list.size(); i++) {
    		list.get(i).visited = false;
    	}
    }



    public boolean canSurf (URLNode start, URLNode end){
        start.visited = true;
        URLNode child;
        
        for(int i = 0; i < start.links.size(); i++) {
        	child = start.links.get(i);
        	if(!child.visited && (child == end || canSurf(child, end)))
                return true;
        }
        
        return false;
    }




    public void findLinks(URLNode n){
        String line = in.nextLine();
        String u;
        int index, end;
        end = 0;
        while(!line.equals("</HTML>")){
            end = 0;
            while(true) {
                index = line.indexOf("<A HREF=", end);
                if (index == -1) break;
                index += 9;
                end = line.indexOf(">", index) - 1;

                u = line.substring(index, end);
                System.out.println(u);
                n.addLink(createNode(u));

            }
            line = in.nextLine();
        }
    }

    public URLNode createNode(String u){

        URLNode node;
        if(dic.containsKey(u)){
            node = list.get(dic.get(u));
        }else{
            node = new URLNode(u);
            list.add(node);
            dic.put(u, list.size()-1);
        }
        return node;
    }

}

class URLNode {
    String url;
    boolean visited;
    ArrayList<URLNode> links;

    public URLNode(String u){
        url = u;
        visited = false;
        links = new ArrayList<>();
    }

    public String toString(){
        return url;
    }

    public void addLink(URLNode l){
        links.add(l);
    }
}

