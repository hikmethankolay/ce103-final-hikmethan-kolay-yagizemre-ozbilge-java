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
import java.io.*;
import java.util.Scanner;

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
          String login_menu_text = "----------Login----------\n" +
                  "1-)Login\n" +
                  "2-)Register\n" +
                  "3-)Change Password\n" +
                  "4-)Exit\n" +
                  "Make a choice(1-4): \n";
          	System.out.print(login_menu_text);
            try {
            	login_menu = (args != null && args.length > 0) ? Integer.valueOf(loop_count == 0 ? args[0] : args[args.length - 1]) : Integer.valueOf(scanner.next());
            }
            catch(NumberFormatException e) {
            	System.out.print("Please use an integer\n");
            	loop_count++;
            	continue;
            }
            loop_count++;
          CarMaintenance car = new CarMaintenance();
          if(login_menu == 1){
        	  System.out.print("Please enter username:\n");
        	  username = ((args != null && args.length > 0) ? args[1] : scanner.next());
        	  System.out.print("Please enter password:\n");
        	  password = ((args != null && args.length > 0) ? args[2] : scanner.next());
        	  
              if (car.UserLogin(username, password,"user.bin") == 0) {
                  boolean run_2 = true;
                  int main_loop_count = 0;
                  do {
                      if (new File("maintenance_reminder_records.bin").exists()&& reminder_count == 0) {
                          System.out.print("\n------------You Have Scheduled Maintenance-------------");
                          car.FileRead("maintenance_reminder_records.bin");
                          System.out.print("-------------------------------------------------------");
                          reminder_count++;
                      }
                	  String vehicleModel;
                      int serviceKm;
                      String serviceProvider;
                      int serviceCost;
                      int lineNumberToEdit;
                      int lineNumberToDelete;
                      String carModel;
                      
                      
                      String main_menu_text = "----------Main Menu----------\n" +
                              "1-)Service History Tracking\n" +
                              "2-)Maintenance Reminders\n" +
                              "3-)Expense Logging\n" +
                              "4-)Fuel Efficiency Reports\n" +
                              "5-)Back to login menu\n" +
                              "Make a choice(1-5): \n";
                      System.out.print(main_menu_text);
                      
                      main_menu = (args != null && args.length > 0) ? Integer.valueOf(main_loop_count == 0 ? args[3] : args[args.length - 2]) : scanner.nextInt();
                      main_loop_count++;
                      
                      if(main_menu == 1) {

                          String service_menu_text = "----------Service History Tracking----------\n" +
                                  "1-)Show Service History Record\n" +
                                  "2-)Register Service History Record\n" +
                                  "3-)Edit Service History Record\n" +
                                  "4-)Delete Service History Record\n" +
                                  "5-)Previous Menu\n" +
                                  "Make a choice(1-5): \n";
                          System.out.print(service_menu_text);

                          service_menu = ((args != null && args.length > 0) ? Integer.valueOf(args[4]) : Integer.valueOf(scanner.next()));

                          if (service_menu == 1) {
                              System.out.print("-------------------------------------------------------\n");
                              car.FileRead("service_history_records.bin");
                              System.out.print("-------------------------------------------------------\n");
                              continue;
                          } else if (service_menu == 2) {
                              System.out.print("What is the model of vehicle?\n");
                              vehicleModel = ((args != null && args.length > 0) ? args[5] : scanner.next());

                              System.out.print("What is the service KM?\n");
                              try {
                            	  serviceKm = ((args != null && args.length > 0) ? Integer.valueOf(args[6]) : Integer.valueOf(scanner.next()));
                              }
                              catch(NumberFormatException e) {
                    	            System.out.print("Please use an integer\n");
                      	            continue;
                              }
                              

                              System.out.print("Who is the service provider?\n");
                              serviceProvider = ((args != null && args.length > 0) ? args[7] : scanner.next());

                              System.out.print("What is the service cost?\n");
                              try {
                            	  serviceCost = ((args != null && args.length > 0) ? Integer.valueOf(args[8]) : Integer.valueOf(scanner.next()));
                              }
                              catch(NumberFormatException e) {
                    	            System.out.print("Please use an integer\n");
                      	            continue;
                              }

                              car.RegisterServiceHistoryRecord(vehicleModel, serviceKm, serviceProvider, serviceCost,"service_history_records.bin");
                              continue;
                          } else if (service_menu == 3) {
                              System.out.print("Which line do you want to edit?\n");
                              try {
                            	  lineNumberToEdit = ((args != null && args.length > 0) ? Integer.valueOf(args[5]) : Integer.valueOf(scanner.next()));
                              }
                              catch(NumberFormatException e) {
                    	            System.out.print("Please use an integer\n");
                      	            continue;
                              }

                              System.out.print("What is the model of vehicle?\n");
                              vehicleModel = ((args != null && args.length > 0) ? args[6] : scanner.next());

                              System.out.print("What is the service KM?\n");
                              try {
                            	  serviceKm = ((args != null && args.length > 0) ? Integer.valueOf(args[7]) : Integer.valueOf(scanner.next()));
                              }
                              catch(NumberFormatException e) {
                    	            System.out.print("Please use an integer\n");
                      	            continue;
                              }
                              

                              System.out.print("Who is the service provider?\n");
                              serviceProvider = ((args != null && args.length > 0) ? args[8] : scanner.next());

                              System.out.print("What is the service cost?\n");
                              try {
                            	  serviceCost = ((args != null && args.length > 0) ? Integer.valueOf(args[9]) : Integer.valueOf(scanner.next()));
                              }
                              catch(NumberFormatException e) {
                    	            System.out.print("Please use an integer\n");
                      	            continue;
                              }
                              car.EditServiceHistoryRecord(lineNumberToEdit, vehicleModel, serviceKm, serviceProvider, serviceCost,"service_history_records.bin");
                              continue;
                          } else if (service_menu == 4) {
                              System.out.print("Which line do you want to delete?\n");
                              try {
                            	  lineNumberToDelete = ((args != null && args.length > 0) ? Integer.valueOf(args[5]) : Integer.valueOf(scanner.next()));
                              }
                              catch(NumberFormatException e) {
                    	            System.out.print("Please use an integer\n");
                      	            continue;
                              }
                              car.DeleteServiceHistoryRecord(lineNumberToDelete,"service_history_records.bin");
                              continue;
                          }else {
                              continue;
                          }
                      }
                      else if(main_menu == 2) {
                    	  String serviceType;
                    	  
                          String maintenance_reminder_menu_text = "----------Maintenance Reminder Records----------\n" +
                                  "1-)Show Maintenance Reminder Records\n" +
                                  "2-)Register Maintenance Reminder Records\n" +
                                  "3-)Edit Maintenance Reminder Records\n" +
                                  "4-)Delete Maintenance Reminder Records\n" +
                                  "5-)Previous Menu\n" +
                                  "Make a choice(1-5): \n";
                          System.out.print(maintenance_reminder_menu_text);
                          
                  	    maintenance_reminder_menu = ((args != null && args.length > 0) ? Integer.valueOf(args[4]) : Integer.valueOf(scanner.next()));

                  	    if (maintenance_reminder_menu == 1) {
                  	        System.out.print("-------------------------------------------------------");
                  	        car.FileRead("maintenance_reminder_records.bin");
                  	        System.out.print("-------------------------------------------------------");
                  	        continue;
                  	    } else if (maintenance_reminder_menu == 2) {
                  	        System.out.print("What is the model of vehicle?\n");
                  	        vehicleModel = ((args != null && args.length > 0) ? args[5] : scanner.next());

                  	        System.out.print("What is the service KM?\n");
                            try {
                            	serviceKm = ((args != null && args.length > 0) ? Integer.valueOf(args[6]) : Integer.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }

                  	        System.out.print("Who is the planned service type?\n");
                  	        serviceType = ((args != null && args.length > 0) ? args[7] : scanner.next());

                  	        car.RegisterMaintenanceReminderRecord(vehicleModel, serviceKm, serviceType,"maintenance_reminder_records.bin");
                  	        continue;
                  	    } else if (maintenance_reminder_menu == 3) {
                  	        System.out.print("Which do you want to edit\n");
                            try {
                            	lineNumberToEdit = ((args != null && args.length > 0) ? Integer.valueOf(args[5]) : Integer.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }

                  	        System.out.print("What is the model of vehicle?\n");
                  	        vehicleModel = ((args != null && args.length > 0) ? args[6] : scanner.next());

                  	        System.out.print("What is the service KM?\n");
                            try {
                            	serviceKm = ((args != null && args.length > 0) ? Integer.valueOf(args[7]) : Integer.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }

                  	        System.out.print("Who is the planned service type?\n");
                  	        serviceType = ((args != null && args.length > 0) ? args[8] : scanner.next());
                  	        car.EditMaintenanceReminderRecord(lineNumberToEdit, vehicleModel, serviceKm, serviceType,"maintenance_reminder_records.bin");
                  	        continue;
                  	    } else if (maintenance_reminder_menu == 4) {
                  	        System.out.print("Which line do you want to delete?\n");
                            try {
                            	lineNumberToDelete = ((args != null && args.length > 0) ? Integer.valueOf(args[5]) : Integer.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }
                  	        car.DeleteMaintenanceReminderRecord(lineNumberToDelete,"maintenance_reminder_records.bin");
                  	        continue;
                  	    }else {
                  	        continue;
                  	    }
                      }
                      else if(main_menu == 3) {
                  	    String expenseType;
                  	    String expenseDate;
                  	    int expense;
                  	    
                        String expense_menu_text = "----------Expense Tracking Records----------\n" +
                                "1-)Show Expense Tracking Records\n" +
                                "2-)Register Expense Tracking Records\n" +
                                "3-)Edit Expense Tracking Records\n" +
                                "4-)Delete Expense Tracking Records\n" +
                                "5-)Previous Menu\n" +
                                "Make a choice(1-5): \n";
                        System.out.print(expense_menu_text);
                        
                  	    expense_menu = ((args != null && args.length > 0) ? Integer.valueOf(args[4]) : Integer.valueOf(scanner.next()));

                  	    if (expense_menu == 1) {
                  	        System.out.print("-------------------------------------------------------");
                  	        car.FileRead("expense_logging_records.bin");
                  	        System.out.print("-------------------------------------------------------");
                  	        continue;
                  	    } else if (expense_menu == 2) {
                  	        System.out.print("What is the model of the car?\n");
                  	        carModel = ((args != null && args.length > 0) ? args[5] : scanner.next());
                  	        
                  	        System.out.print("What is the expense date?\n");
                  	        expenseDate = ((args != null && args.length > 0) ? args[6] : scanner.next());
                  	        
                  	        System.out.print("What is the expense type?\n");
                  	        expenseType = ((args != null && args.length > 0) ? args[7] : scanner.next());
                  	        
                  	        System.out.print("How much is the expense?\n");
                            try {
                            	expense = ((args != null && args.length > 0) ? Integer.valueOf(args[8]) : Integer.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }
                  	        car.RegisterExpenseRecord(carModel, expenseDate, expenseType, expense,"expense_logging_records.bin");
                  	        continue;
                  	    } else if (expense_menu == 3) {
                  	        System.out.print("Which line do you want to edit\n");
                            try {
                            	lineNumberToEdit = ((args != null && args.length > 0) ? Integer.valueOf(args[5]) : Integer.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }
                  	        System.out.print("What is the model of the car?\n");
                  	        carModel = ((args != null && args.length > 0) ? args[6] : scanner.next());
                  	        
                  	        System.out.print("What is the expense date?\n");
                  	        expenseDate = ((args != null && args.length > 0) ? args[7] : scanner.next());
                  	        
                  	        System.out.print("What is the expense type?\n");
                  	        expenseType = ((args != null && args.length > 0) ? args[8] : scanner.next());
                  	        
                  	        System.out.print("How much is the expense?\n");
                            try {
                            	expense = ((args != null && args.length > 0) ? Integer.valueOf(args[9]) : Integer.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }
                  	        car.EditExpenseRecord(lineNumberToEdit, carModel, expenseDate, expenseType, expense,"expense_logging_records.bin");
                  	        continue;
                  	    } else if (expense_menu == 4) {
                  	        System.out.print("Which line do you want to delete?\n");
                            try {
                            	lineNumberToDelete = ((args != null && args.length > 0) ? Integer.valueOf(args[5]) : Integer.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }
                  	        car.DeleteExpenseRecord(lineNumberToDelete,"expense_logging_records.bin");
                  	        continue;
                  	    }else {
                  	        continue;
                  	    }
                      }
                      else if(main_menu == 4) {
                    	  float fuelConsumed;
                  	    float roadTraveled;
                  	    
                        String fuel_efficiency_menu_text = "----------Fuel Efficiency Records----------\n" +
                                "1-)Show Fuel Efficiency Records\n" +
                                "2-)Register Fuel Efficiency Records\n" +
                                "3-)Edit Fuel Efficiency Records\n" +
                                "4-)Delete Fuel Efficiency Records\n" +
                                "5-)Previous Menu\n" +
                                "Make a choice(1-5): \n";
                        System.out.print(fuel_efficiency_menu_text);

                  	    fuel_efficiency_menu = ((args != null && args.length > 0) ? Integer.valueOf(args[4]) : Integer.valueOf(scanner.next()));

                  	    if (fuel_efficiency_menu == 1) {
                  	        System.out.print("-------------------------------------------------------");
                  	        car.FileRead("fuel_efficiency_records.bin");
                  	        System.out.print("-------------------------------------------------------");
                  	        continue;
                  	    } else if (fuel_efficiency_menu == 2) {
                  	        System.out.print("What is the model of the car?\n");
                  	        carModel = ((args != null && args.length > 0) ? args[8] : scanner.next());
                            try {
                            	fuelConsumed = ((args != null && args.length > 0) ? Float.valueOf(args[5]) : Float.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }

                            try {
                            	roadTraveled = ((args != null && args.length > 0) ? Float.valueOf(args[6]) : Float.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }
                  	        car.RegisterFuelEfficiencyRecord(carModel, fuelConsumed, roadTraveled,"fuel_efficiency_records.bin");
                  	        continue;
                  	    } else if (fuel_efficiency_menu == 3) {
                  	        System.out.print("Which do you want to edit?\n");
                            try {
                            	lineNumberToEdit = ((args != null && args.length > 0) ? Integer.valueOf(args[5]) : Integer.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }
                  	        System.out.print("What is the model of the car?\n");
                  	        carModel = ((args != null && args.length > 0) ? args[8] : scanner.next());
                            try {
                            	fuelConsumed = ((args != null && args.length > 0) ? Float.valueOf(args[6]) : Float.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }

                            try {
                            	roadTraveled = ((args != null && args.length > 0) ? Float.valueOf(args[7]) : Float.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }
                  	        car.EditFuelEfficiencyRecord(lineNumberToEdit, carModel, fuelConsumed, roadTraveled,"fuel_efficiency_records.bin");
                  	        continue;
                  	    } else if (fuel_efficiency_menu == 4) {
                  	        System.out.print("Which line do you want to delete?\n");
                            try {
                            	lineNumberToDelete = ((args != null && args.length > 0) ? Integer.valueOf(args[5]) : Integer.valueOf(scanner.next()));
                            }
                            catch(NumberFormatException e) {
                  	            System.out.print("Please use an integer\n");
                    	            continue;
                            }
                  	        car.DeleteFuelEfficiencyRecord(lineNumberToDelete,"fuel_efficiency_records.bin");
                  	        continue;
                  	    }else {
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
              System.out.print("Do you understand that if you create a new account all the records that have been saved so far will be deleted?[Y/N]: \n");
              choice = ((args != null && args.length > 0) ? args[1] : scanner.next());
              if (choice.equals("Y")) {
                  System.out.print("Please enter a new username:\n");
                  newUsername = ((args != null && args.length > 0) ? args[2] : scanner.next());
                  System.out.print("Please enter a new password:\n");
                  newPassword = ((args != null && args.length > 0) ? args[3] : scanner.next());
                  System.out.print("\nWARNING!!!\nYou will use this to change password if needed, if you lost this you can't access logs without them being completely deleted\nWARNING!!!\n");
                  System.out.print("Please enter a new recovery key:\n");
                  newRecoveryKey = ((args != null && args.length > 0) ? args[4] : scanner.next());
                  car.UserRegister(newUsername, newPassword, newRecoveryKey,"user.bin");
              }

              continue;
          }
          else if(login_menu == 3) {
              String recoveryKey;
              String changedPassword;

              System.out.print("Please enter your recovery key:\n");
              recoveryKey = ((args != null && args.length > 0) ? args[1] : scanner.next());

              System.out.print("Please enter a new password:\n");
              changedPassword = ((args != null && args.length > 0) ? args[2] : scanner.next());

              car.UserChangePassword(recoveryKey, changedPassword,"user.bin");
              continue;
          }
          else if(login_menu == 4) {
              run = false;
              break;
          }
          else {
        	  System.out.print("Please enter a correct choice!\n");
        	  continue;
          }
      } while (run);

      scanner.close();
  }
  
}
