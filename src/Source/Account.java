package Source;

public class Account {
	String username;
	String password;
	String email;
	String title;
	String firstname;
	String surname;
	String DoB;
	
	@Override
	public String toString() {
		return username+","+password+","+email+","+title+","+firstname+","+surname+","+DoB;
	}
}
