package edu.qc.seclass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BuggyClassTestBC3 {

    @Test
    public void testBuggyMethod3() {
        BuggyClass buggyClass = new BuggyClass();
        int result = buggyClass.buggyMethod3(10, 2);
        assertEquals(12, result);
        int result2 = buggyClass.buggyMethod3(2, 4);
        assertEquals(3, result2);
    }

}
