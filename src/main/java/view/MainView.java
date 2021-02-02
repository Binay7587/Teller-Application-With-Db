/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package view;

import controller.AccountHandler;
import controller.UserHandler;
import java.util.Scanner;

/**
 *
 * @author Binay
 */
public class MainView {

    public static AccountHandler ah = new AccountHandler();
    public static UserHandler us = new UserHandler();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch, a;
        boolean loginView = true;
        boolean z = false;
        while (loginView == true) {
            if (loginView()) {
                z = true;
                loginView = false;
            } else {
                z = false;
                System.out.println("Invalid Login.");
                System.out.println("press 0 to exit and any key to relogin.");
                a = sc.nextInt();
                if (a == 0) {
                    loginView = false;
                } else {
                    loginView = true;
                }
            }
        }
        while (z == true) {
            System.out.println("*************************************");
            System.out.println("welcome to Bank");
            System.out.println("Please select appropriate option.");
            System.out.println("1) Add Account");
            System.out.println("2) Check Amount");
            System.out.println("3) Deposit Amount");
            System.out.println("4) Withdraw Amount");
            System.out.println("5) Delete Account");
            System.out.println("6) List Account");
            System.out.println("7) Add User");
            System.out.println("8) List Users");
            System.out.println("9) Delete User");
            System.out.println("10) Logout");
            System.out.println("0) Exit");

            ch = sc.nextInt();
            switch (ch) {
                case 0:
                    System.out.println("Exiting from system. Have a nice day.");
                    z = false;
                    break;
                case 1:
                    addAccountView();
                    break;
                case 2:
                    checkAmountView();
                    break;
                case 3:
                    depositAmountView();
                    break;
                case 4:
                    withdrawAmountView();
                    break;
                case 5:
                    deleteAccountView();
                    break;
                case 6:
                    listAccountsView();
                    break;
                case 7:
                    addUserView();
                    break;
                case 8:
                    listUsersView();
                    break;
                case 9:
                    deleteUserView();
                    break;
                case 10:
                    logoutView();
                    break;
                default:
                    System.out.println("Please select appropriate option");
            }
        }
    }

    public static boolean loginView() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************Teller Application*****************");
        System.out.println("Enter username:");
        String uName = sc.nextLine();
        System.out.println("Enter password:");
        String uPassword = sc.nextLine();
        return us.login(uName, uPassword);
    }

    public static void addAccountView() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number:");
        int accNo = sc.nextInt();
        System.out.println("Enter account name:");
        String accName = sc.next();
        System.out.println("Enter opening balance:");
        int balance = sc.nextInt();
        if (ah.addAccount(accNo, accName, balance)) {
            System.out.println("Account added successfully.");
        } else {
            System.out.println("Account already exist.");
        }
    }

    public static void checkAmountView() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number:");
        int accNo = sc.nextInt();
        ah.checkAmount(accNo);
    }

    public static void depositAmountView() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number:");
        int accNo = sc.nextInt();
        System.out.println("Enter amount to deposit:");
        int amount = sc.nextInt();
        ah.depositAmount(accNo, amount);
    }

    public static void withdrawAmountView() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number:");
        int accNo = sc.nextInt();
        System.out.println("Enter amount to withdraw:");
        int withdrawBalance = sc.nextInt();
        int x = ah.withdrawAmount(accNo, withdrawBalance);
        if (x == 1) {
            System.out.println("Withdrawn successfull.:");
        } else if (x == -1) {
            System.out.println("Insufficient Balance.");
        } else {
            System.out.println("Account number is invalid.:");
        }
    }

    public static void transferAmountView() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sender account number:");
        int accNo1 = sc.nextInt();
        System.out.println("Enter sender account number:");
        int accNo2 = sc.nextInt();
        System.out.println("Enter transfer amount::");
        int transferAmount = sc.nextInt();
        int x = ah.transferAmount(accNo1, accNo2, transferAmount);
        if (x == 1) {
            System.out.println("Transfer successfull.:");
        } else if (x == -1) {
            System.out.println("Insufficient Balance.");
        } else {
            System.out.println("Account number is invalid.");
        }
    }

    public static void deleteAccountView() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number:");
        int accNo = sc.nextInt();
        int x = ah.deleteAccount(accNo);
        if (x == 1) {
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account number is invalid");
        }
    }

    public static void listAccountsView() {
        ah.listAccount();
    }

    public static void addUserView() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String uName = sc.next();
        System.out.println("Enter user password:");
        String uPass = sc.next();
        System.out.println("Confirm password:");
        String cPass = sc.next();
        if (uPass.equals(cPass)) {
            if (us.addUser(uName, uPass)) {
                System.out.println("User added successfully.");
            } else {
                System.out.println("User already exist.");
            }
        } else {
            System.out.println("Confirm password doesn't match.");
        }
    }

    public static void listUsersView() {
        us.listUsers();
    }

    public static void deleteUserView() {
        System.out.println("Please login again to delete user");
        if (loginView()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter username to delete:");
            String uName = sc.next();
            int x = us.deleteUser(uName);
            if (x == 1) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("Username is invalid");
            }
        } else {
            System.out.println("Invalid login");
        }
    }

    public static void logoutView() {
//        this.z = false;
//        this.loginView =  true;
    }
}
