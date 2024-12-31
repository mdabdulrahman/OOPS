package com.taskscheduler;
import java.util.*;
import java.io.*;
public class Main {
	static Scanner sc  = new Scanner(System.in);
	static TaskHandler taskhandler = new TaskHandler();
	public static void addTask() {
		
		
		String name;
		System.out.println("Enter Task Name: ");
		sc.nextLine();
		name = sc.nextLine();
		
		int priority;
		System.out.println("Enter Task Priority : ");
		priority = sc.nextInt();
				
		int time;
		System.out.println("Enter Task Time : ");
		time = sc.nextInt();
		
		Task task = new Task(name,priority,time);
		
		taskhandler.addTask(task);
		System.out.println("Task Added Successfully !!");
	}
	public static void main(String[] args) {
		
	
		
		int query;
		
		System.out.println("-------- Welcome to the Task Scheduling System --------");
		
		while(true){
			
			System.out.println("1.Add Task\n2.View Tasks by Priority\n3.Simulate Task Execution\n4.Mark Task as Completed\n5.Calculate Total Time\n6.Exit");
			
			System.out.print("Enter Your Input : ");
			
			query = sc.nextInt();
			
			switch(query)
			{
			case 1:
				//add task
				addTask();
				break;
			case 2:
				//view task
				taskhandler.viewTasks();
				break;
			case 3:
				//simulate task
				taskhandler.simulateTask();
				break;
			case 4:
				//mark task as completed
				System.out.println("Enter Task id: ");
				taskhandler.markTaskAsCompleted(sc.nextInt());
				break;
			case 5:
				//calculate total time
				taskhandler.calculateTime();
				break;
			case 6:
				System.out.println("Terminated !!!");
			    return;
			default:
				System.out.println("Wrong Input Query !");
				break;
			}
		}

	}

}
