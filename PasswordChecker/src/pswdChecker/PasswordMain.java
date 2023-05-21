package pswdChecker;

import java.util.Scanner;  

public class PasswordMain {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);  
		Password pswd = null;
		String result = "";
		
		while(!result.equals("Password valid")) {
			System.out.println("Enter password: ");
			String password = sc.nextLine();
			pswd = new Password(password);
			result = pswd.checkAll();
			System.out.println(pswd.checkAll());
		}
		
		sc.close();
	
	}

}
