package proje;

public class Kullanıcı {

	public String username;
	public String name;
	public int followers_count;
	public int following_count;
	public String language;
	public String region;
	public String[] tweets;
	public String[] following;
	public String[] followers;
	
	public Kullanıcı() {}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFollowers_count() {
		return followers_count;
	}
	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}
	public int getFollowing_count() {
		return following_count;
	}
	public void setFollowing_count(int following_count) {
		this.following_count = following_count;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String[] getTweets() {
		return tweets;
	}
	public int getTweetsSize() {		
		return tweets.length;
	}
	public void setTweets(String[] tweets) {
		this.tweets = tweets;
	}
	public String[] getFollowing() {
		return following;
	}
	public void setFollowing(String[] following) {
		this.following = following;
	}
	public String[] getFollowers() {
		return followers;
	}
	public void setFollowers(String[] followers) {
		this.followers = followers;
	}
	
	
	
}
