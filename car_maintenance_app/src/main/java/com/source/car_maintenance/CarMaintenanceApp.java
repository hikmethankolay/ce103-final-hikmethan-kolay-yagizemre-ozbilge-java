/**
 * @file CarMaintenanceApp.java
 * @brief This file serves as the main application file for the Car Maintenance App.
 * @details This file contains the entry point of the application, which is the main method. It initializes the necessary components and executes the Car Maintenance App.
 * 
*/

/**
 * 
 * @package com.source.car_maintenance
 * @brief The com.source.car_maintenance package contains all the classes and files related to the Car Maintenance App.
 * 
*/
package com.source.car_maintenance;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;

/**
 *
 * @class CarMaintenanceApp
 * @brief This class represents the main application class for the Car Maintenance
 *        App.
 * @details The CarMaintenance class provides the entry point for the Car Maintenance
 *          App. It initializes the necessary components, and handles exceptions.
 * @author Hikmethan KOLAY
 * @author Yagiz Emre OZBILGE
 */
public class CarMaintenanceApp {
  /**
   * @brief Logger for the Car MaintenanceApp class.
   */
  private static final Logger logger = (Logger) LoggerFactory.getLogger(CarMaintenanceApp.class);

  /**
   * @brief The main entry point of the Car Maintenance App.
   *
   * @details The main method is the starting point of the Car Maintenance App. It
   *          initializes the logger, performs logging, displays a greeting
   *          message, and handles user input.
   *
   * @param args The command-line arguments passed to the application.
   */
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int login_menu;
      int main_menu;
      int service_menu;
      int maintenance_reminder_menu;
      int expense_menu;
      int fuel_efficiency_menu;
      int reminder_count = 0;
      boolean run = true;
      String newUsername;
      String newPassword;
      String newRecoveryKey;
      String choice;
      String username;
      String password;
      int loop_count = 0;

