package edu.qc.seclass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;



public class BuggyClassTestSC2 {

    @Test
    public void testBuggyMethod2() {
        BuggyClass buggyClass = new BuggyClass();

        int result1 = buggyClass.buggyMethod2(100, 25);
        assertEquals(1, result1);

        int result2 = buggyClass.buggyMethod2(2, 6);
        assertEquals(0, result2);

    }

}
