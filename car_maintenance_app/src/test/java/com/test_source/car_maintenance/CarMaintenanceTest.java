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

@Test
public void TestFileRead()
{
	CarMaintenance car = new CarMaintenance();
	testString = "0-)TEXT STRING0\n1-)TEXT STRING1\n2-)TEXT STRING2\n3-)TEXT STRING3\n4-)TEXT STRING4\n";
	assertEquals(testString, car.FileRead("test1.bin"));
    
}

@Test
public void TestFileAppend()
{
    CarMaintenance car = new CarMaintenance();
	testString = "0-)TEXT STRING0\n1-)TEXT STRING1\n2-)TEXT STRING2\n3-)TEXT STRING3\n4-)TEXT STRING4\n5-)TEXT STRING5\n";
    String appendString = "TEXT STRING5";
    car.FileAppend("test2.bin", appendString);
    assertEquals(testString, car.FileRead("test2.bin"));
}

@Test
public void TestFileEdit()
{
    CarMaintenance car = new CarMaintenance();
	testString = "0-)TEXT STRING0\n1-)TEXT STRING1\n2-)TEXT STRING2\n3-)TEXT STRING EDIT\n4-)TEXT STRING4\n";
    String editString = "TEXT STRING EDIT";
    car.FileEdit("test3.bin", 3, editString);
    assertEquals(testString, car.FileRead("test3.bin"));
}

@Test
public void TestFileDelete()
{
    CarMaintenance car = new CarMaintenance();
	testString = "0-)TEXT STRING0\n1-)TEXT STRING2\n2-)TEXT STRING3\n3-)TEXT STRING4\n";
    car.FileLineDelete("test4.bin", 1);
    assertEquals(testString, car.FileRead("test4.bin"));
}

@Test
public void TestFileWrite()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)TEXT STRING WRITE\n";
    String writeString = "TEXT STRING WRITE";
    car.FileWrite("test5.bin", writeString);
    assertEquals(testString, car.FileRead("test5.bin"));
}

@Test
public void TestFileReadFail()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals("-1", car.FileRead("test1f.bin"));
}

@Test
public void TestFileAppendFail()
{
    CarMaintenance car = new CarMaintenance();
    String appendString = "TEXT STRING5";
    assertEquals(fail, car.FileAppend("test2f.bin", appendString));
}

@Test
public void TestFileEditFail()
{
    CarMaintenance car = new CarMaintenance();
    String editString = "TEXT STRING EDIT";
    assertEquals(fail, car.FileEdit("test3f.bin", 3, editString));
}

@Test
public void TestFileEditFail_2()
{
    CarMaintenance car = new CarMaintenance();
    String editString = "TEXT STRING EDIT";
    assertEquals(fail, car.FileEdit("test3.bin", 100, editString));
}

@Test
public void TestFileDeleteFail()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.FileLineDelete("test4f.bin", 2));
}

@Test
public void TestFileDeleteFail_2()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.FileLineDelete("test4.bin", 100));
}

@Test
public void TestUserRegister()
{
    CarMaintenance car = new CarMaintenance();
    testString = "username/password/recoverykey";
    car.UserRegister("username", "password", "recoverykey", "usertest.bin");
    assertEquals(testString, car.FileRead("usertest.bin"));
}

@Test
public void TestUserLogin()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(success, car.UserLogin("username", "password", "usertest_2.bin"));
}

@Test
public void TestUserLoginFail()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.UserLogin("usernameaa", "passwordaa", "usertest_2.bin"));
}

@Test
public void TestUserLoginFail_2()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.UserLogin("username", "password", "usertestfail.bin"));
}

@Test
public void TestUserChangePassword()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(success, car.UserChangePassword("recoverykey", "newpassword", "usertest_3.bin"));
}

@Test
public void TestUserChangePasswordFail()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.UserChangePassword("recoverykey", "newpassword", "usertestfail.bin"));
}

@Test
public void TestUserChangePasswordFail_2()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.UserChangePassword("recoverykeyaaa", "newpassword", "usertest_3.bin"));
}

@Test
public void TestRegisterService()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)VEHICLE MODEL | SERVICE KM | SERVICE PROVIDER | SERVICE COST\n1-)Audi   10500   Service   1500\n";
    car.RegisterServiceHistoryRecord("Audi", 10500, "Service", 1500, "service_history_test.bin");
    assertEquals(testString, car.FileRead("service_history_test.bin"));
}

