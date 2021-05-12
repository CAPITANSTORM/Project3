/*
Chase Alexander
Project 3
5/11/21
 */

package com.company;

import java.util.*;
import java.util.Scanner;

public class Main {

    static void menu() {
        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(5) List all tasks of a certain priority.");
        System.out.println("(0) Exit.");
    }

    static ArrayList<item> addATask(ArrayList<item> a) {
        Scanner input = new Scanner(System.in);
        item task = new item();

        System.out.println("Enter the new task's name: ");
        String title = input.nextLine();
        task.setTitle(title);

        System.out.println("Enter the new task's description: ");
        String description = input.nextLine();
        task.setDescription(description);

        System.out.println("Enter the new task's priority: ");
        int priority = input.nextInt();
        if (priority < 0) {
            priority = 0;
        }
        if (priority > 5) {
            priority = 5;
        }
        task.setPriority(priority);

        a.add(task);
        return a;
    }

    static ArrayList<item> removeTask(ArrayList<item> a) {

        int b;
        Scanner input = new Scanner(System.in);

        System.out.println("What task would you like to remove?");
        b = input.nextInt();
        a.remove(b);
        return a;
    }

    static ArrayList<item> updateTask(ArrayList<item> x) {
        Scanner input = new Scanner(System.in);
        int a;
        item task = new item();

        System.out.println("Please enter an index value of task to update: ");
        a = input.nextInt();
        input.nextLine();

        System.out.println("Enter the new task's name: ");
        String title = input.nextLine();
        task.setTitle(title);

        System.out.println("Enter the new task's description: ");
        String description = input.nextLine();
        task.setDescription(description);

        System.out.println("Enter the new task's priority: ");
        int priority = input.nextInt();
        input.nextLine();
        task.setPriority(priority);

        x.set(a, task);
        return x;
    }

    static void displayAllTasks(ArrayList<item> taskList) {
        Collections.sort(taskList); // Sorts the list before printing
        int i = 0;
        for (item a : taskList) {
            System.out.println(a);
            i++;
        }
    }
    static void displayPriority(ArrayList<item> taskList) {
        Scanner input = new Scanner(System.in);
        int i = 0;
        int priority;

        System.out.println("Enter a level of priority: ");
        priority = input.nextInt();
        if (priority < 0) {
            priority = 0;
        }
        if (priority > 5) {
            priority = 5;
        }

        for (item a : taskList) {
            if (priority == a.getPriority()) {
                System.out.println(a);
            }
            i++;
        }
    }
    static void exitProgram() {
        System.exit(0);
    }

    public static void main(String[] args) {
        ArrayList<item> taskList = new ArrayList<>();
        String userInput = "-1";

        while (!userInput.equals("0")) {
            Scanner input = new Scanner(System.in);
            try {
                menu();
                userInput = input.nextLine();


                switch (userInput) {
                    case "1":
                        addATask(taskList);
                        break;
                    case "2":
                        removeTask(taskList);
                        break;
                    case "3":
                        updateTask(taskList);
                        break;
                    case "4":
                        displayAllTasks(taskList);
                        break;
                    case "5":
                        displayPriority(taskList);
                        break;
                    case "0":
                        exitProgram();
                        break;
                    default:
                        System.out.println("Please enter a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type, please try again.");

            } catch (Exception e) {
                System.out.println("Something went wrong! Try again.");
            }
        }

    }
}