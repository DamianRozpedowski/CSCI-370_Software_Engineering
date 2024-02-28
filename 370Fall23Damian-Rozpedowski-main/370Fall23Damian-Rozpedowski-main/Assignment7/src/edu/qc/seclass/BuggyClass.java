package edu.qc.seclass;

public class BuggyClass {

    // 1. create a test suite that achieves 100% statement coverage and does not reveal the fault.
    // 2. create a test suite that achieves less than 50% statement coverage and reveals the fault.
    public int buggyMethod1(int a, int b) {
        int result = 0;
        if (a > b) {
            result = a / b;
        } else if (a < b) {
            result = b / a;
            System.out.println("create statement");
        } else {
            result = 1;
        }
        return result;
    }

    // 1. create a test suite that achieves 100% statement coverage and does not reveal the fault
    // 2. every test suite that achieves more than 50% branch coverage reveals the fault.
    public int buggyMethod2(int a, int b) {
        int result = 0;
        int sum = 0;
        int dif = 0;
        if (a > b) {
            sum = a + b;
            result = sum / a;
        } else if (a < b) {
            dif = b - a;
            result = dif / b;
        }
        return result;
    }

    // 1. create a test suite that achieves 100% branch coverage and does not reveal the fault
    // 2. create a test suite that achieves 100% statement coverage, does not achieve 100% branch coverage, and reveals the fault.
    public int buggyMethod3(int a, int b) {
        int result = 0;
        int calculated = 0;
        if (a >= b) {
            calculated = (a + b) / b;
        }
        result = (a + b) / 2;

        return result + calculated;
    }

    public void buggyMethod4() {
        /*
        This method is not possible to create,
        The first requirement is: EVERY test suite that achieves 100% statement coverage reveals the fault.
        The second requirement is: it's possible to create a test suite that achieves 100% branch coverage and does not reveal the fault.
        This is an issue, if we have 100% branch coverage we also have 100% statement coverage (but not always the other way around).
        Since EVERY test suite achieving 100% statement coverage reveals a fault, the test suite achieving 100% branch coverage must also reveal the fault since it also has 100% statement coverage.
        */
    }

    public void buggyMethod5(int i) {
        /*
        1. public void buggyMethod5 (int i) {
        2. int x;
        3. [point where you can add code]
        4. x = i/0;
        5. [point where you can add code]
        6. }

        This method is not possible to create,
        The first requirement is to achieve 100% statement coverage, meaning each statement in the code must be executed at least once.
        The second requirement is that the division by zero fault cannot be revealed by ANY test suite.
        We are also causing the division by zero fail with an uncaught exception.
        Line 4 MUST run for 100% statement coverage and no matter the users input,
        x = i/0 will occur and give us the / by zero error, this will interrupt the test and not allow for 100% statement coverage.
        */
    }

}