@Test
public void TestRegisterService_2()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)VEHICLE MODEL | SERVICE KM | SERVICE PROVIDER | SERVICE COST\n1-)Audi   10500   Service   1500\n2-)Ferrari   12500   Service   1900\n";
    car.RegisterServiceHistoryRecord("Ferrari", 12500, "Service", 1900, "service_history_test_2.bin");
    assertEquals(testString, car.FileRead("service_history_test_2.bin"));
}

@Test
public void TestEditService()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)VEHICLE MODEL | SERVICE KM | SERVICE PROVIDER | SERVICE COST\n1-)Mercedes   12500   Service   1700\n";
    car.EditServiceHistoryRecord(1, "Mercedes", 12500, "Service", 1700, "service_history_test_3.bin");
    assertEquals(testString, car.FileRead("service_history_test_3.bin"));
}

@Test
public void TestEditServiceFail()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.EditServiceHistoryRecord(1, "Mercedes", 12500, "Service", 1700, "service_history_testfail.bin"));
}

@Test
public void TestEditServiceFail_2()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.EditServiceHistoryRecord(7, "Mercedes", 12500, "Service", 1700, "service_history_test.bin"));
}

@Test
public void TestDeleteService()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)VEHICLE MODEL | SERVICE KM | SERVICE PROVIDER | SERVICE COST\n";
    car.DeleteServiceHistoryRecord(1, "service_history_test_4.bin");
    assertEquals(testString, car.FileRead("service_history_test_4.bin"));
}

@Test
public void TestDeleteServiceFail()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.DeleteServiceHistoryRecord(1, "service_history_testfail.bin"));
}

@Test
public void TestDeleteServiceFail_2()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.DeleteServiceHistoryRecord(9,"service_history_test.bin"));
}

@Test
public void TestRegisterReminder()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)VEHICLE MODEL | SERVICE KM | PLANNED SERVICE TYPE\n1-)Audi   1000   Brake\n";
    car.RegisterMaintenanceReminderRecord("Audi",1000,"Brake", "reminder_logging_records_test.bin");
    assertEquals(testString, car.FileRead("reminder_logging_records_test.bin"));

}
@Test
public void TestRegisterReminder_2()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)VEHICLE MODEL | SERVICE KM | PLANNED SERVICE TYPE\n1-)Audi   1000   Brake\n2-)Ferrari   2000   Brake\n";
    car.RegisterMaintenanceReminderRecord("Ferrari",2000,"Brake", "reminder_logging_records_test_2.bin");
    assertEquals(testString, car.FileRead("reminder_logging_records_test_2.bin"));
}

@Test
public void TestEditReminder()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)VEHICLE MODEL | SERVICE KM | PLANNED SERVICE TYPE\n1-)Mercedes   1100   Oil\n";
    car.EditMaintenanceReminderRecord(1,"Mercedes", 1100, "Oil", "reminder_logging_records_test_3.bin");
    assertEquals(testString, car.FileRead("reminder_logging_records_test_3.bin"));
    
}
@Test
public void TestEditReminderFail()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.EditMaintenanceReminderRecord(1,"Mercedes", 1100, "Oil", "reminder_logging_records_testaaa.bin"));

}
@Test
public void TestEditReminderFail_2()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.EditMaintenanceReminderRecord(6,"Mercedes", 1100, "Oil", "reminder_logging_records_test.bin"));

}
@Test
public void TestDeleteReminder()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)VEHICLE MODEL | SERVICE KM | PLANNED SERVICE TYPE\n";
    car.DeleteMaintenanceReminderRecord(1, "reminder_logging_records_test_4.bin");
    assertEquals(testString, car.FileRead("reminder_logging_records_test_4.bin"));

}
@Test
public void TestDeleteReminderFail()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.DeleteMaintenanceReminderRecord(1, "reminder_logging_records_testaaaa.bin"));

}
@Test
public void TestDeleteReminderFail_2()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.DeleteMaintenanceReminderRecord(6, "reminder_logging_records_test.bin"));

}

@Test
public void TestRegisterExpense()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)CAR MODEL | EXPENSE DATE | EXPENSE TYPE | EXPENSE\n1-)Audi   10/10/2023   Brake   15000\n";
    car.RegisterExpenseRecord("Audi", "10/10/2023", "Brake", 15000, "expense_logging_records_test.bin");
    assertEquals(testString, car.FileRead("expense_logging_records_test.bin"));
}

