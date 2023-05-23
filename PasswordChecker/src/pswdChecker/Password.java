package pswdChecker;

import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;

/**
 * This defines a password. The checks are done automatically upon creation as the constructor calls
 * checkAll to run all checks.
 * 
 * @author Angela
 * 
 *         References used: https://www.w3schools.com/java/java_classes.asp
 *         https://stackoverflow.com/questions/8894971/fix-eclipse-project-setup
 *         https://stackoverflow.com/questions/4388546/how-to-determine-whether-a-string-contains-an-integer
 *         https://junit.org/junit4/javadoc/4.8/org/junit/Assert.html#:~:text=assertEquals,-public%20static%20void&text=expected%2C%20Object%20actual)-,Asserts%20that%20two%20objects%20are%20equal.,null%20%2C%20they%20are%20considered%20equal.
 *         https://www.techrepublic.com/videos/how-to-push-a-new-project-to-github/
 *         https://stackoverflow.com/questions/52126561/how-do-i-use-the-characters-equals-method-in-java
 *         https://www.informit.com/articles/article.aspx?p=30241&seqNum=3
 *         https://stackoverflow.com/questions/3867151/possible-to-return-a-string-array
 *         https://stackoverflow.com/questions/14098032/add-string-to-string-array
 *         https://stackoverflow.com/questions/15456910/arraylist-equality-junit-testing
 *         https://www.java67.com/2015/10/how-to-declare-arraylist-with-values-in-java.html
 *         https://www.baeldung.com/junit-before-beforeclass-beforeeach-beforeall
 *         https://stackoverflow.com/questions/1911109/how-do-i-clone-a-specific-git-branch
 *         https://www.mygreatlearning.com/blog/readme-file/#:~:text=The%20Readme%20file%20is%20often,about%20the%20patches%20or%20updates.
 *         https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/managing-repository-settings/setting-repository-visibility
 *         https://github.com/google/google-java-format
 */
public class Password {
  private String pswd;
  private int minLength = 8;
  private boolean allPassed = false;

  private boolean intPassed = false;
  private boolean upperPassed = false;
  private boolean lowerPassed = false;
  private boolean spacePassed = true;
  private boolean symbolPassed = true;
  private boolean lengthPassed = false;

  public boolean getIntPassed() {
    return this.intPassed;
  }

  public boolean getUpperPassed() {
    return this.upperPassed;
  }

  public boolean getLowerPassed() {
    return this.lowerPassed;
  }

  public boolean getSpacePassed() {
    return this.spacePassed;
  }

  public boolean getSymbolPassed() {
    return this.symbolPassed;
  }

  public boolean getLengthPassed() {
    return this.lengthPassed;
  }

  public boolean getAllPassed() {
    return this.allPassed;
  }

  /**
   * Password constructor which accepts a string.
   * 
   * @param password the string of which checks are run on.
   */
  public Password(String password) {
    this.pswd = password;

    checkAll();
  }


  /**
   * Iterates through the password and calls all relevant check methods. if checkspace returns false
   * (ie there is no space, do nothing) otherwise if checkspace returns true (there was a space; set
   * spacePassed to false)
   * 
   * @return boolean depending on whether the password fulfilled all criteria or not.
   */
  public boolean iterate() {
    char c;
    for (int i = 0; i < pswd.length(); i++) {
      c = pswd.charAt(i);

      if (checkInt(c) == true) {
        this.intPassed = true;
      }
      if (checkUpper(c) == true) {
        this.upperPassed = true;
      }
      if (checkLower(c) == true) {
        this.lowerPassed = true;
      }
      if (checkSpace(c) == true) {
        this.spacePassed = false;
      }
      if (checkSymbol(c) == true) {
        this.symbolPassed = false;
      }
      if (checkLength() == true) {
        this.lengthPassed = true;
      }


    }

    if (intPassed == true && upperPassed == true && lowerPassed == true && spacePassed == true
        && symbolPassed == true && lengthPassed == true) {
      this.allPassed = true;
      return true;
    }
    return false;
  }


  /**
   * Checks if password fulfills integer check.
   * 
   * @param s the character to check if it is an int or not.
   * @return true or false depending on whether the password contained an integer or not.
   */
  public boolean checkInt(char s) {
    if (Character.isDigit(s)) {
      return true;
    }
    return false;
  }


  /**
   * Checks if password fulfills capital letter check.
   * 
   * @param s the character to check if it is capital or not.
   * @return true or false depending on whether password contained a capital or not.
   */
  public boolean checkUpper(char s) {
    if (Character.isUpperCase(s)) {
      return true;
    }
    return false;
  }


  /**
   * Checks if password fulfills lower case letter check.
   * 
   * @param s the character to check if it is lower case or not.
   * @return true or false depending on whether password contained a lower case letter or not.
   */
  public boolean checkLower(char s) {
    if (Character.isLowerCase(s)) {
      return true;
    }
    return false;
  }


  /**
   * Checks if there is a space. If password contains a space returns true, otherwise returns false.
   * 
   * @param s character to check if it is a space
   * @return boolean true or false depending on whether the password contains a space.
   */
  public boolean checkSpace(char s) {
    if (s == ' ') {
      return true;
    } else {
      return false;
    }
  }


  /**
   * Checks if there is a special character.
   * 
   * @param s character s to check if it is a symbol ('"/).
   * @return true if symbol was found, otherwise returns false.
   */
  public boolean checkSymbol(char s) {
    if (s == '/' || s == '"' || s == '\'') {
      return true;
    } else {
      return false;
    }
  }


  /**
   * Checks if the length fulfills a min number of characters.
   * 
   * @return true if criteria met (min characters met) or false if password not long enough.
   */
  public boolean checkLength() {
    if (this.pswd.length() >= this.minLength) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns an array of messages depending on which check failed. This is achieved by the program
   * looking at the private booleans altered in the different check methods.
   * 
   * @return Array of Strings as messages informing the user which check failed.
   */
  public ArrayList<String> returnMessage() {
    ArrayList<String> msg = new ArrayList<String>();

    if (this.intPassed == false) {
      msg.add("Password does not contain an integer");
    }
    if (this.upperPassed == false) {
      msg.add("Password does not contain a capital letter");
    }
    if (this.lowerPassed == false) {
      msg.add("Password does not contain a decapitalised letter");
    }
    if (this.spacePassed == false) {
      msg.add("Password contains spaces");
    }
    if (this.symbolPassed == false) {
      msg.add("Password contains illegal characters \" ' or /");
    }
    if (this.lengthPassed == false) {
      msg.add("Password is less than " + this.minLength + " characters");
    }

    return msg;
  }


  /**
   * Method to run all other checks.
   * 
   * @return string "Password valid" or "Invalid password" depending on if checks passed/failed.
   */
  public String checkAll() {
    if (this.pswd == null) {
      return "Invalid password, try again";
    }

    if (iterate() == true) {
      return "Password valid";
    } else {
      return "Invalid password, try again";
    }

  }

}
