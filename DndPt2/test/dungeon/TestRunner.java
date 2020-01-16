package dungeon;

import java.util.List;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String [] args) {

        System.out.println("**********Chamber Test**********");
		Result result1 = JUnitCore.runClasses(ChamberTest.class);
        System.out.println("\n*****Failed Test Report****\n");
        List<Failure> failedList1 = result1.getFailures();
        failedList1.forEach(f -> {
            System.out.println(f);
        });
        System.out.println("Number of Failed Tests = " + result1.getFailureCount());

        System.out.println("**********Door Test**********");
        Result result2 = JUnitCore.runClasses(DoorTest.class);
        System.out.println("\n*****Failed Test Report****\n");
        List<Failure> failedList2 = result2.getFailures();
        failedList2.forEach(f -> {
            System.out.println(f);
        });
        System.out.println("Number of Failed Tests = " + result2.getFailureCount());

        System.out.println("**********Passage Test**********");
        Result result3 = JUnitCore.runClasses(PassageTest.class);
        System.out.println("\n*****Failed Test Report****\n");
        List<Failure> failedList3 = result3.getFailures();
        failedList3.forEach(f -> {
            System.out.println(f);
        });
        System.out.println("Number of Failed Tests = " + result3.getFailureCount());

        System.out.println("**********Passage Section Test**********");
        Result result4 = JUnitCore.runClasses(PassageSectionTest.class);
        System.out.println("\n*****Failed Test Report****\n");
        List<Failure> failedList4 = result4.getFailures();
        failedList4.forEach(f -> {
            System.out.println(f);
        });
        System.out.println("Number of Failed Tests = " + result4.getFailureCount());

        /*repeat steps the above for each junit test file you have*/
	}
}