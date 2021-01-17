package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("DimtirsTheodoropoulos", "1");
        bankAccount.showMenu();
    }

    static class BankAccount {
        int balance;
        int previousTransaction;
        String customerName;
        String customerId;

        BankAccount(String cname, String cid) {
             customerName = cname;
             customerId = cid;
        }

        void deposit(int amount) {
            if (amount != 0) {
                balance += amount;
                previousTransaction = amount;

            }
        }

        void withdraw(int amount) {
            if (balance > amount) {
                balance -= amount;
                previousTransaction = -amount;
            } else {
                System.out.println("Not enough money!");
            }
        }

        void getPreviousTransaction(int amount) {
            if (amount > 0) {
                System.out.println("Added " + previousTransaction);
            } else if (amount < 0) {
                System.out.println("Withdrew" + Math.abs(previousTransaction));
            } else {
                System.out.println(
                        "0 transactions yet."
                );
            }
        }

        void showMenu() {
            char option = '\0';
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome " + customerName);
            System.out.println("Your id is: " + customerId);
            System.out.println("\n");
            System.out.println("A. Check balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous transaction");
            System.out.println("E. Exit");

            boolean leaving = false;
            do {

                System.out.println("=======================");
                System.out.println("Enter an option");
                option = scanner.next().charAt(0);
                System.out.println("\n");

                switch(option) {
                    case 'A':
                        System.out.println("Balance " + balance);
                        break;

                    case 'B':
                        System.out.println("Enter the amount");
                        int amount2 = scanner.nextInt();
                        deposit(amount2);
                        break;

                    case 'C':
                        System.out.println("Enter the amount");
                        amount2 = scanner.nextInt();
                        withdraw(amount2);
                        break;

                    case 'D':
                        getPreviousTransaction(previousTransaction);
                        break;

                    case 'E':
                        System.out.println("Exiting...");
                        leaving = true;
                        break;

                    default:
                        System.out.println("Invalid option please enter again");
                        break;
                }

            } while (!leaving);

            System.out.println("Thank you for using our bank!");
        }
    }
}
