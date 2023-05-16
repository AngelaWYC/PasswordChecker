package pswdCheckerTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pswdChecker.Password;

class PswdCheckerTest {

	@Test
	void testCreatePassword() {
		Password pwd1 = new Password("hello");
		assertEquals(pwd1.checkInt(), false, "Checks that pwd1 password should fail checkInt as it does not have any ints");
		assertEquals(pwd1.checkAll(), "Invalid password, try again");
	}

}
