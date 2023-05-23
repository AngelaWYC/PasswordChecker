package pswdChecker;

import java.util.Scanner;

public class PasswordMain {

  /**
   * Main method invokes a prompt for the user to enter their password. While the result is not
   * "Password valid", the program continues to loop.
   * 
   * @param args accepts a string of arguments, though not currently in use.
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Password pswd = null;
    String result = "";


    while (!result.equals("Password valid")) {
      System.out.println("\nEnter password: ");
      String password = sc.nextLine();
      pswd = new Password(password);
      result = pswd.checkAll();
      System.out.println(pswd.checkAll());

      if (pswd.returnMessage().size() == 0) {
        continue;
      } else {
        System.out.println(pswd.returnMessage());
      }
    }

    sc.close();

  }

}
