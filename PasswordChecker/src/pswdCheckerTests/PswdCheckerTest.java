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
	}
	
	
	@Test
	void testCap() {
		Password pwd2 = new Password("HEllo");
		assertEquals(pwd2.getCapPassed(), true, "Password contains an integer");
	}
	


}
