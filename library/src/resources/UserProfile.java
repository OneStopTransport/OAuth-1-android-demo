package resources;

public class UserProfile {
	
	String username;
	String first_name;
	String last_name;
	boolean is_superuser;
	boolean is_staff;
	String last_login;
	String email;
	String date_joined;
	
	public UserProfile(String username, String first_name, String last_name,
			boolean is_superuser, String last_login, String email,
			String date_joined) {
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.is_superuser = is_superuser;
		this.last_login = last_login;
		this.email = email;
		this.date_joined = date_joined;
	}
	public UserProfile() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public boolean isIs_superuser() {
		return is_superuser;
	}
	public void setIs_superuser(boolean is_superuser) {
		this.is_superuser = is_superuser;
	}
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate_joined() {
		return date_joined;
	}
	public void setDate_joined(String date_joined) {
		this.date_joined = date_joined;
	}
	public boolean isIs_staff() {
		return is_staff;
	}
	public void setIs_staff(boolean is_staff) {
		this.is_staff = is_staff;
	}

}
