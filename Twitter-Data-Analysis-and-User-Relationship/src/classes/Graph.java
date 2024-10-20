package proje;

import java.util.Map;
import java.util.HashMap;

public class Graph {
	
    private Map<String, GraphNode> users;

    public Graph()
    {
        this.users = new HashMap<>();
    }

    public void addUser(Kullanıcı user)
    {
        GraphNode node = new GraphNode(user);
        users.put(user.getUsername(),node);
    }

    public GraphNode getUserNode(String username) {
        return users.get(username);
    }

    public void addFollower(String username, GraphNode follower)
    {
        GraphNode userNode = users.get(username);
        if(userNode!=null)
        {
            userNode.addFollower(follower);
        }
    }

    public void addFollowing(String username, GraphNode followingUser)
    {
        GraphNode userNode = users.get(username);
        if(userNode!=null)
        {
            userNode.addFollowing(followingUser);
        }
    }
    
    public Liste<GraphNode> getFollowers(String username) {
    	GraphNode node = users.get(username);
        return node.getFollowers();
    }
    public int getFollowersSize(String username) {
    	GraphNode node = users.get(username);
        return node.getFollowers().size();
    }

    public Liste<GraphNode> getFollowing(String username) {
    	GraphNode node = users.get(username);
        return node.getFollowing();
    }
    public int getFollowingSize(String username) {
    	GraphNode node = users.get(username);
        return node.getFollowing().size();
    }
}
