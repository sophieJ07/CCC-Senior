import java.util.Scanner;
import java.util.ArrayList;

//CCC '16 S3 - Phonomenal Reviews

public class S3_2016 {
    int restaurantNum, phoNum, total;
    RestaurantNode[] restaurants;
    RestaurantNode furthest, root;

    public S3_2016(){
        Scanner in = new Scanner(System.in);
        restaurantNum = in.nextInt();
        phoNum = in.nextInt();
        restaurants = new RestaurantNode[restaurantNum];
        furthest = null;

        int tmp = 0;
        for(int i = 0; i < phoNum; i++){
            tmp = in.nextInt();
            restaurants[tmp] = new RestaurantNode(true);
        }
        root = restaurants[tmp];

        for(int i = 0; i < restaurantNum; i++){
            if(restaurants[i] == null) restaurants[i] = new RestaurantNode(false);
        }

        int r1, r2;
        for(int i = 0; i < restaurantNum - 1;i++){
            r1 = in.nextInt();
            r2 = in.nextInt();
            restaurants[r1].paths.add(restaurants[r2]);
            restaurants[r2].paths.add(restaurants[r1]);
        }


    }


    void solve() {
        markIfHasPathDescendant(root);
        reset();

        furthest = root;
        findFurthest(root);
        reset();

        findFurthest(furthest);
        
        total = 0; 
        solveTree(root, root);
        total -= furthest.distance;
        
        System.out.println(total);

    }
    
    void solveTree(RestaurantNode node, RestaurantNode previous) {
    	RestaurantNode current;
    	for(int i = 0; i < node.paths.size(); i++) {
    		current = node.paths.get(i);
    		if(current != previous && current.onPath) {
    			total += 2;
    			solveTree(current, node);
    		}
    	}
    }

    void reset(){
        for(RestaurantNode n : restaurants){
            n.visited = false;
            n.distance = 0;
        }
    }

    void findFurthest(RestaurantNode node) {
        node.visited = true;
        for (RestaurantNode child : node.paths){
            if (!child.visited && child.onPath){
                child.distance = node.distance + 1;
                if (child.distance > furthest.distance) {
                    furthest = child;
                }
                findFurthest(child);
            }
        }
    }

    void markIfHasPathDescendant(RestaurantNode node){
        node.visited = true;
        for(RestaurantNode child : node.paths){
            if(!child.visited) {
                markIfHasPathDescendant(child);
                if(child.onPath) node.onPath = true;
            }
        }
    }
}



class RestaurantNode {

    boolean onPath, visited;
    int distance;
    ArrayList<RestaurantNode> paths;


    public RestaurantNode(boolean p) {
        onPath = p;
        visited = false;
        paths = new ArrayList<>();
        distance = 0;

    }
}