@Test
public void TestRegisterExpense_2()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)CAR MODEL | EXPENSE DATE | EXPENSE TYPE | EXPENSE\n1-)Audi   10/10/2023   Brake   15000\n2-)Ferrari   11/11/2023   Oil   19000\n";
    car.RegisterExpenseRecord("Ferrari", "11/11/2023", "Oil", 19000, "expense_logging_records_test_2.bin");
    assertEquals(testString, car.FileRead("expense_logging_records_test_2.bin"));
}

@Test
public void TestEditExpense()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)CAR MODEL | EXPENSE DATE | EXPENSE TYPE | EXPENSE\n1-)Mercedes   11/11/2023   Oil   17000\n";
    car.EditExpenseRecord(1, "Mercedes", "11/11/2023", "Oil", 17000, "expense_logging_records_test_3.bin");
    assertEquals(testString, car.FileRead("expense_logging_records_test_3.bin"));
}

@Test
public void TestEditExpenseFail()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.EditExpenseRecord(1, "Audi", "10/10/2023", "Brake", 15000, "expense_logging_records_testaaa.bin"));
}

@Test
public void TestEditExpenseFail_2()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.EditExpenseRecord(8, "Audi", "10/10/2023", "Brake", 15000, "expense_logging_records_test.bin"));
}

@Test
public void TestDeleteExpense()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)CAR MODEL | EXPENSE DATE | EXPENSE TYPE | EXPENSE\n";
    car.DeleteExpenseRecord(1, "expense_logging_records_test_4.bin");
    assertEquals(testString, car.FileRead("expense_logging_records_test_4.bin"));
}

@Test
public void TestDeleteExpenseFail()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.DeleteExpenseRecord(1,"expense_logging_records_testaaa.bin"));
}

@Test
public void TestDeleteExpenseFail_2()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.DeleteExpenseRecord(7, "expense_logging_records_test.bin"));
}
/**
@Test
public void TestRegisterFuel()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)CAR MODEL | FUEL CONSUMED(L/100KM)\n1-)BWM   5\n";
    car.RegisterFuelEfficiencyRecord("BWM", 50, 1000, "fuel_efficiency_records_test.bin");
    assertEquals(testString, car.FileRead("fuel_efficiency_records_test.bin"));

}
@Test
public void TestRegisterFuel_2()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)CAR MODEL | FUEL CONSUMED(L/100KM)\n1-)BWM   5\n2-)Ferrari   8\n";
    car.RegisterFuelEfficiencyRecord("Ferrari", 80, 1000, "fuel_efficiency_records_test_2.bin");
    assertEquals(testString, car.FileRead("fuel_efficiency_records_test_2.bin"));
}
@Test
public void TestEditFuel()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)CAR MODEL | FUEL CONSUMED(L/100KM)\n1-)Audi   6\n";
    car.EditFuelEfficiencyRecord(1, "Audi", 60, 1000, "fuel_efficiency_records_test_3.bin");
    assertEquals(testString, car.FileRead("fuel_efficiency_records_test_3.bin"));

}
@Test
public void TestEditFuelFail()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.EditFuelEfficiencyRecord(1,"Mercedes",2.0f,2.0f, "fuel_efficiency_records_testaaa.bin"));

}
@Test
public void TestEditFuelFail_2()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.EditFuelEfficiencyRecord(6,"Mercedes",2.0f,2.0f, "fuel_efficiency_records_test.bin"));

}
@Test
public void TestDeleteFuel()
{
    CarMaintenance car = new CarMaintenance();
    testString = "0-)CAR MODEL | FUEL CONSUMED(L/100KM)\n";
    car.DeleteFuelEfficiencyRecord(1, "fuel_efficiency_records_test_4.bin");
    assertEquals(testString, car.FileRead("fuel_efficiency_records_test_4.bin"));

}
@Test
public void TestDeleteFuelFail()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.DeleteFuelEfficiencyRecord(1, "fuel_efficiency_records_testaaa.bin"));

}
@Test
public void TestDeleteFuelFail_2()
{
    CarMaintenance car = new CarMaintenance();
    assertEquals(fail, car.DeleteFuelEfficiencyRecord(5, "fuel_efficiency_records_test.bin"));

}

*/
}