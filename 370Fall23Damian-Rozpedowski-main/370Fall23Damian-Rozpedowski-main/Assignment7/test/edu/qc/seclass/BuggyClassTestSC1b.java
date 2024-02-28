package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BuggyClassTestSC1b {

    @Test
    public void testBuggyMethod1() {
        BuggyClass buggyClass = new BuggyClass();
        int result4 = buggyClass.buggyMethod1(100, 0);
    }

}