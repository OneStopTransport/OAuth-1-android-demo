package resources;

public class UserMessage {
	
	boolean is_developer;
	UserProfile user;

	public UserMessage(boolean is_developer, UserProfile user) {
		this.is_developer = is_developer;
		this.user = user;
	}
	public UserMessage() {
		super();
	}
	public boolean isIs_developer() {
		return is_developer;
	}
	public void setIs_developer(boolean is_developer) {
		this.is_developer = is_developer;
	}
	public UserProfile getUser() {
		return user;
	}
	public void setUser(UserProfile user) {
		this.user = user;
	}

}
