package pswdCheckerTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import pswdChecker.Password;

/**
 * This class tests Password.java
 * 
 * @author Angela
 *
 *         https://www.w3schools.com/java/java_classes.asp
 *         https://stackoverflow.com/questions/1911109/how-do-i-clone-a-specific-git-branch
 *         https://stackoverflow.com/questions/5601931/how-do-i-safely-merge-a-git-branch-into-master
 *         https://opensource.com/article/21/4/cherry-picking-git#:~:text=What%20is%20cherry%2Dpick%3F,from%20a%20branch%20are%20combined.
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
class PswdCheckerTest {

  @Test
  void testNumberPass() {
    Password pwd1 = new Password("123hello");
    assertEquals(pwd1.getIntPassed(), true, "Password contains an integer");
    assertEquals(pwd1.checkAll(), "Invalid password, try again");
  }

  @Test
  void testUppercase() {
    Password pwd2 = new Password("HEllo");
    assertEquals(pwd2.getUpperPassed(), true, "Password contains an uppercase letter");
    assertEquals(pwd2.checkAll(), "Invalid password, try again");
  }

  @Test
  void testLowercase() {
    Password pwd4 = new Password("hello");
    assertEquals(pwd4.getLowerPassed(), true, "Password contains a lowercase letter");
    assertEquals(pwd4.checkAll(), "Invalid password, try again");
  }

  @Test
  void testNoSpace() {
    Password pwd5 = new Password("hello there");
    assertEquals(pwd5.getSpacePassed(), false, "Test should not pass as contains space");
  }

  @Test
  void testSymbol() {
    Password pwd6 = new Password("pass/word");
    assertEquals(pwd6.checkSymbol('/'), true, "Should be that true that / is an illegal character");
    assertEquals(pwd6.checkSymbol('"'), true, "Should be true that \" is an illegal character");
    assertEquals(pwd6.checkSymbol('\''), true, "Should be true that ' is an illegal character");
    assertEquals(pwd6.getSymbolPassed(), false,
        "Test should not pass as contains illegal symbol /");
  }

  @Test
  void testLength() {
    Password pwd7 = new Password("pass");
    Password pwd8 = new Password("Password123");
    assertEquals(pwd7.getLengthPassed(), false,
        "Password length less than intended eight characters");
    assertEquals(pwd8.getLengthPassed(), true, "Password exeeds character limit eight and passes");
  }

  @Test
  void testMessage() {
    Password pwd9 = new Password("Pswd");
    ArrayList<String> pwd9_msg1 = new ArrayList<String>(Arrays
        .asList("Password does not contain an integer", "Password is less than 8 characters"));
    ArrayList<String> pwd9_msg2 = pwd9.returnMessage();
    assertArrayEquals(pwd9_msg1.toArray(), pwd9_msg2.toArray());



    Password pwd10 = new Password("pass /word");
    ArrayList<String> pwd10_msg1 =
        new ArrayList<String>(Arrays.asList("Password does not contain an integer",
            "Password does not contain a capital letter", "Password contains spaces",
            "Password contains illegal characters \" ' or /"));
    ArrayList<String> pwd10_msg2 = pwd10.returnMessage();
    assertArrayEquals(pwd10_msg1.toArray(), pwd10_msg2.toArray());
  }

  @Test
  void testAll() {
    Password pwd3 = new Password("HEllo123");
    assertEquals(pwd3.checkAll(), "Password valid");
  }

  @Test
  void testAdditional() {
    Password pwd10 = new Password("albjnIL09");
    assertEquals(pwd10.checkAll(), "Password valid");

    Password pwd11 = new Password("jjnaskpk");
    assertEquals(pwd11.checkAll(), "Invalid password, try again");
  }

  @Test
  void testFinal() {
    Password pwd12 = new Password("Asd 123");
    assertEquals(pwd12.checkAll(), "Invalid password, try again");

    ArrayList<String> pwd12_msg1 = new ArrayList<String>(
        Arrays.asList("Password contains spaces", "Password is less than 8 characters"));
    ArrayList<String> pwd12_msg2 = pwd12.returnMessage();
    assertArrayEquals(pwd12_msg1.toArray(), pwd12_msg2.toArray());
  }



}
