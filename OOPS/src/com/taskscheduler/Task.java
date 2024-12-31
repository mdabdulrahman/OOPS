package com.taskscheduler;

public class Task implements Comparable<Task>{
		
	   public static int taskCount = 0;
	   String name;
	   int priority;
	   int execution_time;
	   int id;
	   Task(String name,int priority,int execution_time){
		   this.name = name;
		   this.priority = priority;
		   this.execution_time = execution_time;
		   id = ++taskCount;
	   }
	   
	  @Override
	  public String toString()
	  {
		  return "[ ID : "+id+" , Task name: "+name+", Priority: "+priority+", Time : "+execution_time+" ]";
	  }
	   
	   public  int compare(Task t1, Task t2) {
	        return (t1.priority < t2.priority) ? -1 : ((t1.priority == t2.priority)&&t1.id < t2.id ? 0 : 1);
	    }


	@Override
	public int compareTo(Task o) {
		 return compare(this, o);
	}
}
