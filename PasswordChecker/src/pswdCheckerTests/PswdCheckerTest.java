package pswdCheckerTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pswdChecker.Password;

/** This class tests Password.java
 * 
 * @author Angela
 *
 * References used:
 * https://www.baeldung.com/junit-before-beforeclass-beforeeach-beforeall
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
	void testAll() {
		Password pwd3 = new Password("HEllo123");
		assertEquals(pwd3.checkAll(), "Password valid");
	}
	


}
