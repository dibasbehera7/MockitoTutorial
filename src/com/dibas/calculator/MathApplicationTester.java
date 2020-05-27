package com.dibas.calculator;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calculatorService;

    @Test
    public void testAdd(){

        //Mockito provides the capability to a mock to throw exceptions, so exception handling can be tested.
        //add the behavior to throw exception
        doThrow(new RuntimeException("Add operation not implemented"))
                .when(calculatorService).add(10.0,20.0);

        //add the behavior of calc service to add two numbers
        when(calculatorService.add(10.0,20.0)).thenReturn(30.0);

        //add the behavior of calc service to subtract two numbers
        when(calculatorService.subtract(20.0,10.0)).thenReturn(10.00);


        //test the add functionality
        Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
        Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
        Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);

        //test the subtract functionality
        Assert.assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0.0);

        /*
         verify() : verify call to calcService is made or not with same arguments.
         -> Mockito can ensure whether a mock method is being called with required arguments or not.
         */
        //verify the behavior
        //verify(calculatorService).add(10.0, 20.0);
       // verify(calculatorService).add(20.0, 30.0); // verify with different arguments


        //limit the method call to 1, no less and no more calls are allowed
        //verify(calculatorService, times(1)).add(10.0, 20.0);

        //default call count is 1
        //verify(calculatorService).subtract(20.0, 10.0);

        //check if add function is called three times
        //verify(calculatorService, times(3)).add(10.0, 20.0);

        //verify that method was never called on a mock
        //verify(calculatorService, never()).multiply(10.0,20.0);

        //check a minimum 1 call count
        verify(calculatorService, atLeastOnce()).subtract(20.0, 10.0);

        //check if add function is called minimum 2 times
        verify(calculatorService, atLeast(2)).add(10.0, 20.0);

        //check if add function is called maximum 3 times
        verify(calculatorService, atMost(3)).add(10.0,20.0);

    }


}
