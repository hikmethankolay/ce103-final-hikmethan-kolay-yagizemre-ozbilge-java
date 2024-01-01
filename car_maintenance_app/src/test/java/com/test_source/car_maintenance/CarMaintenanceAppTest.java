/**

@file CarMaintenanceAppTest.java
@brief This file contains the test cases for the CarMaintenanceApp class.
@details This file includes test methods to validate the functionality of the CarMaintenanceApp class. It uses JUnit for unit testing.
*/
package com.test_source.car_maintenance;

import static org.junit.Assert.*;
import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import com.source.car_maintenance.CarMaintenanceApp;


/**

@class CarMaintenanceAppTest
@brief This class represents the test class for the CarMaintenanceApp class.
@details The CarMaintenanceAppTest class provides test methods to verify the behavior of the CarMaintenanceApp class. It includes test methods for successful execution, object creation, and error handling scenarios.
@author Hikmetahn KOLAY/Yagiz Emre OZBILGE
*/
public class CarMaintenanceAppTest {
	
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
   * @brief A rule for tests to work.
   */
  @Rule
  public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
  /**
   * @brief Test method to validate the failed execution of the main method.
   *
   * @details This method redirects the System.in and System.out streams to simulate user input and capture the output. It calls the main method of CarMaintenanceApp with a valid argument and asserts the expected behavior based on the output.
   */
  @Test
  public void testMainWrongChoice() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"10","4"};
      CarMaintenanceApp.main(args);

      // Restore original System.in
      System.setIn(originalSystemIn);

      // Assert the desired behavior based on the output
      String expectedOutput = "----------Login----------\n" +
              "1-)Login\n" +
              "2-)Register\n" +
              "3-)Change Password\n" +
              "4-)Exit\n" +
              "Make a choice(1-4): \n" +
              "Please enter a correct choice!\n" +
              "----------Login----------\n" +
              "1-)Login\n" +
              "2-)Register\n" +
              "3-)Change Password\n" +
              "4-)Exit\n" +
              "Make a choice(1-4): \n";

      assertEquals(expectedOutput, systemOutRule.getLog());
  }
  @Test
  public void testMainNonIntChoice() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"asd","4"};
      CarMaintenanceApp.main(args);

      // Restore original System.in
      System.setIn(originalSystemIn);

      // Assert the desired behavior based on the output
      String expectedOutput = "----------Login----------\n" +
              "1-)Login\n" +
              "2-)Register\n" +
              "3-)Change Password\n" +
              "4-)Exit\n" +
              "Make a choice(1-4): \n" +
              "Please use an integer\n" +
              "----------Login----------\n" +
              "1-)Login\n" +
              "2-)Register\n" +
              "3-)Change Password\n" +
              "4-)Exit\n" +
              "Make a choice(1-4): \n";

      assertEquals(expectedOutput, systemOutRule.getLog());
  }
  @Test
  public void testMainRegister() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"2","Y","username", "password","recoverykey", "4"};
      CarMaintenanceApp.main(args);

      // Restore original System.in
      System.setIn(originalSystemIn);

      // Assert the desired behavior based on the output
      String expectedOutput = "----------Login----------\n" +
              "1-)Login\n" +
              "2-)Register\n" +
              "3-)Change Password\n" +
              "4-)Exit\n" +
              "Make a choice(1-4): \n" +
              "Do you understand that if you create a new account all the records that have been saved so far will be deleted?[Y/N]: \n" +
              "Please enter a new username:\n" +
              "Please enter a new password:\n" +
              "\nWARNING!!!\nYou will use this to change password if needed, if you lost this you can't access logs without them being completely deleted\nWARNING!!!\n"+
              "Please enter a new recovery key:\n"+
              "You Registered succesfully.\n"+
              "----------Login----------\n" +
              "1-)Login\n" +
              "2-)Register\n" +
              "3-)Change Password\n" +
              "4-)Exit\n" +
              "Make a choice(1-4): \n";

      assertEquals(expectedOutput, systemOutRule.getLog());
  }
  @Test
  public void testMainChangePassword() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"3", "recoverykey", "newpassword", "4"};
      CarMaintenanceApp.main(args);

      // Restore original System.in
      System.setIn(originalSystemIn);

      // Assert the desired behavior based on the output
      String expectedOutput = "----------Login----------\n" +
              "1-)Login\n" +
              "2-)Register\n" +
              "3-)Change Password\n" +
              "4-)Exit\n" +
              "Make a choice(1-4): \n" +
              "Please enter your recovery key:\n" +
              "Please enter a new password:\n" +
              "Password Change is Successful.\n"+
              "----------Login----------\n" +
              "1-)Login\n" +
              "2-)Register\n" +
              "3-)Change Password\n" +
              "4-)Exit\n" +
              "Make a choice(1-4): \n";

      assertEquals(expectedOutput, systemOutRule.getLog());
  }
  @Test
  public void testMainLogin() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword", "5","4"};
      CarMaintenanceApp.main(args);

      // Restore original System.in
      System.setIn(originalSystemIn);

      // Assert the desired behavior based on the output
      String expectedOutput = "----------Login----------\n" +
              "1-)Login\n" +
              "2-)Register\n" +
              "3-)Change Password\n" +
              "4-)Exit\n" +
              "Make a choice(1-4): \n" +
              "Please enter username:\n" +
              "Please enter password:\n" +
              "Login Successful\n"+
              "----------Manin Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Login----------\n" +
              "1-)Login\n" +
              "2-)Register\n" +
              "3-)Change Password\n" +
              "4-)Exit\n" +
              "Make a choice(1-4): \n";

      assertEquals(expectedOutput, systemOutRule.getLog());
  }
}
