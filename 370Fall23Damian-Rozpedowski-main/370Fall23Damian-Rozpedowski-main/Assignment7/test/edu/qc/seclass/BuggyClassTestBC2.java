package edu.qc.seclass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class BuggyClassTestBC2 {

    @Test
    public void testBuggyMethod2() {
        BuggyClass buggyClass = new BuggyClass();
        int result = buggyClass.buggyMethod2(100, 25);
        assertEquals(1, result);
        int result2 = buggyClass.buggyMethod2(-100, 0);
        assertEquals(1, result2);

    }

}
