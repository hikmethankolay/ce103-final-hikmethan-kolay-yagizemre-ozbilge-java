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
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.source.car_maintenance.CarMaintenanceApp;


/**

@class CarMaintenanceAppTest
@brief This class represents the test class for the CarMaintenanceApp class.
@details The CarMaintenanceAppTest class provides test methods to verify the behavior of the CarMaintenanceApp class. It includes test methods for successful execution, object creation, and error handling scenarios.
@author Hikmetahn KOLAY/Yagiz Emre OZBILGE
*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
  public void testMain01_WrongChoice() {
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
  public void testMain02_NonIntChoice() {
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
  public void testMain03_Register() {
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
  public void testMain04_ChangePassword() {
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
  public void testMain05_Login() {
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
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain06_ServiceShow() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","1","1","5","4"};
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
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Service History Tracking----------\n" +
              "1-)Show Service History Record\n" +
              "2-)Register Service History Record\n" +
              "3-)Edit Service History Record\n" +
              "4-)Delete Service History Record\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "-------------------------------------------------------\n"+
              "File operation failed. There is no record.\n"+
              "-------------------------------------------------------\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain07_ServiceRegister() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","1","2","asd","1239","asd","1236","5","4"};
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
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Service History Tracking----------\n" +
              "1-)Show Service History Record\n" +
              "2-)Register Service History Record\n" +
              "3-)Edit Service History Record\n" +
              "4-)Delete Service History Record\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "What is the model of vehicle?\n"+
              "What is the service KM?\n"+
              "Who is the service provider?\n"+
              "What is the service cost?\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain08_ServiceRegisterFail() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","1","2","asd","asd","asd","1236","5","4"};
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
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Service History Tracking----------\n" +
              "1-)Show Service History Record\n" +
              "2-)Register Service History Record\n" +
              "3-)Edit Service History Record\n" +
              "4-)Delete Service History Record\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "What is the model of vehicle?\n"+
              "What is the service KM?\n"+
              "Please use an integer\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain09_ServiceRegisterFail_2() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","1","2","asd","12313","asd","asdasd","5","4"};
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
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Service History Tracking----------\n" +
              "1-)Show Service History Record\n" +
              "2-)Register Service History Record\n" +
              "3-)Edit Service History Record\n" +
              "4-)Delete Service History Record\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "What is the model of vehicle?\n"+
              "What is the service KM?\n"+
              "Who is the service provider?\n"+
              "What is the service cost?\n"+
              "Please use an integer\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain10_ServiceEdit() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","1","3","1","asd","234","asd","567","5","4"};
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
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Service History Tracking----------\n" +
              "1-)Show Service History Record\n" +
              "2-)Register Service History Record\n" +
              "3-)Edit Service History Record\n" +
              "4-)Delete Service History Record\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "Which line do you want to edit?\n"+
              "What is the model of vehicle?\n"+
              "What is the service KM?\n"+
              "Who is the service provider?\n"+
              "What is the service cost?\n"+
              "Data successfully edited\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain11_ServiceEditFail() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","1","3","asdad","asd","234","asd","567","5","4"};
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
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Service History Tracking----------\n" +
              "1-)Show Service History Record\n" +
              "2-)Register Service History Record\n" +
              "3-)Edit Service History Record\n" +
              "4-)Delete Service History Record\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "Which line do you want to edit?\n"+
              "Please use an integer\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain12_ServiceEditFail_2() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","1","3","1","asd","asd","asd","567","5","4"};
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
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Service History Tracking----------\n" +
              "1-)Show Service History Record\n" +
              "2-)Register Service History Record\n" +
              "3-)Edit Service History Record\n" +
              "4-)Delete Service History Record\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "Which line do you want to edit?\n"+
              "What is the model of vehicle?\n"+
              "What is the service KM?\n"+
              "Please use an integer\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain13_ServiceEditFail_3() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","1","3","1","asd","234","asd","asd","5","4"};
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
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Service History Tracking----------\n" +
              "1-)Show Service History Record\n" +
              "2-)Register Service History Record\n" +
              "3-)Edit Service History Record\n" +
              "4-)Delete Service History Record\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "Which line do you want to edit?\n"+
              "What is the model of vehicle?\n"+
              "What is the service KM?\n"+
              "Who is the service provider?\n"+
              "What is the service cost?\n"+
              "Please use an integer\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain14_ServiceDelete() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","1","4","1","5","4"};
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
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Service History Tracking----------\n" +
              "1-)Show Service History Record\n" +
              "2-)Register Service History Record\n" +
              "3-)Edit Service History Record\n" +
              "4-)Delete Service History Record\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "Which line do you want to delete?\n"+
              "Data successfully deleted\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain15_ServiceDeleteFail() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","1","4","asdd","5","4"};
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
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Service History Tracking----------\n" +
              "1-)Show Service History Record\n" +
              "2-)Register Service History Record\n" +
              "3-)Edit Service History Record\n" +
              "4-)Delete Service History Record\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "Which line do you want to delete?\n"+
              "Please use an integer\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain16_ReminerShow() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","2","1","5","4"};
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
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Maintenance Reminder Records----------\n" +
              "1-)Show Maintenance Reminder Records\n" +
              "2-)Register Maintenance Reminder Records\n" +
              "3-)Edit Maintenance Reminder Records\n" +
              "4-)Delete Maintenance Reminder Records\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "-------------------------------------------------------\n"+
              "File operation failed. There is no record.\n"+
              "-------------------------------------------------------\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain17_ReminerRegister() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","2","2","Audi","15500","Oil","5","4"};
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
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Maintenance Reminder Records----------\n" +
              "1-)Show Maintenance Reminder Records\n" +
              "2-)Register Maintenance Reminder Records\n" +
              "3-)Edit Maintenance Reminder Records\n" +
              "4-)Delete Maintenance Reminder Records\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "What is the model of vehicle?\n"+
              "What is the service KM?\n"+
              "What is the planned service type?\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain18_ReminerRegisterFail() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","2","2","Audi","asd","Oil","5","4"};
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
              "------------You Have Scheduled Maintenance-------------\n"+
              "0-)VEHICLE MODEL | SERVICE KM | PLANNED SERVICE TYPE\n"+
              "1-)Audi   15500   Oil\n"+
              "-------------------------------------------------------\n"+
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Maintenance Reminder Records----------\n" +
              "1-)Show Maintenance Reminder Records\n" +
              "2-)Register Maintenance Reminder Records\n" +
              "3-)Edit Maintenance Reminder Records\n" +
              "4-)Delete Maintenance Reminder Records\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "What is the model of vehicle?\n"+
              "What is the service KM?\n"+
              "Please use an integer\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain19_ReminerEdit() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","2","3","1","Ferrari","17500","Brake","5","4"};
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
              "------------You Have Scheduled Maintenance-------------\n"+
              "0-)VEHICLE MODEL | SERVICE KM | PLANNED SERVICE TYPE\n"+
              "1-)Audi   15500   Oil\n"+
              "-------------------------------------------------------\n"+
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Maintenance Reminder Records----------\n" +
              "1-)Show Maintenance Reminder Records\n" +
              "2-)Register Maintenance Reminder Records\n" +
              "3-)Edit Maintenance Reminder Records\n" +
              "4-)Delete Maintenance Reminder Records\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "Which line do you want to edit?\n"+
              "What is the model of vehicle?\n"+
              "What is the service KM?\n"+
              "What is the planned service type?\n"+
              "Data successfully edited\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain20_ReminerEditFail() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","2","3","asdd","Ferrari","17500","Brake","5","4"};
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
              "------------You Have Scheduled Maintenance-------------\n"+
              "0-)VEHICLE MODEL | SERVICE KM | PLANNED SERVICE TYPE\n"+
              "1-)Ferrari   17500   Brake\n"+
              "-------------------------------------------------------\n"+
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Maintenance Reminder Records----------\n" +
              "1-)Show Maintenance Reminder Records\n" +
              "2-)Register Maintenance Reminder Records\n" +
              "3-)Edit Maintenance Reminder Records\n" +
              "4-)Delete Maintenance Reminder Records\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "Which line do you want to edit?\n"+
              "Please use an integer\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain21_ReminerEditFail_2() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","2","3","1","Ferrari","asd","Brake","5","4"};
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
              "------------You Have Scheduled Maintenance-------------\n"+
              "0-)VEHICLE MODEL | SERVICE KM | PLANNED SERVICE TYPE\n"+
              "1-)Ferrari   17500   Brake\n"+
              "-------------------------------------------------------\n"+
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Maintenance Reminder Records----------\n" +
              "1-)Show Maintenance Reminder Records\n" +
              "2-)Register Maintenance Reminder Records\n" +
              "3-)Edit Maintenance Reminder Records\n" +
              "4-)Delete Maintenance Reminder Records\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "Which line do you want to edit?\n"+
              "What is the model of vehicle?\n"+
              "What is the service KM?\n"+
              "Please use an integer\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain22_ReminderDelete() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","2","4","1","5","4"};
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
              "------------You Have Scheduled Maintenance-------------\n"+
              "0-)VEHICLE MODEL | SERVICE KM | PLANNED SERVICE TYPE\n"+
              "1-)Ferrari   17500   Brake\n"+
              "-------------------------------------------------------\n"+
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Maintenance Reminder Records----------\n" +
              "1-)Show Maintenance Reminder Records\n" +
              "2-)Register Maintenance Reminder Records\n" +
              "3-)Edit Maintenance Reminder Records\n" +
              "4-)Delete Maintenance Reminder Records\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "Which line do you want to delete?\n"+
              "Data successfully deleted\n"+
              "----------Main Menu----------\n" +
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
  @Test
  public void testMain23_ReminderDeleteFail() {
      // Save original System.in
      InputStream originalSystemIn = System.in;

      // Simulate user input
      ByteArrayInputStream inputStream = new ByteArrayInputStream(System.lineSeparator().getBytes());
      System.setIn(inputStream);

      // Call the main method of CarMaintenanceApp
      String[] args = {"1", "username", "newpassword","2","4","asdasd","5","4"};
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
              "------------You Have Scheduled Maintenance-------------\n"+
              "0-)VEHICLE MODEL | SERVICE KM | PLANNED SERVICE TYPE\n"+
              "-------------------------------------------------------\n"+
              "----------Main Menu----------\n" +
              "1-)Service History Tracking\n" +
              "2-)Maintenance Reminders\n" +
              "3-)Expense Logging\n" +
              "4-)Fuel Efficiency Reports\n" +
              "5-)Back to login menu\n" +
              "Make a choice(1-5): \n"+
              "----------Maintenance Reminder Records----------\n" +
              "1-)Show Maintenance Reminder Records\n" +
              "2-)Register Maintenance Reminder Records\n" +
              "3-)Edit Maintenance Reminder Records\n" +
              "4-)Delete Maintenance Reminder Records\n" +
              "5-)Previous Menu\n" +
              "Make a choice(1-5): \n" +
              "Which line do you want to delete?\n"+
              "Please use an integer\n"+
              "----------Main Menu----------\n" +
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
