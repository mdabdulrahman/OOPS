package com.taskscheduler;
import java.util.*;
import java.io.*;
public class TaskHandler {
		
	Scanner sc = new Scanner(System.in);
    public Queue<Task> tasks = new PriorityQueue<>(); 
	public void addTask(Task newTask) {
		
		tasks.add(newTask);
		
		System.out.println("Task Added: "+newTask);
		//System.out.println(tasks.poll().priority);
	}
	
	public void viewTasks() {
		
	    
		int op =0;
		Queue<Task> temp = new PriorityQueue<>();
		while(!tasks.isEmpty()) {
			
			Task task = tasks.poll();
			if(op!=task.priority) {
				System.out.println("Priority "+task.priority);
				System.out.println("------------------------");
				op = task.priority;
			}
			temp.add(task);
			System.out.println(task);
			}
		tasks = temp;
	
		
	}
    
	public void simulateTask() {
		
		Queue<Task> temp = new PriorityQueue<>();
		
		while(!tasks.isEmpty())
		{
			Task currTask = tasks.poll();
			temp.add(currTask);
			for( int i = currTask.execution_time-1; i>=0; i--) {

				System.out.println("Executing Task: "+currTask.name+" , Remaining Time: "+(i==0?"Completed":i));
				
			}
			
		}
		tasks= temp;
	}
	
	public void calculateTime() {
		
		Iterator<Task> it = tasks.iterator();
		
		int totTime = 0;
		
		while(it.hasNext()) {
			totTime += it.next().execution_time;
		}
		
		System.out.println("Total Time : "+totTime);
	}
	
	public void markTaskAsCompleted(int id) {
		
		Iterator<Task> it = tasks.iterator();
		
		while(it.hasNext()) {
			Task task = it.next();
			if( task.id == id) {
				
			 tasks.remove(task);
			 System.out.println("Removed Task: "+task);
			 return;
			 }
		}
	}
}
