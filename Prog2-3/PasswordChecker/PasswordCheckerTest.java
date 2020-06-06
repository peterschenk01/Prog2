
import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordCheckerTest {
    @Test public void testCheck_validPassword() {
      assertTrue(PasswordChecker.check("0ABCdef!"));
      assertTrue(PasswordChecker.check("ABCdef!0"));
      assertTrue(PasswordChecker.check("!ABCdef0"));
      assertTrue(PasswordChecker.check("#ABCdef0"));
      assertTrue(PasswordChecker.check(".ABCdef0"));
      assertTrue(PasswordChecker.check("?ABCdef0"));
      assertTrue(PasswordChecker.check("!ABCdef0"));
    }

    @Test public void testCheck_invalidCharacter() {
      assertFalse(PasswordChecker.check("0ABCdef!|"));
      assertFalse(PasswordChecker.check(";0ABCdef!"));
      assertFalse(PasswordChecker.check("$0ABCdef!"));
    }

    @Test public void testCheck_tooShort() {
      assertFalse(PasswordChecker.check(""));
      assertFalse(PasswordChecker.check("1234567"));
    }

    @Test public void testCheck_noDigit() {
      assertFalse(PasswordChecker.check("Abcdefgh#"));
    }

    @Test public void testCheck_noUpperCase() {
      assertFalse(PasswordChecker.check("abcdefg0#"));
    }

    @Test public void testCheck_noLowerCase() {
      assertFalse(PasswordChecker.check("ABCDEFG0#"));
    }

    @Test public void testCheck_noSpecial() {
      assertFalse(PasswordChecker.check("ABCDEFG01"));
    }
}
