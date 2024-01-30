package proje;

public class GraphNode {
	
    private Kullanıcı user;
    private Liste<GraphNode> followers;
    private Liste<GraphNode> following;

    public GraphNode(Kullanıcı user)
    {
        this.user = user;
        this.followers = new Liste<>();
        this.following = new Liste<>();
    }

    public Kullanıcı getUser() {
        return user;
    }

    public Liste<GraphNode> getFollowers() {
        return followers;
    }

    public Liste<GraphNode> getFollowing() {
        return following;
    }

    public void addFollower(GraphNode follower) {
        followers.add(follower);
    }

    public void addFollowing(GraphNode followingUser) {
        following.add(followingUser);
    }
    
    @Override
    public String toString() {
        return user.getUsername();
    }
}
