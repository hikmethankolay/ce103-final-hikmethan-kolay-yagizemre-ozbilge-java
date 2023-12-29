/**

@file CarMaintenance.java
@brief This file serves as a demonstration file for the CarMaintenance class.
@details This file contains the implementation of the CarMaintenance class, which provides various mathematical operations.
*/

/**

@package com.source.car_maintenance
@brief The com.source.car_maintenance package contains all the classes and files related to the CarMaintenance App.
*/
package com.source.car_maintenance;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import ch.qos.logback.classic.Logger;
/**

@class CarMaintenance
@brief Implementation file for car maintenance library functions.
@author Hikmethan KOLAY/Yagiz Emre OZBILGE
*/
public class CarMaintenance {

  /**
   * @brief Logger for the CarMaintenance class.
   */
  private static final Logger logger = (Logger) LoggerFactory.getLogger(CarMaintenance.class);

  /**
   * Opens a binary file, deletes all of its content, and writes given text to it.
   *
   * @param FileName The name of the file to write.
   * @param text The text to write.
   * @return 0 on success.
   */
  public int FileWrite(String FileName, String text) {
      text = "0-)" + text + "\n";

      try (OutputStream myFile = new FileOutputStream(FileName)) {
          byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
          myFile.write(bytes, 0, bytes.length);
      } catch (IOException e) {
          // Handle the exception according to your needs
          e.printStackTrace();
      }
      logger.info("FileWrite Function worked succesfully");
      return 0;
  }
  /**
  * @brief Opens a binary file, Reads all of its content, seperate line with "\n" and write them to console, also returns a string for unit tests.
  *
  *
  * @param FileName The name of the file to read from.
  * @return The contents of the file as a string.
  */
  public String FileRead(String FileName) {
      String line = "";
      try (InputStream myFile = new FileInputStream(FileName)) {
          try (InputStreamReader streamReader = new InputStreamReader(myFile, StandardCharsets.UTF_8)) {
              int character;
              while ((character = streamReader.read()) != -1) {
                  if (character == '\r') {
                      continue;
                  }
                  line += (char) character;
              }
          }
          System.out.println(line);
      } catch (IOException ex) {
          System.out.println("File operation failed. There is no record.");
          System.out.println(ex.getMessage());
          return "-1";
      }
      return line;
  }
  /**
  * @brief Appends given text to a binary file with a automatic calculated line number. Calcultes new lines line number by finding last lines line number.
  *
  *
  * @param FileName The name of the file to append to.
  * @param text The text to append to the file.
  * @return 0 on success.
  */
  public int FileAppend(String FileName, String text) {
	  logger.info("FileAppend Function worked succesfully");
	  return 0;
  }
  /**
  * @brief This function Opens a binary file, finds the line that user wants to edit and replace it wih new text.
  *
  *
  * @param fileName The name of the file to edit.
  * @param lineNumberToEdit The line number to edit.
  * @param newLine The new text to replace the existing line.
  * @return 0 on success.
  */
  public int FileEdit(String fileName, int lineNumberToEdit, String newLine) {
	  logger.info("FileEdit Function worked succesfully");
	  return 0;
  }
  /**
  * @brief This function Opens a binary file, deletes the line user wanted and make adjustments on line number acordingly.
  *
  *
  * @param fileName The name of the file to delete the line from.
  * @param LineNumberToDelete The line number to delete.
  * @return 0 on success.
  */
  public int FileLineDelete(String fileName, int LineNumberToDelete) {
	  logger.info("FileLineDelete Function worked succesfully");
	  return 0;
  }
  
  
  /**
  * @brief This function is for user register
  *
  * Function creates a user.bin file and writes inputted username and password in it.
  *
  * @return 0 on success.
  * @return -1 on faill.
  */
  public int UserRegister(String newUsername, String newPassword, String newRecoveryKey, String userFile) {
	  logger.info("UserRegister Function worked succesfully");
	  return 0;
  }
  /**
   * @brief This function is for user login
   *
   * Function read user.bin file and checks if username and password matchs with inputted username and password
   *
   * @return 0 on success.
   * @return -1 on fail.
   */
  public int UserLogin(String username, String password, String userFile) {
	  logger.info("UserLogin Function worked succesfully");
	  return 0;
  }
  /**
   * @brief This function changes password of user.
   *
   *
   * @return 0 on success.
   * @return -1 on fail.
   */
  public int UserChangePassword(String recoveryKey, String newPassword, String userFile) {
	  logger.info("UserChangePassword Function worked succesfully");
	  return 0;
  }
  
  /**
  * @brief This function register records to service_history_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int RegisterServiceHistoryRecord(String vehicleModel,int serviceKm,String serviceProvider,int serviceCost,String fileName) {
	  return 0;
  }
  /**
   * @brief This function edit the records in service_history_records.bin.
   *
   *
   * @return 0 on success.
   * @return -1 on fail.
   */
  public int EditServiceHistoryRecord(int lineNumberToEdit,String vehicleModel,int serviceKm,String serviceProvider,int serviceCost,String fileName) {
	  return 0;
  }
  /**
  * @brief This function register records to expense_logging_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int DeleteServiceHistoryRecord(int lineNumberToDelete,String fileName) {
	  return 0;
  }
  
  
  /**
  * @brief This function register records to maintenance_reminder_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int RegisterMaintenanceReminderRecord(String vehicleModel, int serviceKm, String ServiceType, String fileName) {
	  return 0;
  }
  /**
   * @brief This function edit the records in maintenance_reminder_records.bin.
   *
   *
   * @return 0 on success.
   * @return -1 on fail.
   */
  public int EditMaintenanceReminderRecord(int lineNumbertoEdit, String vehicleModel, int serviceKm, String ServiceType, String fileName) {
	  return 0;
  }
  /**
   * @brief This function delete the records in maintenance_reminder_records.bin.
   *
   *
   * @return 0 on success.
   * @return -1 on fail.
   */
  public int DeleteMaintenanceReminderRecord(int lineNumbertoDelete, String fileName) {
	  return 0;
  }
  
  
  /**
  * @brief This function register records to expense_logging_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int RegisterExpenseRecord(String carModel, String expenseDate, String expenseType, int expense,String fileName) {
	  return 0;
  }
  /**
  * @brief This function edit records to expense_logging_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
   */
  public int EditExpenseRecord(int lineNumbertoEdit,String carModel, String expenseDate, String expenseType, int expense, String fileName) {
	  return 0;
  }
  /**
  * @brief This function delete records to expense_logging_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int DeleteExpenseRecord(int lineNumbertoDelete,String fileName) {
	  return 0;
  }
  
  
  /**
  * @brief This function register records to fuel_efficiency_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int RegisterFuelEfficiencyRecord(String carModel , float fuelConsumed, float roadTraveled, String fileName) {
	  return 0;
  }
  /**
  * @brief This function edit the records in fuel_efficiency_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int EditFuelEfficiencyRecord(int lineNumberToEdit, String carModel, float fuelConsumed, float roadTraveled, String fileName) {
	  return 0;
  }
  /**
  * @brief This function delete the records in fuel_efficiency_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int DeleteFuelEfficiencyRecord(int lineNumberToDelete,String fileName) {
	  return 0;
  }
}
