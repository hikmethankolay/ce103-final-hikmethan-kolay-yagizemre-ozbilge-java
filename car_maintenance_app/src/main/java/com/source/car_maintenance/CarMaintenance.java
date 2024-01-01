/**
 * @file CarMaintenance.java
 * @brief This file serves as a demonstration file for the CarMaintenance class.
 * @details This file contains the implementation of the CarMaintenance class, which provides various file operations.
 * 
*/

/**
 * @package com.source.car_maintenance
 * @brief The com.source.car_maintenance package contains all the classes and files related to the CarMaintenance App.
*/
package com.source.car_maintenance;
import java.io.*;
import java.nio.charset.StandardCharsets;
/**
 * @class CarMaintenance
 * @brief Implementation file for car maintenance library functions.
 * @author Hikmethan KOLAY
 * @author Yagiz Emre OZBILGE
*/
public class CarMaintenance {

  /**
   * Delete files.
   *
   * @param FileName The name of the file to delete.
   * @return 0 on success.
   * @return -1 on fail.
   */
  private static int FileDelete(String FileName) {
      File file = new File(FileName);

      if (file.exists()) {
          if (file.delete()) {
        	  return 0;
          } else {
        	  return -1;
          }
      } else {
    	  return 0;
      }
  }
  
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
          e.printStackTrace();
      }

      return 0;
  }
  /**
  * @brief Opens a binary file, Reads all of its content, separate line with "\n" and write them to console, also returns a string for unit tests.
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
      try {
          String lastLine = "";
          String currentLine = "";
          char character;

          try (InputStream myFile = new FileInputStream(FileName)) {
              try (InputStreamReader streamReader = new InputStreamReader(myFile, "UTF-8")) {
                  int data;
                  while ((data = streamReader.read()) != -1) {
                      character = (char) data;
                      if (character == '\n') {
                          currentLine += character;
                          lastLine = currentLine;
                          currentLine = "";
                          continue;
                      }
                      currentLine += character;
                  }
              }
          }

          int pos = lastLine.indexOf("-)"); // Finds the location of "-)" in the last line
          int lineNumber = Integer.parseInt(lastLine.substring(0, pos).trim()) + 1; // Finds the number for the appended line
          text = lineNumber + "-)" + text + "\n";

          try (OutputStream myFile = new FileOutputStream(FileName, true)) {
              try (OutputStreamWriter streamWriter = new OutputStreamWriter(myFile, "UTF-8")) {
                  streamWriter.write(text);
              }
          }
          return 0;
      } catch (IOException ex) {
          System.out.println("File operation failed.");
          System.out.println(ex.getMessage());
          return -1;
      }
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
      String[] lines = new String[100]; // An array to store lines
      String line = "";
      char character;
      int lineCount = 0; // A variable for an if statement to check if the line that the user wants to edit exists
      try {
          try (InputStream myFile = new FileInputStream(fileName)) {
              try (InputStreamReader streamReader = new InputStreamReader(myFile, "UTF-8")) {
                  int data;
                  while ((data = streamReader.read()) != -1) {
                      character = (char) data;
                      if (character == '\n') {
                          line += character;
                          lines[lineCount++] = line;
                          line = "";
                          continue;
                      }
                      line = line + character;
                  }
              }
          }

          if (lineNumberToEdit > 0 && lineNumberToEdit <= lineCount) {
              lines[lineNumberToEdit] = lineNumberToEdit + "-)" + newLine + "\n"; // Changes a member of the Lines array to a new line with its line number
          } else {
              System.out.println("You can only edit existing lines.");
              return -1;
          }

          try (OutputStream myFile = new FileOutputStream(fileName, false)) {
              try (OutputStreamWriter streamWriter = new OutputStreamWriter(myFile, "UTF-8")) {
                  for (int i = 0; i < lines.length; i++) {
                      String updatedLine = lines[i];
                      if (updatedLine == null || updatedLine.isEmpty()) {
                          break;
                      }

                      streamWriter.write(updatedLine);
                  }
              }
          }

          System.out.println("\nData successfully edited\n\n");
          return 0;
      } catch (IOException ex) {
          System.out.println("File operation failed.");
          System.out.println(ex.getMessage());
          return -1;
      }
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
      String[] lines = new String[100]; // An array to store lines
      String line = "";
      char character;
      int lineCount = 0; // A variable for an if statement to check if the line that the user wants to edit exists
      try {
          try (InputStream myFile = new FileInputStream(fileName)) {
              try (InputStreamReader streamReader = new InputStreamReader(myFile, "UTF-8")) {
                  int data;
                  while ((data = streamReader.read()) != -1) {
                      character = (char) data;
                      if (character == '\n') {
                          line += character;
                          lines[lineCount++] = line;
                          line = "";
                          continue;
                      }
                      line = line + character;
                  }
              }
          }

          if (LineNumberToDelete > 0 && LineNumberToDelete < lineCount) {
              for (int i = LineNumberToDelete; i < lineCount - 1; ++i) {
                  lines[i] = lines[i + 1];
              }

              lines[lineCount - 1] = "";
          } else {
              System.out.println("You can only erase existing lines");
              return -1;
          }

          try (OutputStream myFile = new FileOutputStream(fileName, false)) {
              try (OutputStreamWriter streamWriter = new OutputStreamWriter(myFile, "UTF-8")) {
                  for (String updatedLine : lines) {
                      if (updatedLine == null || updatedLine.isEmpty()) {
                          break;
                      }

                      int pos = updatedLine.indexOf("-)");
                      int lineNumber = Integer.parseInt(updatedLine.substring(0, pos));

                      if (lineNumber > LineNumberToDelete) {
                          String updatedLineWithNewNumber = (lineNumber - 1) + updatedLine.substring(pos);
                          streamWriter.write(updatedLineWithNewNumber);
                      } else {
                          streamWriter.write(updatedLine);
                      }
                  }
              }
          }

          System.out.println("\nData successfully deleted\n\n");
          return 0;
      } catch (IOException ex) {
          System.out.println("File operation failed");
          System.out.println(ex.getMessage());
          return -1;
      }
  }
  
  
  /**
  * @brief This function is for user register
  *
  * Function creates a user.bin file and writes inputed username and password in it.
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int UserRegister(String newUsername, String newPassword, String newRecoveryKey, String userFile) {
	  String loginInfo;
      loginInfo = newUsername + "/" + newPassword + "/" + newRecoveryKey;

      try (OutputStream myFile = new FileOutputStream(userFile)) {
          byte[] bytes = loginInfo.getBytes(StandardCharsets.UTF_8);
          myFile.write(bytes, 0, bytes.length);
      } catch (IOException e) {
          e.printStackTrace();
      }
      
      FileDelete("service_history_records.bin");
      FileDelete("maintenance_reminder_records.bin");
      FileDelete("expense_records.bin");
      FileDelete("fuel_efficiency_records.bin");

      System.out.print("You Registered succesfully.\n");
	  return 0;
  }
  /**
   * @brief This function is for user login
   *
   * Function read user.bin file and checks if username and password matches with inputed username and password
   *
   * @return 0 on success.
   * @return -1 on fail.
   */
  public int UserLogin(String username, String password, String userFile) {
      String usernameRead = "";
      String passwordRead = "";
      int count = 0;

      if (!new File(userFile).exists()) {
          System.out.print("There is no user info. Please register first.\n");
          return -1;
      }

      try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
          int data;
          while ((data = reader.read()) != -1) {
              char character = (char) data;

              if (character == '/') {
                  count++;
                  continue;
              }

              if (count == 0) {
                  usernameRead += character;
              } else if (count == 1) {
                  passwordRead += character;
              } else if (count == 2) {
                  break;
              }
          }
      } catch (IOException e) {
          e.printStackTrace();
      }

      if (username.equals(usernameRead) && password.equals(passwordRead)) {
          System.out.print("Login Successful\n");
          return 0;
      } else {
          System.out.print("Wrong username or password\n");
          return -1;
      }
	  
  }
  /**
   * @brief This function changes password of user.
   *
   *
   * @return 0 on success.
   * @return -1 on fail.
   */
  public int UserChangePassword(String recoveryKey, String newPassword, String userFile) {

	  String usernameRead = "";
      String recoveryKeyRead = "";
      String newLoginInfo;
      int count = 0;

      if (!new File(userFile).exists()) {
          System.out.print("There is no user info. Please register first.\n");
          return -1;
      }

      try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
          int data;
          while ((data = reader.read()) != -1) {
              char character = (char) data;

              if (character == '/') {
                  count++;
                  continue;
              }

              if (count == 0) {
                  usernameRead += character;
              } else if (count == 1) {
            	  continue;
              } else if (count == 2) {
            	  recoveryKeyRead += character;
              }
          }
      } catch (IOException e) {
          e.printStackTrace();
      }

      if (recoveryKey.equals(recoveryKeyRead)) {
    	  
    	  newLoginInfo = usernameRead + "/" + newPassword + "/" + recoveryKeyRead;
    	  
          try (OutputStream myFile = new FileOutputStream(userFile)) {
              byte[] bytes = newLoginInfo.getBytes(StandardCharsets.UTF_8);
              myFile.write(bytes, 0, bytes.length);
          } catch (IOException e) {
              e.printStackTrace();
          }
    	  
          System.out.print("Password Change Successful\n");
          return 0;
          
      } else {
          System.out.print("Wrong Recovery Key\n");
          return -1;
      }
      
  }
  
  /**
  * @brief This function register records to service_history_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int RegisterServiceHistoryRecord(String vehicleModel,int serviceKm,String serviceProvider,int serviceCost,String fileName) {
	  String record = String.format("%s   %d   %s   %d", vehicleModel, serviceKm, serviceProvider, serviceCost);
      
	  if (new File(fileName).exists()) {
          FileAppend(fileName, record);
          return 0;
      }
      else {
          FileWrite(fileName, "VEHICLE MODEL | SERVICE KM | SERVICE PROVIDER | SERVICE COST");
          FileAppend(fileName, record);
          return 0;
      }
  }
  /**
   * @brief This function edit the records in service_history_records.bin.
   *
   *
   * @return 0 on success.
   * @return -1 on fail.
   */
  public int EditServiceHistoryRecord(int lineNumberToEdit,String vehicleModel,int serviceKm,String serviceProvider,int serviceCost,String fileName) {
	  String record = String.format("%s   %d   %s   %d", vehicleModel, serviceKm, serviceProvider, serviceCost);
      if (FileEdit(fileName, lineNumberToEdit, record) == 0)
      {
          return 0;
      }
      else
      {
          return -1;
      }
  }
  /**
  * @brief This function register records to expense_logging_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int DeleteServiceHistoryRecord(int lineNumberToDelete,String fileName) {
      if (FileLineDelete(fileName, lineNumberToDelete) == 0)
      {
          return 0;
      }
      else
      {
          return -1;
      }
  }
  
  
  /**
  * @brief This function register records to maintenance_reminder_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int RegisterMaintenanceReminderRecord(String vehicleModel, int serviceKm, String ServiceType, String fileName) {
	  String record = String.format("%s   %d   %s", vehicleModel, serviceKm, ServiceType);
      
	  if (new File(fileName).exists()) {
          FileAppend(fileName, record);
          return 0;
      }
      else {
          FileWrite(fileName, "VEHICLE MODEL | SERVICE KM | PLANNED SERVICE TYPE");
          FileAppend(fileName, record);
          return 0;
      }
  }
  /**
   * @brief This function edit the records in maintenance_reminder_records.bin.
   *
   *
   * @return 0 on success.
   * @return -1 on fail.
   */
  public int EditMaintenanceReminderRecord(int lineNumberToEdit, String vehicleModel, int serviceKm, String ServiceType, String fileName) {
	  String record = String.format("%s   %d   %s", vehicleModel, serviceKm, ServiceType);
      if (FileEdit(fileName, lineNumberToEdit, record) == 0)
      {
          return 0;
      }
      else
      {
          return -1;
      }
  }
  /**
   * @brief This function delete the records in maintenance_reminder_records.bin.
   *
   *
   * @return 0 on success.
   * @return -1 on fail.
   */
  public int DeleteMaintenanceReminderRecord(int lineNumberToDelete, String fileName) {
      if (FileLineDelete(fileName, lineNumberToDelete) == 0)
      {
          return 0;
      }
      else
      {
          return -1;
      }
  }
  
  
  /**
  * @brief This function register records to expense_logging_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int RegisterExpenseRecord(String carModel, String expenseDate, String expenseType, int expense,String fileName) {
	  String record = carModel + "   " + expenseDate + "   " + expenseType + "   " + expense;
	  
	  if (new File(fileName).exists()) {
		  FileAppend(fileName, record);
          return 0;
      
	  } else {
		  FileWrite(fileName, "CAR MODEL | EXPENSE DATE | EXPENSE TYPE | EXPENSE");
		  FileAppend(fileName, record);
		  return 0;
	  }
   }
  /**
  * @brief This function edit records to expense_logging_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
   */
  public int EditExpenseRecord(int lineNumbertoEdit,String carModel, String expenseDate, String expenseType, int expense, String fileName) {
	 String record = carModel + "   " + expenseDate + "   " + expenseType + "   " + expense;
	  
	if(FileEdit(fileName, lineNumbertoEdit, record) == 0) {
		return 0;
    } else {
    	return -1;
    }
  }
  /**
  * @brief This function delete records to expense_logging_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int DeleteExpenseRecord(int lineNumbertoDelete,String fileName) {
	  if(FileLineDelete(fileName, lineNumbertoDelete) == 0) {
		  return 0;
	  } else {
		  return -1;
	  }
}
  
  
  /**
  * @brief This function register records to fuel_efficiency_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int RegisterFuelEfficiencyRecord(String carModel , float fuelConsumed, float roadTraveled, String fileName) {
	  float efficiency = (fuelConsumed/roadTraveled) * 100;
	  String record = carModel + "   " + efficiency;
	  
	  if(new File(fileName).exists()) {
		  FileAppend(fileName, record);
		  return 0;
		  
	  } else {
		  FileWrite(fileName, "CAR MODEL | FUEL CONSUMED(L/100KM)");
		  FileAppend(fileName, record);
		  return 0;
	  }
  }
  /**
  * @brief This function edit the records in fuel_efficiency_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int EditFuelEfficiencyRecord(int lineNumberToEdit, String carModel, float fuelConsumed, float roadTraveled, String fileName) {
	  float efficiency = (fuelConsumed/roadTraveled) * 100;
	  String record = carModel + "   " + efficiency;
	  
	  if(FileEdit(fileName, lineNumberToEdit, record) == 0) {
		  return 0;
	  } else {
		  return -1;
	  }
}
  /**
  * @brief This function delete the records in fuel_efficiency_records.bin.
  *
  *
  * @return 0 on success.
  * @return -1 on fail.
  */
  public int DeleteFuelEfficiencyRecord(int lineNumberToDelete,String fileName) {
	  if(FileLineDelete(fileName, lineNumberToDelete) == 0) {
	      return 0;
      } 
	  else {
	    return -1;
      }
   }
}
  
