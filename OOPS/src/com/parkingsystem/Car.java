package com.parkingsystem;
import java.util.*;
public class Car {

	String regNo;
	String color;
	public Car(String regNo, String color) {
	
		this.regNo = regNo;
		this.color = color;
		
	}
	
	public static Car getDetails() {
		
		Scanner sc = new Scanner(System.in);
		
		String regNo;
        String color;
       
		System.out.println("Enter Register No: ");
		regNo = sc.next();
		
		System.out.println("Enter Car Color: ");
		color = sc.next();
		
		
		
		return new Car(regNo,color);
		
		
	}
	
}
