package com.dibas.calculator;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Scanner;

public class TestRunner {

    public static void main(String[] args) {
        Result result = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number based on task to execute test case :");
        System.out.println("1. JUnitCore\n2.Create Mock\n3.InOrder \n4.AnswerInterface \n5.Spy \n6.Resetting Mock " +
                "\n7.BDDMockito \n8.Timeout");

        if(scanner.hasNext()){
            switch (scanner.nextInt()){
                case 1:
                    //Mockito - Inject
                    result = JUnitCore.runClasses(MathApplicationTester.class);
                    break;

                case 2:

                    result = JUnitCore.runClasses(CreateMockMathApplicationTester.class);
                    break;

                case 3:
                    //InOrder Execution : Mockito provides Inorder class which takes care of the order of method calls that the mock is going to make in due course of its action.
                    result = JUnitCore.runClasses(InOrderMathApplicationTester.class);
                    break;

                case 4:
                    //Answer Interface : Mockito provides a Answer interface which allows stubbing with generic interface.
                    result = JUnitCore.runClasses(AnswerInterfaceMathApplicationTester.class);
                    break;

                case 5:
                    //Spy : Mockito provides option to create spy on real objects. When spy is called, then actual method of real object is called.
                    result = JUnitCore.runClasses(SpyMathApplicationTester.class);
                    break;

                case 6:
                    //Resetting Mock : Mockito provides the capability to a reset a mock so that it can be reused later.
                    result = JUnitCore.runClasses(ResettingMockMathApplicationTester.class);
                    break;

                case 7:
                    //Behavior Driven Development is a style of writing tests uses given, when and then format as test methods.
                    result = JUnitCore.runClasses(BDDMockitoMathApplicationTester.class);
                    break;

                case 8:
                    //Timeout : Mockito provides a special Timeout option to test if a method is called within stipulated time frame.
                    result = JUnitCore.runClasses(TimeoutMathApplicationTester.class);
                    break;

                default: break;
            }
        }

        for(Failure failure: result.getFailures()){
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

}
