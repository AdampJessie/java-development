package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    public void punchIn_RegularPunchIn_StartTimeEqualsParameter() {

        // Arrange
        Employee testEmployee = new Employee(1, "Adam", "Kitchen", 10.00);
        // Act
        testEmployee.punchIn(10.0);
        // Assert
        double startTime = testEmployee.
        assertEquals(10.0, )


    }
    @Test
    public void punchOut_RegularPunchOut_HoursWorkedEquals() {


    }



}