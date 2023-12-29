/**

@file CarMaintenanceTest.java
@brief This file contains the test cases for the CarMaintenance class.
@details This file includes test methods to validate the functionality of the CarMaintenance class. It uses JUnit for unit testing.
*/
package com.test_source.car_maintenance;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.source.car_maintenance.CarMaintenance;

/**

@class CarMaintenanceTest
@brief This class represents the test class for the CarMaintenance class.
@details The CarMaintenanceTest class provides test methods to verify the behavior of the CarMaintenance class. It includes test methods for addition, subtraction, multiplication, and division operations.
@author ugur.coruh
*/
public class CarMaintenanceTest {
	String testString;
	int fail = -1;
    int success = 0;
  /**
   * @brief This method is executed once before all test methods.
   * @throws Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  /**
   * @brief This method is executed once after all test methods.
   * @throws Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  /**
   * @brief This method is executed before each test method.
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * @brief This method is executed after each test method.
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   * @brief Tests the file_write function.
   */
  @Test
  public void testAddition() {
      CarMaintenance car = new CarMaintenance();
      testString = "0-)TEXT STRING WRITE\n";
      String writeString = "TEXT STRING WRITE";
      car.FileWrite("test5.bin", writeString);
      assertEquals(testString, car.FileRead("test5.bin"));
  }

}