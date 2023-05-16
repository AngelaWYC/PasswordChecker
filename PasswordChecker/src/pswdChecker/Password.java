package pswdChecker;

/** This defines a password.
 *  The checks are done automatically upon creation as the constructor calls checkAll to run all checks.
 * 
 * @author Angela
 * 
 * References used:
 * https://www.w3schools.com/java/java_classes.asp
 * https://stackoverflow.com/questions/8894971/fix-eclipse-project-setup
 * https://stackoverflow.com/questions/4388546/how-to-determine-whether-a-string-contains-an-integer
 * https://junit.org/junit4/javadoc/4.8/org/junit/Assert.html#:~:text=assertEquals,-public%20static%20void&text=expected%2C%20Object%20actual)-,Asserts%20that%20two%20objects%20are%20equal.,null%20%2C%20they%20are%20considered%20equal.
 *
 */
public class Password {
	private String pswd;
	
	public Password(String password) {
		this.pswd = password;
		checkAll();
	}
	
	
	/** Checks if password fulfills integer check.
	 * 
	 * @return true or false depending on whether the check succeeded
	 */
	public boolean checkInt() {
		char c;
		for(int i = 0; i < pswd.length(); i++) {
			c = pswd.charAt(i);
			if(Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
	
	
	/** Method to run all other checks
	 * 
	 * @return string "Password valid" or "Invalid password" depending on if it passed/failed checks
	 */
	public String checkAll() {
		if(checkInt() == false) {
			return ("Invalid password, try again"); //password does not contain at least one int
		}
		return("Password valid");
	}
}