      do {
          String Output = "----------Login----------\n" +
                  "1-)Login\n" +
                  "2-)Register\n" +
                  "3-)Change Password\n" +
                  "4-)Exit\n" +
                  "Make a choice(1-4): \n";
          	System.out.print(Output);
          	login_menu = (args != null && args.length > 0) ? Integer.valueOf(loop_count == 0 ? args[0] : args[args.length - 1]) : scanner.nextInt();
          	loop_count++;
          	
          CarMaintenance car = new CarMaintenance();
          if(login_menu == 1){
        	  System.out.print("Please enter username:\n");
        	  username = ((args != null && args.length > 0) ? args[1] : scanner.next());
        	  System.out.print("Please enter password:\n");
        	  password = ((args != null && args.length > 0) ? args[2] : scanner.next());
              if (car.UserLogin(username, password,"user.bin") == 0) {
                  boolean run_2 = true;

                  do {
                      if (new File("maintenance_reminder_records.bin").exists()&& reminder_count == 0) {
                          System.out.println("\n------------You Have Scheduled Maintenance-------------");
                          car.FileRead("maintenance_reminder_records.bin");
                          System.out.println("-------------------------------------------------------");
                          reminder_count++;
                      }
                	  String vehicleModel;
                      int serviceKm;
                      String serviceProvider;
                      int serviceCost;
                      int lineNumberToEdit;
                      int lineNumberToDelete;
                      String carModel;
                      
                      System.out.println("\n----------Main Menu----------");
                      System.out.println("1-)Service History Tracking");
                      System.out.println("2-)Maintenance Reminders");
                      System.out.println("3-)Expense Logging");
                      System.out.println("4-)Fuel Efficiency Reports");
                      System.out.println("5-)Back to login menu");
                      System.out.print("Make a choice(1-5): ");
                      main_menu = scanner.nextInt();
                      if(main_menu == 1) {


                          System.out.println("\n----------Service History Tracking----------");
                          System.out.println("1-)Show Service History Record");
                          System.out.println("2-)Register Service History Record");
                          System.out.println("3-)Edit Service History Record");
                          System.out.println("4-)Delete Service History Record");
                          System.out.println("5-)Previous Menu");
                          System.out.print("Make a choice(1-5): ");
                          service_menu = scanner.nextInt();

                          if (service_menu == 1) {
                              System.out.println("-------------------------------------------------------");
                              car.FileRead("service_history_records.bin");
                              System.out.println("-------------------------------------------------------");
                              continue;
                          } else if (service_menu == 2) {
                              System.out.print("What is the model of vehicle? ");
                              vehicleModel = scanner.next();

                              System.out.print("What is the service KM? ");
                              serviceKm = scanner.nextInt();

                              System.out.print("Who is the service provider? ");
                              serviceProvider = scanner.next();

                              System.out.print("What is the service cost? ");
                              serviceCost = scanner.nextInt();

                              car.RegisterServiceHistoryRecord(vehicleModel, serviceKm, serviceProvider, serviceCost,"service_history_records.bin");
                              continue;
                          } else if (service_menu == 3) {
                              System.out.print("Which line do you want to edit? ");
                              lineNumberToEdit = scanner.nextInt();

                              System.out.print("What is the model of vehicle? ");
                              vehicleModel = scanner.next();

                              System.out.print("What is the service KM? ");
                              serviceKm = scanner.nextInt();

                              System.out.print("Who is the service provider? ");
                              serviceProvider = scanner.next();

                              System.out.print("What is the service cost? ");
                              serviceCost = scanner.nextInt();

                              car.EditServiceHistoryRecord(lineNumberToEdit, vehicleModel, serviceKm, serviceProvider, serviceCost,"service_history_records.bin");
                              continue;
                          } else if (service_menu == 4) {
                              System.out.print("Which line do you want to delete? ");
                              lineNumberToDelete = scanner.nextInt();

                              car.DeleteServiceHistoryRecord(lineNumberToDelete,"service_history_records.bin");
                              continue;
                          } else if (service_menu == 5) {
                              continue;
                          } else {
                              continue;
                          }
                      }
                      else if(main_menu == 2) {
                    	  String serviceType;

                  	    System.out.println("\n----------Maintenance Reminder Records----------");
                  	    System.out.println("1-)Show Maintenance Reminder Records");
                  	    System.out.println("2-)Register Maintenance Reminder Records");
                  	    System.out.println("3-)Edit Maintenance Reminder Records");
                  	    System.out.println("4-)Delete Maintenance Reminder Records");
                  	    System.out.println("5-)Previous Menu");
                  	    System.out.print("Make a choice(1-5): ");
                  	    maintenance_reminder_menu = scanner.nextInt();

                  	    if (maintenance_reminder_menu == 1) {
                  	        System.out.println("-------------------------------------------------------");
                  	        car.FileRead("maintenance_reminder_records.bin");
                  	        System.out.println("-------------------------------------------------------");
                  	        continue;
                  	    } else if (maintenance_reminder_menu == 2) {
                  	        System.out.print("What is the model of vehicle? ");
                  	        vehicleModel = scanner.next();

                  	        System.out.print("What is the service KM? ");
                  	        if (!scanner.hasNextInt()) {
                  	            System.out.println("Please use an integer");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }
                  	        serviceKm = scanner.nextInt();

                  	        System.out.print("Who is the planned service type? ");
                  	        serviceType = scanner.next();

                  	        car.RegisterMaintenanceReminderRecord(vehicleModel, serviceKm, serviceType,"maintenance_reminder_records.bin");
                  	        continue;
                  	    } else if (maintenance_reminder_menu == 3) {
                  	        System.out.println("Which do you want to edit");
                  	        if (!scanner.hasNextInt()) {
                  	            System.out.println("Please use an integer");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }
                  	        lineNumberToEdit = scanner.nextInt();

                  	        System.out.print("What is the model of vehicle? ");
                  	        vehicleModel = scanner.next();

                  	        System.out.print("What is the service KM? ");
                  	        if (!scanner.hasNextInt()) {
                  	            System.out.println("Please use an integer");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }
                  	        serviceKm = scanner.nextInt();

                  	        System.out.print("Who is the planned service type? ");
                  	        serviceType = scanner.next();
                  	        car.EditMaintenanceReminderRecord(lineNumberToEdit, vehicleModel, serviceKm, serviceType,"maintenance_reminder_records.bin");
                  	        continue;
                  	    } else if (maintenance_reminder_menu == 4) {
                  	        System.out.print("Which line do you want to delete? ");
                  	        if (!scanner.hasNextInt()) {
                  	            System.out.println("Please use an integer.");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }
                  	        lineNumberToDelete = scanner.nextInt();
                  	        car.DeleteMaintenanceReminderRecord(lineNumberToDelete,"maintenance_reminder_records.bin");
                  	        continue;
                  	    } else if (maintenance_reminder_menu == 5) {
                  	        continue;
                  	    } else {
                  	        continue;
                  	    }
                      }
                      else if(main_menu == 3) {
                  	    String expenseType;
                  	    String expenseDate;
                  	    int expense;

                  	    System.out.println("\n----------Expense Tracking Records----------");
                  	    System.out.println("1-)Show Expense Tracking Records");
                  	    System.out.println("2-)Register Expense Tracking Records");
                  	    System.out.println("3-)Edit Expense Tracking Records");
                  	    System.out.println("4-)Delete Expense Tracking Records");
                  	    System.out.println("5-)Previous Menu");
                  	    System.out.print("Make a choice(1-5): ");
                  	    expense_menu = scanner.nextInt();

                  	    if (expense_menu == 1) {
                  	        System.out.println("-------------------------------------------------------");
                  	        car.FileRead("expense_logging_records.bin");
                  	        System.out.println("-------------------------------------------------------");
                  	        continue;
                  	    } else if (expense_menu == 2) {
                  	        System.out.println("What is the model of the car?");
                  	        carModel = scanner.next();
                  	        System.out.println("What is the expense date?");
                  	        expenseDate = scanner.next();
                  	        System.out.println("What is the expense type?");
                  	        expenseType = scanner.next();
                  	        System.out.println("How much is the expense?");
                  	        if (!scanner.hasNextInt()) {
                  	            System.out.println("Please use an integer");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }

                  	        expense = scanner.nextInt();
                  	        car.RegisterExpenseRecord(carModel, expenseDate, expenseType, expense,"expense_logging_records.bin");
                  	        continue;
                  	    } else if (expense_menu == 3) {
                  	        System.out.println("Which do you want to edit");
                  	        if (!scanner.hasNextInt()) {
                  	            System.out.println("Please use an integer");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }
                  	        lineNumberToEdit = scanner.nextInt();
                  	        System.out.println("What is the model of the car?");
                  	        carModel = scanner.next();
                  	        System.out.println("What is the expense date?");
                  	        expenseDate = scanner.next();
                  	        System.out.println("What is the expenseType");
                  	        expenseType = scanner.next();
                  	        System.out.println("How much is the expense?");
                  	        if (!scanner.hasNextInt()) {
                  	            System.out.println("Please use an integer");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }

                  	        expense = scanner.nextInt();
                  	        car.EditExpenseRecord(lineNumberToEdit, carModel, expenseDate, expenseType, expense,"expense_logging_records.bin");
                  	        continue;
                  	    } else if (expense_menu == 4) {
                  	        System.out.print("Which line do you want to delete? ");
                  	        if (!scanner.hasNextInt()) {
                  	            System.out.println("Please use an integer.");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }

                  	        lineNumberToDelete = scanner.nextInt();
                  	        car.DeleteExpenseRecord(lineNumberToDelete,"expense_logging_records.bin");
                  	        continue;
                  	    } else if (expense_menu == 5) {
                  	        continue;
                  	    } else {
                  	        continue;
                  	    }
                      }
                      else if(main_menu == 4) {
                    	  float fuelConsumed;
                  	    float roadTraveled;

                  	    System.out.println("\n----------Fuel Efficiency Records----------");
                  	    System.out.println("1-)Show Fuel Efficiency Records");
                  	    System.out.println("2-)Register Fuel Efficiency Records");
                  	    System.out.println("3-)Edit Fuel Efficiency Records");
                  	    System.out.println("4-)Delete Fuel Efficiency Records");
                  	    System.out.println("5-)Previous Menu");
                  	    System.out.print("Make a choice(1-5): ");
                  	    fuel_efficiency_menu = scanner.nextInt();

                  	    if (fuel_efficiency_menu == 1) {
                  	        System.out.println("-------------------------------------------------------");
                  	        car.FileRead("fuel_efficiency_records.bin");
                  	        System.out.println("-------------------------------------------------------");
                  	        continue;
                  	    } else if (fuel_efficiency_menu == 2) {
                  	        System.out.println("What is the model of the car?");
                  	        carModel = scanner.next();

                  	        if (!scanner.hasNextFloat()) {
                  	            System.out.println("Please use a float for fuel consumed");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }

                  	        fuelConsumed = scanner.nextFloat();

                  	        if (!scanner.hasNextFloat()) {
                  	            System.out.println("Please use a float for road traveled");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }

                  	        roadTraveled = scanner.nextFloat();
                  	        car.RegisterFuelEfficiencyRecord(carModel, fuelConsumed, roadTraveled,"fuel_efficiency_records.bin");
                  	        continue;
                  	    } else if (fuel_efficiency_menu == 3) {
                  	        System.out.println("Which do you want to edit?");
                  	        if (!scanner.hasNextInt()) {
                  	            System.out.println("Please use an integer");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }

                  	        lineNumberToEdit = scanner.nextInt();

                  	        System.out.println("What is the model of the car?");
                  	        carModel = scanner.next();
                  	        System.out.println("What is the fuel consumed");

                  	        if (!scanner.hasNextFloat()) {
                  	            System.out.println("Please use a float");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }

                  	        fuelConsumed = scanner.nextFloat();
                  	        System.out.println("What is the road traveled");

                  	        if (!scanner.hasNextFloat()) {
                  	            System.out.println("Please use a float");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }

                  	        roadTraveled = scanner.nextFloat();
                  	        car.EditFuelEfficiencyRecord(lineNumberToEdit, carModel, fuelConsumed, roadTraveled,"fuel_efficiency_records.bin");
                  	        continue;
                  	    } else if (fuel_efficiency_menu == 4) {
                  	        System.out.print("Which line do you want to delete? ");
                  	        if (!scanner.hasNextInt()) {
                  	            System.out.println("Please use an integer.");
                  	            scanner.next(); // consume the invalid input
                  	            continue;
                  	        }

                  	        lineNumberToDelete = scanner.nextInt();
                  	        car.DeleteFuelEfficiencyRecord(lineNumberToDelete,"fuel_efficiency_records.bin");
                  	        continue;
                  	    } else if (fuel_efficiency_menu == 5) {
                  	        continue;
                  	    } else {
                  	        continue;
                  	    }

                      }
                      else if(main_menu == 5) {
                          run_2 = false;
                          break;
                      }
                      else {
                    	  System.out.print("Please enter a correct choice!");
                    	  continue;
                      }
                  } while (run_2);
              } else {
            	  continue;
              }
          }
          else if(login_menu == 2) {
              System.out.print("Do you understand that if you create a new account all the records that have been saved so far will be deleted?[Y/N]: ");
              choice = scanner.next();
              if (choice.equals("Y")) {
                  System.out.println("Please enter a new username: ");
                  newUsername = scanner.next();
                  System.out.println("Please enter a new password: ");
                  newPassword = scanner.next();
                  System.out.println("\nWARNING!!!\nYou will use this to change password if needed, if you lost this you can't access logs without them being completely deleted\nWARNING!!!\n");
                  System.out.println("Please enter a new recovery key: ");
                  newRecoveryKey = scanner.next();
                  car.UserRegister(newUsername, newPassword, newRecoveryKey,"user.bin");
              }

              continue;
          }
          else if(login_menu == 3) {
              String recoveryKey;
              String changedPassword;

              System.out.print("Please enter your recovery key: ");
              recoveryKey = scanner.next();

              System.out.print("Please enter a new password: ");
              changedPassword = scanner.next();

              car.UserChangePassword(recoveryKey, changedPassword,"user.bin");
              continue;
          }
          else if(login_menu == 4) {
              run = false;
              break;
          }
          else {
        	  System.out.print("Please enter a correct choice!");
        	  continue;
          }
      } while (run);

      scanner.close();
  }
  
}
