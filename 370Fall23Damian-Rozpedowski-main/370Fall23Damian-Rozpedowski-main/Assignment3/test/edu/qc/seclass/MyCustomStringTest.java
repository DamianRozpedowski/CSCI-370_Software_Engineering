package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    // This test checks if the countNumber method throws a NullPointerException is the string is null
    @Test (expected = NullPointerException.class)
    public void testCountNumbers1() {
        mycustomstring = null;
        mycustomstring.countNumbers();
    }

    // This test checks that the countNumbers method is properly returning the total number of numbers, contiguous sequence of digits are considered 1 number
    @Test
    public void testCountNumbers2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    // This test checks if the countNumber method returns 0 if no numbers are present in the string
    @Test
    public void testCountNumbers3() {
        mycustomstring.setString("No numbers are present in this string");
        assertEquals(0, mycustomstring.countNumbers());
    }

    // This test makes sure the countNumber method returns 0 when the string is empty
    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    // This test makes sure that the countNumber method returns the number of numbers when only separated by spaces, making sure continuous sequence of digits work properly
    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("123 45 6 78 90");
        assertEquals(5, mycustomstring.countNumbers());
    }

    // This test makes sure the countNumber method still count the appropriate number of numbers even if they're negative
    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("-999 55 -2");
        assertEquals(3, mycustomstring.countNumbers());
    }

    //This method makes sure the getEveryNthCharacterFromBeginningOrEnd method throws a NullPointerException when the string is null
    @Test (expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring = null;
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false);
    }

    //This method makes sure the getEveryNthCharacterFromBeginningOrEnd method throws a IllegalArgumentException when n = 0
    @Test (expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("test n <= 0");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }

    //This method makes sure the getEveryNthCharacterFromBeginningOrEnd method throws a IllegalArgumentException when n is negative
    @Test (expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("test n <= 0");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-5, false);
    }

    // This test makes sure the getEveryNthCharacterFromBeginningOrEnd method returns a string that consists of the characters in positions n, 2n, ... starting form the beginning
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    // This test makes sure the getEveryNthCharacterFromBeginningOrEnd method returns a string that consists of the characters in positions n, 2n, ... starting form the end
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    // This method makes sure the getEveryNthCharacterFromBeginningOrEnd method returns an empty string when the string is empty
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    // This method makes sure the getEveryNthCharacterFromBeginningOrEnd method returns an empty string when string has less than n characters
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("da");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    // This method makes sure the getEveryNthCharacterFromBeginningOrEnd method returns the same string when n=1, and it starts from the beginning
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("This text should remain the same");
        assertEquals("This text should remain the same", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    // This method makes sure the getEveryNthCharacterFromBeginningOrEnd method returns the same string when n=1, and it starts from the end
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("This text should also remain the same");
        assertEquals("This text should also remain the same", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }

    // This method makes sure the getEveryNthCharacterFromBeginningOrEnd method returns a string of symbols when n =2, and it starts from the beginning
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("!@#$%^&*()_+");
        assertEquals("@$^*)+", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    // This method makes sure the getEveryNthCharacterFromBeginningOrEnd method returns a string of spaces when n=2, and it starts from the beginning, with the given string having a space on every n character
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        mycustomstring.setString("S P A C E");
        assertEquals("    ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    // This method makes sure the getEveryNthCharacterFromBeginningOrEnd method returns the proper string from a string with the same character
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("555555555555555");
        assertEquals("555", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, false));
    }

    // This method makes sure the getEveryNthCharacterFromBeginningOrEnd method returns a string from a url string, urls can be used as strings, ensures special characters, digits, and regular characters can be used together
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("https://github.com/qc-se-fall23/370Fall23Damian-Rozpedowski");
        assertEquals(":hme2FD-d", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, false));
    }

    // This method makes sure the getEveryNthCharacterFromBeginningOrEnd method returns a string with one character if n=1 and the string length is 1
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString("1");
        assertEquals("1", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    // This test makes sure the convertDigitsToNamesInSubstring method throws an IllegalArgumentException when the start position is greater than the end position
    @Test (expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("startPos > endPos");
        mycustomstring.convertDigitsToNamesInSubstring(5, 2);
    }

    // This test makes sure the convertDigitsToNamesInSubstring method throws an MyIndexOutOfBoundsException when the start position is out of bounds
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("startPosition or endPosition OOB");
        mycustomstring.convertDigitsToNamesInSubstring(2, 125);
    }

    // This test makes sure the convertDigitsToNamesInSubstring method throws an MyIndexOutOfBoundsException when the end position is out of bounds
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("startPosition or endPosition OOB");
        mycustomstring.convertDigitsToNamesInSubstring(-5, 5);
    }

    // This test makes sure the convertDigitsToNamesInSubstring method throws an NullPointerException when the current string is null
    @Test (expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring = null;
        mycustomstring.convertDigitsToNamesInSubstring(1, 2);
    }

    // This test makes sure the convertDigitsToNamesInSubstring method is able to replace digits in a larger string with characters,symbols,and digits with their respective string value between the start and end position
    @Test
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    // This test checks that the convertDigitsToNamesInSubstring method replaces a digit where the start and end position are the same, this should only change 1 digit if applicable
    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("Test: 685");
        mycustomstring.convertDigitsToNamesInSubstring(7, 7);
        assertEquals("Test: Six85", mycustomstring.getString());
    }

    // This test checks that the convertDigitsToNamesInSubstring method does not replace anything if there are no digits to be replaced between the start and end position
    @Test
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("Testing No Digits");
        mycustomstring.convertDigitsToNamesInSubstring(1, 17);
        assertEquals("Testing No Digits", mycustomstring.getString());
    }

    // This test checks that the convertDigitsToNamesInSubstring method works on a basic string of numbers
    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("0719");
        mycustomstring.convertDigitsToNamesInSubstring(1, 4);
        assertEquals("ZeroSevenOneNine", mycustomstring.getString());
    }

}
