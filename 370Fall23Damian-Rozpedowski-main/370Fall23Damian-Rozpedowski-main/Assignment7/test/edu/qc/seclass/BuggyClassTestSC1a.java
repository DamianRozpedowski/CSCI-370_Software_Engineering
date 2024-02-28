package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BuggyClassTestSC1a {

    @Test
    public void testBuggyMethod1() {
        BuggyClass buggyClass = new BuggyClass();

        int result1 = buggyClass.buggyMethod1(100, 25);
        assertEquals(4, result1);

        int result2 = buggyClass.buggyMethod1(2, 6);
        assertEquals(3, result2);

        int result3 = buggyClass.buggyMethod1(19, 19);
        assertEquals(1, result3);
    }

}