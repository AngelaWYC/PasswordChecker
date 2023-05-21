package pswdCheckerTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pswdChecker.Password;

/** This class tests Password.java
 * 
 * @author Angela
 *
 * References used:
 * https://www.baeldung.com/junit-before-beforeclass-beforeeach-beforeall
 * https://www.informit.com/articles/article.aspx?p=30241&seqNum=3
 * https://stackoverflow.com/questions/52126561/how-do-i-use-the-characters-equals-method-in-java
 * 
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
		assertEquals(pwd6.getSymbolPassed(), false, "Test should not pass as contains illegal symbol /");
	}
	
	@Test
	void testLength() {
		Password pwd7 = new Password("pass");
		Password pwd8 = new Password("Password123");
		assertEquals(pwd7.getLengthPassed(), false, "Password length less than intended eight characters");
		assertEquals(pwd8.getLengthPassed(), true, "Password exeeds character limit eight and passes");
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
	


}
